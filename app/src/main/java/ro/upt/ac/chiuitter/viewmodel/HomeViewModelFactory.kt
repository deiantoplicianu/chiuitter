package ro.upt.ac.chiuitter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ro.upt.ac.chiuitter.domain.ChiuitRepository

class HomeViewModelFactory(private val chiuitRepository: ChiuitRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(chiuitRepository) as T
    }

}