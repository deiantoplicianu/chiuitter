package ro.upt.ac.chiuitter.data.database

import androidx.room.Dao
import androidx.room.Query


@Dao
interface ChiuitDao {

    @Query("SELECT * FROM chiuits")
    fun getAll(): List<ChiuitEntity>


    // TODO("Define insert")


    // TODO("Define delete")


}