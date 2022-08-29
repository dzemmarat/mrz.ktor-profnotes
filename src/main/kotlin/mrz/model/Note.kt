package mrz.model

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.*

data class Note(
    @BsonId
    val id: Id<Note> = newId(),
    var title: String,
    var date: String,
    var description: String,
    var userIds: Set<String> = emptySet(),
)
