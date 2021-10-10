package tech.tyman.chatting

import com.mojang.brigadier.Command
import gg.essential.api.EssentialAPI
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager
import tech.tyman.chatting.commands.ChattingCommand
import tech.tyman.chatting.config.Config

@Suppress("unused")
object Chatting : ModInitializer {
    override fun onInitialize() {
        println("We do a little chatting")
        Config.preload()
    }
}

