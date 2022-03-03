package dmitry.man.weatherapplication.app.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FiveDaysWeather")
class FiveDaysWeatherDataEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val idFiveDaysWeather: Int,

    @ColumnInfo(name = "city_name")
    val cityName: String?,

    @ColumnInfo(name = "list_weather")
    val listWeather: String?
)