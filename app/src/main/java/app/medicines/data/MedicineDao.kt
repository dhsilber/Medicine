package app.medicines.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicine")
    fun getAll(): Flow<List<Medicine>>

    @Query("SELECT * FROM medicine WHERE id = :id")
    fun getById(id: Int): Medicine

//    fun getMedicineDistinctUntilChanged(id: Int) =
//        getByIdFlow(id).distinctUntilChanged()

    @Insert
    suspend fun insert(medicine: Medicine)
}
