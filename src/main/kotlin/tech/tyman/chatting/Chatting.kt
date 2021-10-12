package tech.tyman.chatting

import net.fabricmc.api.ModInitializer
import tech.tyman.chatting.config.Config

@Suppress("unused")
object Chatting : ModInitializer {
    override fun onInitialize() {
        println("We do a little chatting")
        Config.preload()
    }
}
