package dmitry.man.weatherapplication.app.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dmitry.man.weatherapplication.app.data.FiveDaysWeatherRepository
import dmitry.man.weatherapplication.app.data.TodayWeatherRepository
import dmitry.man.weatherapplication.app.data.api.WeatherApi
import dmitry.man.weatherapplication.app.db.FiveDaysWeatherDatabase
import dmitry.man.weatherapplication.app.db.TodayWeatherDatabase
import dmitry.man.weatherapplication.app.db.dao.FiveDaysWeatherDao
import dmitry.man.weatherapplication.app.db.dao.TodayWeatherDao
import dmitry.man.weatherapplication.app.main.interactor.WeatherInteractor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MainModule {

    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherInteractor(
        weatherApi: WeatherApi,
        todayWeatherRepo: TodayWeatherRepository,
        fiveDaysWeatherRepo: FiveDaysWeatherRepository
    ): WeatherInteractor {
        return WeatherInteractor(weatherApi, todayWeatherRepo, fiveDaysWeatherRepo)
    }

    @Singleton
    @Provides
    fun provideTodayWeatherDatabase(context: Context): TodayWeatherDatabase {
        return Room.databaseBuilder(
            context,
            TodayWeatherDatabase::class.java, "todayWeather.db"
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideFiveDaysWeatherDatabase(context: Context): FiveDaysWeatherDatabase {
        return Room.databaseBuilder(
            context,
            FiveDaysWeatherDatabase::class.java, "fiveDaysWeather.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTodayWeatherDao(database: TodayWeatherDatabase): TodayWeatherDao {
        return database.getTodayWeatherDao()
    }

    @Singleton
    @Provides
    fun provideFiveDaysWeatherDao(database: FiveDaysWeatherDatabase): FiveDaysWeatherDao {
        return database.getFiveDaysWeatherDao()
    }

    @Singleton
    @Provides
    fun provideTodayWeatherRepository(todayWeatherDao: TodayWeatherDao): TodayWeatherRepository {
        return TodayWeatherRepository(todayWeatherDao)
    }

    @Singleton
    @Provides
    fun provideFiveDaysWeatherRepository(fiveDaysWeatherDao: FiveDaysWeatherDao, gson: Gson): FiveDaysWeatherRepository {
        return FiveDaysWeatherRepository(fiveDaysWeatherDao, gson)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()
}