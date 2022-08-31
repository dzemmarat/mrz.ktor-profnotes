package mrz

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import mrz.model.Note
import mrz.model.User
import mrz.plugins.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

val client by lazy { KMongo.createClient() }
val db by lazy { client.getDatabase("users") }
val usersList by lazy { db.getCollection<User>() }
val notesList by lazy { db.getCollection<Note>() }

// Application.kt
fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureSerialization()
        configureMonitoring()
        configureHTTP()
        configureSecurity()
        configureLogin()
        configureNotes()
    }.start(wait = true)
}
