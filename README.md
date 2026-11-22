# RongMC 过场歌词

简体中文 · [English](./README.en.md)

把 MuoniumPlayer 提供的当前歌词与可用译文放到 Ji AFK Cinematic 画面底部的遮幅上。显示取决于曲目有无歌词和播放器提供的数据。

## 下载与安装

- 版本 · [v0.1.1+26.3](https://github.com/OpenRongMC/RongMC-Cinematic-Lyrics/releases/tag/v0.1.1%2B26.3) (已发布)
- 下载文件 · `rongmc-cinematic-lyrics-0.1.1.26.3.jar`
- 运行环境 · Minecraft Java 26.3, Fabric, Java 25
- Fabric Loader · `>=0.20.1`
- Fabric 模组 ID · `rongmc_cinematic_lyrics`
- JAR 声明的依赖 · `ji-afk-cinematic` `2.4.0`

把发行 JAR 放入对应实例的 `mods/` 目录。客户端使用，准备发行版要求的 Ji AFK Cinematic 和兼容的 MuoniumPlayer。对宿主模组升级时同时测试歌词界面。

## 如何验证

播放一首已确认包含歌词的曲目，触发 Cinematic 模式，检查歌词切换、译文和退出后界面恢复。无歌词的曲目应保持无字幕。

## 开发

构建入口见 [`build.sh`](./build.sh)。运行前检查脚本需要的工作区目录与依赖。

## 文档与反馈

- [原 README（旧版指南、贡献者与署名）](https://github.com/OpenRongMC/RongMC-Cinematic-Lyrics/blob/778c22400617b4bfaad18f3a1f5669ecde62b467/README.md)
- [报告 RongMC 移植问题](https://github.com/OpenRongMC/RongMC-Cinematic-Lyrics/issues) · 请附游戏版本、两端 JAR 文件名、复现步骤和相关日志。

## 许可与署名

请参阅本仓库的 [LICENSE](./LICENSE) 及原项目的许可、署名和第三方资源说明。
