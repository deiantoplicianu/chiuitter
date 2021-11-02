package ro.upt.ac.chiuitter.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "chiuits")
data class ChiuitEntity(
        @PrimaryKey
        val timestamp: Long,

        @ColumnInfo(name = "description")
        val description: String
)