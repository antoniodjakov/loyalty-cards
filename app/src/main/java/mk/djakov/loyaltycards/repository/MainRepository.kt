package mk.djakov.loyaltycards.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import mk.djakov.loyaltycards.data.Card
import mk.djakov.loyaltycards.persistence.CardDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val cardDao: CardDao
) {
    suspend fun getAllCards() = flow {
        val cardList = cardDao.getAllCards()
        emit(cardList)
    }

    suspend fun insertCard(
        name: String,
        barcode: String,
        owner: String,
        imageUrl: String? = null
    ) {
        withContext(Dispatchers.IO) {
            cardDao.insertCard(Card(name, barcode, owner))
        }
    }

    suspend fun insertAll(cards: List<Card>) {
        withContext(Dispatchers.IO) {
            cardDao.insertAll(cards)
        }
    }

    val cards = cardDao.getAllCards()
}