package dmitry.man.weatherapplication.app.db.dao

import androidx.room.*
import dmitry.man.weatherapplication.app.db.entity.FiveDaysWeatherDataEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface FiveDaysWeatherDao {

    @Query("SELECT * FROM FiveDaysWeather")
    fun getAll(): Observable<FiveDaysWeatherDataEntity>

    @Query("SELECT * FROM FiveDaysWeather WHERE id = :id")
    fun getById(id: Int): Single<FiveDaysWeatherDataEntity>

    @Insert
    fun insert(fiveDaysWeatherDataEntity: FiveDaysWeatherDataEntity)

    @Update
    fun update(fiveDaysWeatherDataEntity: FiveDaysWeatherDataEntity)

    @Delete
    fun delete(fiveDaysWeatherDataEntity: FiveDaysWeatherDataEntity)
}