package dmitry.man.weatherapplication.app.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TodayWeather")
class TodayWeatherDataEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val idTodayWeather: Int,

    @ColumnInfo(name = "city_name")
    val cityName: String?,

    @ColumnInfo(name = "country_name")
    val countryName: String?,

    @ColumnInfo(name = "temp")
    val temp: String?,

    @ColumnInfo(name = "rain_percent")
    val rainPercent: String?,

    @ColumnInfo(name = "hpa")
    val hpa: String?,

    @ColumnInfo(name = "speedWind")
    val speedWind: String?,

    @ColumnInfo(name = "direction_wind")
    val directionWind: String?,

    @ColumnInfo(name = "rainmm")
    val rainmm: String?,

    @ColumnInfo(name = "description_weather")
    val descriptionWeather: String?

)