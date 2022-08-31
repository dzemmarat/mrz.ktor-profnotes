val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val bcrypt_version: String by project
val koin_version: String by project
val kgraphql_version: String by project
val kmongo_version: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
    id("io.ktor.plugin") version "2.1.0"
}

group = "mrz"
version = "0.0.3"
application {
    mainClass.set("mrz.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

tasks {
    create("stage").dependsOn("installDist")
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-default-headers-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-locations-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("io.ktor:ktor-server-auth-jwt:$ktor_version")
    implementation("at.favre.lib:bcrypt:$bcrypt_version")
    // Koin for Ktor
    implementation("io.insert-koin:koin-ktor:$koin_version")
        // SLF4J Logger
    implementation("io.insert-koin:koin-logger-slf4j:$koin_version")
    implementation("com.github.untoldwind.KGraphQL:kgraphql:0.17.14-fork-2")
    implementation("com.github.untoldwind.KGraphQL:kgraphql-ktor:0.17.14-fork-2")
    implementation("org.litote.kmongo:kmongo:$kmongo_version")
}