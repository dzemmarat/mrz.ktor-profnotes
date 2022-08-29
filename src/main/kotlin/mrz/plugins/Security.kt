package mrz.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import mrz.model.User
import mrz.usersList
import org.litote.kmongo.eq
import org.litote.kmongo.findOne

fun Application.configureSecurity() {
    authentication {
        basic(name = "basic") {
            realm = "Ktor Server"
            validate { credentials ->
                return@validate usersList.findOne(
                    User::login eq credentials.name,
                    User::password eq credentials.password
                )
            }
        }
    }
}