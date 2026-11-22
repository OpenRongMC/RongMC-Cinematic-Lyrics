# RongMC Cinematic Lyrics

[简体中文](./README.md) · English

Displays the current lyrics and available translations from MuoniumPlayer in the lower letterbox of Ji AFK Cinematic. Availability depends on the track and the data supplied by the player.

## Download and installation

- Version · [v0.1.1+26.3](https://github.com/OpenRongMC/RongMC-Cinematic-Lyrics/releases/tag/v0.1.1%2B26.3) (Release)
- Release asset · `rongmc-cinematic-lyrics-0.1.1.26.3.jar`
- Runtime · Minecraft Java 26.3, Fabric, Java 25
- Fabric Loader · `>=0.20.1`
- Fabric mod ID · `rongmc_cinematic_lyrics`
- Dependencies declared by the JAR · `ji-afk-cinematic` `2.4.0`

Place the release JAR in the instance’s `mods/` directory. Client-side. Use the Ji AFK Cinematic version required by the release and a compatible MuoniumPlayer build. Recheck the overlay when either host mod is upgraded.

## How to try it

Play a track known to have lyrics, trigger Cinematic mode and check lyric changes, translations and returning to normal UI. A track without lyrics should leave the overlay empty.

## Development

See [`build.sh`](./build.sh) for the build entry point. Check its workspace paths and dependencies before running it.

## Documentation and support

- [Previous README (historical guide, contributors and credits)](https://github.com/OpenRongMC/RongMC-Cinematic-Lyrics/blob/778c22400617b4bfaad18f3a1f5669ecde62b467/README.md)
- [Report a RongMC port issue](https://github.com/OpenRongMC/RongMC-Cinematic-Lyrics/issues) · Include the game version, client and server JAR names, reproduction steps and relevant logs.

## License and credits

See this repository’s [LICENSE](./LICENSE) and the original project’s license, credits and third-party asset notices.
