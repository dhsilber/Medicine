package app.medicines.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicine")
    fun getAll(): Flow<List<Medicine>>

    @Insert
    suspend fun insert(medicine: Medicine)
}
