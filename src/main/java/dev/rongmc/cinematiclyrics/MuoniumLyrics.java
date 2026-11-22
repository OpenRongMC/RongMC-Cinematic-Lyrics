package dev.rongmc.cinematiclyrics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MuoniumLyrics {
    private static final Logger LOGGER = LoggerFactory.getLogger("RongMC Cinematic Lyrics");
    private static final String CLOUD_MUSIC = "com.muoniumplayer.core.ncm.music.CloudMusic";

    private boolean available = FabricLoader.getInstance().isModLoaded("muonium");
    private Field currentLyric;
    private Method matchesTrack;
    private Method original;
    private Method translation;

    public Subtitle read() {
        if (!available) {
            return null;
        }

        try {
            if (currentLyric == null) {
                Class<?> music = Class.forName(CLOUD_MUSIC, false, getClass().getClassLoader());
                currentLyric = music.getField("currentLyric");
                matchesTrack = music.getMethod("lyricsMatchCurrentTrack");
                original = currentLyric.getType().getMethod("getLyric");
                translation = currentLyric.getType().getMethod("getTranslationText");
            }

            Object line = currentLyric.get(null);
            if (line == null || !Boolean.TRUE.equals(matchesTrack.invoke(null))) {
                return null;
            }
            String text = (String) original.invoke(line);
            String translated = (String) translation.invoke(line);
            if (text == null || text.isBlank()) {
                return null;
            }
            return new Subtitle(text.strip(), translated == null ? "" : translated.strip());
        } catch (ReflectiveOperationException | LinkageError error) {
            available = false;
            LOGGER.warn("MuoniumPlayer lyrics could not be read. Check the installed MuoniumPlayer version.", error);
            return null;
        }
    }

    public record Subtitle(String original, String translation) {
        public boolean hasTranslation() {
            return !translation.isBlank() && !translation.equals(original);
        }
    }
}
