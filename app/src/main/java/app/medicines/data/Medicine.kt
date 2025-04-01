package app.medicines.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Medicine(
    val name: String = "",

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
