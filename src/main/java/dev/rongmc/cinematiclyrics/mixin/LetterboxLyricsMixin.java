package dev.rongmc.cinematiclyrics.mixin;

import dev.rongmc.cinematiclyrics.MuoniumLyrics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.ji.afkcinematic.render.LetterboxRenderer", remap = false)
abstract class LetterboxLyricsMixin {
    @Shadow private static volatile boolean cinematicActive;
    @Shadow private static volatile float progress;
    @Shadow @Final private static float BAR_RATIO;

    @Unique private static final MuoniumLyrics RONGMC_LYRICS = new MuoniumLyrics();

    @Inject(method = "render", at = @At("TAIL"))
    private static void rongmc$renderLyrics(GuiGraphicsExtractor graphics, CallbackInfo callback) {
        if (!cinematicActive || progress < 1) {
            return;
        }

        MuoniumLyrics.Subtitle subtitle = RONGMC_LYRICS.read();
        if (subtitle == null) {
            return;
        }

        Font font = Minecraft.getInstance().font;
        int height = graphics.guiHeight();
        int barHeight = Math.round(height * BAR_RATIO);
        if (barHeight < font.lineHeight + 4) {
            return;
        }
        boolean twoLines = subtitle.hasTranslation() && barHeight >= font.lineHeight * 2 + 4;
        int centerX = graphics.guiWidth() / 2;
        int maxWidth = Math.max(0, graphics.guiWidth() - 24);
        int lineCount = twoLines ? 2 : 1;
        int top = height - (barHeight + lineCount * font.lineHeight) / 2;
        graphics.centeredText(font, rongmc$fit(font, subtitle.original(), maxWidth), centerX, top, 0xFFFFFFFF);
        if (twoLines) {
            graphics.centeredText(font, rongmc$fit(font, subtitle.translation(), maxWidth),
                    centerX, top + font.lineHeight, 0xFFC8D4E4);
        }
    }

    @Unique
    private static String rongmc$fit(Font font, String text, int maxWidth) {
        String line = text.replaceAll("\\s+", " ");
        if (font.width(line) <= maxWidth) {
            return line;
        }
        String ellipsis = "…";
        return font.plainSubstrByWidth(line, Math.max(0, maxWidth - font.width(ellipsis))) + ellipsis;
    }
}
