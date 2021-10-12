package tech.tyman.chatting.commands

import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler
import tech.tyman.chatting.config.Config

class ChattingCommand : Command("chatting") {
    @DefaultHandler
    fun handle() {
        EssentialAPI.getGuiUtil().openScreen(Config.gui())
    }
}
