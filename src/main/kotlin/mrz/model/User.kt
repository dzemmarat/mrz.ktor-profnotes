package mrz.model

import io.ktor.server.auth.*
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId

data class User(
    @BsonId
    val id: Id<User> = newId(),
    val login: String,
    val password: String,
    var name: String,
    val email: String
): Principal