package ro.upt.ac.chiuitter.data.database

import androidx.room.RoomDatabase
import androidx.room.Database


@Database(entities = [ChiuitEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chiuitDao(): ChiuitDao
}