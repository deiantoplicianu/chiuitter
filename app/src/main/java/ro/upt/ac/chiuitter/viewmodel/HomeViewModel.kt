package ro.upt.ac.chiuitter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ro.upt.ac.chiuitter.domain.ChiuitRepository
import ro.upt.ac.chiuitter.domain.Chiuit

class HomeViewModel(private val chiuitRepository: ChiuitRepository) : ViewModel() {

    val chiuitsLiveData = MutableLiveData<List<Chiuit>>()

    fun retrieveChiuits() {
        val chiuits = chiuitRepository.getAll()
        chiuitsLiveData.postValue(chiuits)
    }

    fun addChiuit(description: String) {
        chiuitRepository.addChiuit(Chiuit(System.currentTimeMillis(), description))
        retrieveChiuits()
    }

    fun removeChiuit(chiuit: Chiuit) {
        chiuitRepository.removeChiuit(chiuit)
        retrieveChiuits()
    }

}