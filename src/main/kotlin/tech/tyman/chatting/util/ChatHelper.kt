package tech.tyman.chatting.util

import gg.essential.api.EssentialAPI
import tech.tyman.chatting.gui.ChatScreen

object ChatHelper {
    fun openChat(text: String) = EssentialAPI.getGuiUtil().openScreen(ChatScreen(text))

    fun Int.orDefault(default: (int: Int) -> Int): Int {
        return if (this == -1) default.invoke(this) else this
    }
}
