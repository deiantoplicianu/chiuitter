package ro.upt.ac.chiuitter.domain

interface ChiuitRepository {
    fun getAll() : List<Chiuit>
    fun addChiuit(chiuit: Chiuit)
    fun removeChiuit(chiuit: Chiuit)
}