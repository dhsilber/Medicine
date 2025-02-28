package app.medicines.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Medicine::class], version = 1, exportSchema = false)
abstract class MedicineDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao

    companion object {
        @Volatile
        private var Instance: MedicineDatabase? = null

        fun getDatabase(context: Context): MedicineDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, MedicineDatabase::class.java, "medicine-database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
