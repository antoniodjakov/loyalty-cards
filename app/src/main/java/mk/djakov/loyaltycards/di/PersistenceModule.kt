package mk.djakov.loyaltycards.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mk.djakov.loyaltycards.persistence.AppDatabase
import mk.djakov.loyaltycards.persistence.CardDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "loyalty_cards_db"
    ).build()

    @Singleton
    @Provides
    fun provideCardDao(db: AppDatabase): CardDao = db.cardDao()
}