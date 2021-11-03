package ro.upt.ac.chiuitter.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ChiuitDao {

    @Query("SELECT * FROM chiuits")
    fun getAll(): List<ChiuitEntity>


    // TODO("Define insert")
    @Insert
    fun addChiuit(chiuit: ChiuitEntity)

    // TODO("Define delete")
    @Delete
    fun removeChiuit(chiuit: ChiuitEntity)


}