package mk.djakov.loyaltycards.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mk.djakov.loyaltycards.data.Card

@Dao
interface CardDao {

    @Insert
    fun insertCard(card: Card)

    @Query("SELECT * FROM card")
    fun getAllCards(): LiveData<List<Card>>

    @Delete
    fun deleteCard(card: Card)

    @Query("DELETE FROM card")
    suspend fun deleteAll()

    @Insert
    fun insertAll(cards: List<Card>)
}