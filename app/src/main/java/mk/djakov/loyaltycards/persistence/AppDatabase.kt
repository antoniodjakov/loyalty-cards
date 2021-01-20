package mk.djakov.loyaltycards.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import mk.djakov.loyaltycards.data.Card

@Database(entities = [Card::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cardDao(): CardDao
}