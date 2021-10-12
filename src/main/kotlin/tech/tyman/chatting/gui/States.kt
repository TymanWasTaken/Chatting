package tech.tyman.chatting.gui

import gg.essential.elementa.state.BasicState
import gg.essential.universal.UMinecraft
import java.awt.Color
import tech.tyman.chatting.config.Config
import tech.tyman.chatting.util.ChatHelper.orDefault

internal object States {
    private val mc
        get() = UMinecraft.getMinecraft()
    val chatMessage = BasicState("Hello there")
    val chatX = BasicState(Config.chatX.orDefault { 0 }.toFloat())
    val chatY = BasicState(Config.chatY.orDefault { 0 }.toFloat())
    val chatWidth = Config.chatWidth.orDefault { (mc.options.chatWidth * 320).toInt() }
    val chatHeight = Config.chatHeight.orDefault { (mc.options.chatHeightFocused * 180).toInt() }
    val backgroundColor = BasicState(Color(192, 192, 192, 80))
}
