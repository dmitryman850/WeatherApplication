package dmitry.man.weatherapplication.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dmitry.man.weatherapplication.app.db.dao.TodayWeatherDao
import dmitry.man.weatherapplication.app.db.entity.TodayWeatherDataEntity

@Database(entities = [TodayWeatherDataEntity::class], version = 1)
abstract class TodayWeatherDatabase : RoomDatabase() {

    abstract fun getTodayWeatherDao(): TodayWeatherDao

}