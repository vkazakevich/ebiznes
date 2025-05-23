package clients

import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import dev.kord.core.behavior.channel.MessageChannelBehavior
import dev.kord.common.entity.Snowflake

class DiscordClient (val token: String) : Client() {
    override suspend fun run() {
        val kord = Kord(token)

        kord.on<MessageCreateEvent> {
            if (message.author?.isBot != false) return@on

            val args = message.content.split(" ", limit=2).toList()

            when (args.get(0)) {
                "!ping" -> message.channel.createMessage("pong!")
                "!categories" -> message.channel.createMessage(displayCategories())
                "!category" -> {
                    message.channel.createMessage(
                        displayProductsByCategory(args.get(1))
                    )
                }
            }
        }

        kord.login {
            @OptIn(PrivilegedIntent::class)
            intents += Intent.MessageContent
        }
    }
}
