package mrz.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import mrz.model.User
import mrz.usersList

fun Application.configureLogin() {
    routing {
        post("/register") {
            val parameters = call.receive<User>()
            usersList.insertOne(parameters)
            call.respond(mapOf("success" to true))
        }

        authenticate("basic") {
            get("/login") {
                val principal = call.principal<User>()!!
                call.respond(mapOf("Hello" to principal.id.toString()))
            }
        }
    }
}