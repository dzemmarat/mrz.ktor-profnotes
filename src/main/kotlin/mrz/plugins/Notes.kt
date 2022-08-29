package mrz.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import mrz.model.Note
import mrz.model.User
import mrz.notesList
import org.litote.kmongo.*

fun Application.configureNotes() {
    routing {
        authenticate("basic") {
            get("/notes") {
                val principal = call.principal<User>()!!

                call.respond(mapOf("notesList" to notesList.find(Note::userIds contains principal.id.toString()).toList()))
            }

            post("/notes") {
                val parameters = call.receive<Note>()
                notesList.insertOne(parameters)
                call.respond(mapOf("success" to true))
            }
        }
    }
}