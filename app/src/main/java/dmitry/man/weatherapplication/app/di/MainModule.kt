package dmitry.man.weatherapplication.app.di

import dagger.Module
import dagger.Provides
import dmitry.man.weatherapplication.app.data.api.WeatherApi
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
    fun provideWeatherInteractor(weatherApi: WeatherApi): WeatherInteractor {
        return WeatherInteractor(weatherApi)
    }
}