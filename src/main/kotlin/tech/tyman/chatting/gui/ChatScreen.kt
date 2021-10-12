package tech.tyman.chatting.gui

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.UIWrappedText
import gg.essential.elementa.dsl.childOf
import gg.essential.elementa.dsl.constrain
import gg.essential.elementa.dsl.pixels
import gg.essential.elementa.state.BasicState
import gg.essential.universal.UMinecraft
import tech.tyman.chatting.config.Config
import tech.tyman.chatting.util.ChatHelper.orDefault

class ChatScreen(val startingText: String) :
    WindowScreen(
        version = ElementaVersion.V1,
        restoreCurrentGuiOnClose = true,
        drawDefaultBackground = false
    ) {
    private val mc
        get() = UMinecraft.getMinecraft()
    private val chatMessages =
        BasicState("""
        Hello there
        
        General kenobi
    """.trimIndent())
    val chatBox =
        UIWrappedText().bindText(chatMessages).constrain {
            x = Config.chatX.orDefault { 0 }.pixels()
            y = Config.chatY.orDefault { 0 }.pixels()
            width = Config.chatWidth.orDefault { (mc.options.chatWidth * 320).toInt() }.pixels()
            height =
                Config.chatHeight
                    .orDefault { (mc.options.chatHeightFocused * 180).toInt() }
                    .pixels()
        } childOf this.window
}
