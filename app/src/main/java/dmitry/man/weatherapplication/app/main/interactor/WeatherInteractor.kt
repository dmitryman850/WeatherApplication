package dmitry.man.weatherapplication.app.main.interactor

import dmitry.man.weatherapplication.app.data.FiveDaysWeatherRepository
import dmitry.man.weatherapplication.app.data.TodayWeatherRepository
import dmitry.man.weatherapplication.app.data.api.WeatherApi
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherModel
import dmitry.man.weatherapplication.app.data.model.TodayWeatherModel
import io.reactivex.Completable
import io.reactivex.Observable

class WeatherInteractor(
    private val weatherApi: WeatherApi,
    private val todayWeatherRepo: TodayWeatherRepository,
    private val fiveDaysWeatherRepo: FiveDaysWeatherRepository
) {

    fun observeTodayWeather(): Observable<TodayWeatherModel> {
        return todayWeatherRepo.getAll()
    }

    fun observeFiveDaysWeather(): Observable<FiveDaysWeatherModel> {
        return fiveDaysWeatherRepo.getAll()
    }

    fun requestTodayWeather(): Completable {
        return Completable.fromAction {
            val response = weatherApi
                .getTodayWeatherData(LAT_CITY, LON_CITY, APP_WEATHER_ID)
                .execute()

            val result = response.body()
                ?: throw IllegalArgumentException("Today weather response is null")
            todayWeatherRepo.save(result)
        }
    }

    fun requestFiveDaysWeather(): Completable {
        return Completable.fromAction {
            val response = weatherApi
                .getListWeatherData(LAT_CITY, LON_CITY, APP_WEATHER_ID)
                .execute()

            val result = response.body()
                ?: throw IllegalArgumentException("Five days weather response is null")
            fiveDaysWeatherRepo.save(result)
        }
    }

    companion object {
        private const val LAT_CITY = 35F
        private const val LON_CITY = 139f
        private const val APP_WEATHER_ID = "f122a3a1694ef074598610d2d01c3293"
    }
}