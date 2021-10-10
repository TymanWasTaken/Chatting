package tech.tyman.chatting.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.tyman.chatting.util.ChatHelper;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Inject(
            method = "openChatScreen(Ljava/lang/String;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void openChatScreen(String text, CallbackInfo info) {
        info.cancel();
        ChatHelper.INSTANCE.openChat(text);
    }
}
