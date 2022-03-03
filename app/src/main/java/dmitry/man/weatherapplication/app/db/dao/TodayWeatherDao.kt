package dmitry.man.weatherapplication.app.db.dao

import androidx.room.*
import dmitry.man.weatherapplication.app.db.entity.TodayWeatherDataEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface TodayWeatherDao {

    @Query("SELECT * FROM TodayWeather")
    fun getAll(): Observable<TodayWeatherDataEntity>

    @Query("SELECT * FROM TodayWeather WHERE id = :id")
    fun getById(id: Int): Single<TodayWeatherDataEntity>

    @Insert
    fun insert(todayWeatherDataEntity: TodayWeatherDataEntity)

    @Update
    fun update(todayWeatherDataEntity: TodayWeatherDataEntity)

    @Delete
    fun delete(todayWeatherDataEntity: TodayWeatherDataEntity)
}