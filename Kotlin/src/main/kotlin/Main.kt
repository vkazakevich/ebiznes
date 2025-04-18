import kotlinx.coroutines.*
import utils.Seeds
import clients.ClientFactory
import clients.ClientPlatform

suspend fun main(args: Array<String>) = coroutineScope {
    Seeds.fill()

    val discordClient = ClientFactory.create(ClientPlatform.Discord)
    val slackClient = ClientFactory.create(ClientPlatform.Slack)

    listOf(discordClient, slackClient).forEach {
        launch { it.run() }
    }
}
