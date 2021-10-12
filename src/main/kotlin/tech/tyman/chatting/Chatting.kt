package tech.tyman.chatting

import com.mojang.brigadier.Command
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager
import tech.tyman.chatting.commands.ChattingCommand
import tech.tyman.chatting.config.Config

@Suppress("unused")
object Chatting : ClientModInitializer {
    override fun onInitializeClient() {
        Config.preload()
        val chattingCommand = ChattingCommand()
        // Yes this is hacky, tell someone to fix registering essential commands then
        ClientCommandManager.DISPATCHER.register(
            ClientCommandManager.literal(chattingCommand.name).executes {
                chattingCommand.handle()
                return@executes Command.SINGLE_SUCCESS
            }
        )
        println("We do a little chatting${if (Config.debug) " (in debug mode!)" else ""}")
    }
}
