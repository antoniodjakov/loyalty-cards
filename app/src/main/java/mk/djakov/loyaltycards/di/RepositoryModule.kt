package mk.djakov.loyaltycards.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import mk.djakov.loyaltycards.persistence.CardDao
import mk.djakov.loyaltycards.repository.MainRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(cardDao: CardDao): MainRepository = MainRepository(cardDao)
}
