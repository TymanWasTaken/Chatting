package tech.tyman.chatting.commands

import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler

class ChattingCommand : Command("chatting") {
    @DefaultHandler
    fun handle() {
        EssentialAPI.getMinecraftUtil().sendMessage("hello")
    }
}