package tech.tyman.chatting.config

import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import java.io.File

object Config : Vigilant(
    File("./config/chatting.toml")
) {
    @Property(
        type = PropertyType.NUMBER,
        hidden = true,
        name = "X value of the chat",
        category = "Chat location"
    )
    var chatX = -1

    @Property(
        type = PropertyType.NUMBER,
        hidden = true,
        name = "Y value of the chat",
        category = "Chat location"
    )
    var chatY = -1

    @Property(
        type = PropertyType.NUMBER,
        hidden = true,
        name = "Width value of the chat",
        category = "Chat location"
    )
    var chatWidth = -1

    @Property(
        type = PropertyType.NUMBER,
        hidden = true,
        name = "Height value of the chat",
        category = "Chat location"
    )
    var chatHeight = -1

    init {
        initialize()
    }
}