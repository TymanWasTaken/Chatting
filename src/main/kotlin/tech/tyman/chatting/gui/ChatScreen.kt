package tech.tyman.chatting.gui

import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.ScrollComponent
import gg.essential.elementa.components.UIBlock
import gg.essential.elementa.components.UIWrappedText
import gg.essential.elementa.components.inspector.Inspector
import gg.essential.elementa.constraints.*
import gg.essential.elementa.dsl.*
import gg.essential.elementa.state.pixels
import gg.essential.universal.UKeyboard
import tech.tyman.chatting.config.Config

class ChatScreen(val startingText: String) :
    WindowScreen(
        version = ElementaVersion.V1,
        restoreCurrentGuiOnClose = true,
        drawDefaultBackground = false
    ) {

    private var chatClickPos: Pair<Float, Float>? = null

    init {
        val container =
            UIBlock(States.backgroundColor)
                .constrain {
                    x = States.chatX.pixels()
                    y = States.chatY.pixels()
                    width = ChildBasedMaxSizeConstraint()
                    height = ChildBasedSizeConstraint()
                }
                .onMouseClick {
                    chatClickPos =
                        if (it.relativeX < 0 ||
                                it.relativeY < 0 ||
                                it.relativeX > getWidth() ||
                                it.relativeY > getHeight()
                        ) {
                            null
                        } else {
                            it.relativeX to it.relativeY
                        }
                }
                .onMouseRelease { chatClickPos = null }
                .onMouseDrag { mouseX, mouseY, button ->
                    if (!UKeyboard.isCtrlKeyDown() || chatClickPos == null || button != 0)
                        return@onMouseDrag
                    States.chatX.set(this.getLeft() + mouseX - chatClickPos!!.first)
                    States.chatY.set(this.getTop() + mouseY - chatClickPos!!.second)
                } childOf window

        val scrollBox =
            ScrollComponent().constrain {
                x = 0.pixels()
                y = 0.pixels()
                width = States.chatWidth.pixels()
                height = States.chatHeight.pixels()
            } childOf container

        repeat(100) { // Temporary until I get the actual messages handled
            UIWrappedText().bindText(States.chatMessage.map { str -> "$str ($it)" }).constrain {
                x = CenterConstraint()
                y = SiblingConstraint(padding = 2f)
                width = States.chatWidth.pixels()
            } childOf scrollBox
        }

        if (Config.debug) {
            Inspector(window).constrain {
                x = 10.pixels(true)
                y = 10.pixels(true)
            } childOf window
        }
    }
}
