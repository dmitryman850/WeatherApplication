package dmitry.man.weatherapplication.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dmitry.man.weatherapplication.app.db.dao.FiveDaysWeatherDao
import dmitry.man.weatherapplication.app.db.entity.FiveDaysWeatherDataEntity

@Database(entities = [FiveDaysWeatherDataEntity::class], version = 1)
abstract class FiveDaysWeatherDatabase : RoomDatabase() {

    abstract fun getFiveDaysWeatherDao(): FiveDaysWeatherDao
}