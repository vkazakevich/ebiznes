plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.serialization") version "2.1.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

val ktor_version: String by project
val kord_version: String by project
val logback_version: String by project

application {
    mainClass = "MainKt" 
}

repositories {
    mavenCentral()
    maven("https://repo.kord.dev/snapshots")
}

dependencies {
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")

    implementation("com.typesafe:config:1.4.3")

    // Discord
    implementation("dev.kord:kord-core:$kord_version")

    // Slack
    implementation("com.slack.api:bolt-socket-mode:1.45.3")
    implementation("javax.websocket:javax.websocket-api:1.1")
    implementation("org.glassfish.tyrus.bundles:tyrus-standalone-client:1.20")
}

kotlin {
    jvmToolchain(21)
}