package dev.rongmc.cinematiclyrics.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.sdl.SDLKeyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InputConstants.class)
abstract class SdlKeyStateMixin {
    @Inject(method = "isKeyDown", at = @At("HEAD"), cancellable = true)
    private static void rongmc$ignoreInvalidScancodes(int scancode, CallbackInfoReturnable<Boolean> callback) {
        var keys = SDLKeyboard.SDL_GetKeyboardState();
        if (keys == null || scancode < 0 || scancode >= keys.limit()) {
            callback.setReturnValue(false);
        }
    }
}
