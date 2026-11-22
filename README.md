# RongMC Cinematic Lyrics

在 **Ji AFK Cinematic** 的 letterbox 下栏显示 **MuoniumPlayer** 歌词，并支持可用的翻译文本。

## 功能

- 从 MuoniumPlayer 取当前歌词/翻译，画到 Cinematic 底部条。
- 附带对 SDL 按键状态的小修正 mixin（避免部分输入状态下歌词/UI 异常）。

## 依赖

- 需要 Ji AFK Cinematic（及你整合包里配套的 Muonium 播放相关模组）。
- 没有这些模组时本模组没有可见效果。

## 已知限制

- 歌词能否显示取决于 Muonium 是否提供对应曲目的歌词数据。
- Cinematic / Muonium 大版本升级后 mixin 可能失效，需要跟进适配。

## 许可

GPL-3.0（见 `LICENSE`）。Fabric id：`rongmc_cinematic_lyrics`。
