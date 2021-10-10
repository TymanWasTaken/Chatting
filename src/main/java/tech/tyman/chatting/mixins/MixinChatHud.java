package tech.tyman.chatting.mixins;

import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatHud.class)
public class MixinChatHud {
    @Inject(
            method = "isChatHidden()Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private void isChatHidden(CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(true);
    }
}
