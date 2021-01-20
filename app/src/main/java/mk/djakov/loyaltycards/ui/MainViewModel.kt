package mk.djakov.loyaltycards.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mk.djakov.loyaltycards.base.LiveCoroutinesViewModel
import mk.djakov.loyaltycards.repository.MainRepository
import mk.djakov.loyaltycards.util.Data

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository
) : LiveCoroutinesViewModel() {

    val cards = repository.cards

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {

        setIsLoading(true)
        viewModelScope.launch {
            repository.insertAll(Data.cards)
        }

        launchOnViewModelScope {
            repository.getAllCards().asLiveData()
        }
    }

    fun insertCard(name: String, barcode: String, owner: String) =
        viewModelScope.launch {
            repository.insertCard(name, barcode, owner)
        }

    fun setIsLoading(value: Boolean) {
        _isLoading.value = value
    }
}