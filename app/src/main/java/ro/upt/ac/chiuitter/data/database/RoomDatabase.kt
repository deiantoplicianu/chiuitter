package ro.upt.ac.chiuitter.data.database

import android.content.Context
import androidx.room.Room


object RoomDatabase {

    private var appDatabase: AppDatabase? = null

    fun getDb(context: Context): AppDatabase {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "chiuit-db")
                    .allowMainThreadQueries()
                    .build()

        return appDatabase!!
    }


}