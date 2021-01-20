package mk.djakov.loyaltycards.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card")
data class Card(
    val name: String,
    val barcode: String,
    val imageUrl: String?
) {
    @PrimaryKey
    var id: Int? = null
}