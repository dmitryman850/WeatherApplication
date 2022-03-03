package dmitry.man.weatherapplication.app.main.interactor

import dmitry.man.weatherapplication.app.data.WeatherRepository
import dmitry.man.weatherapplication.app.data.api.WeatherApi
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherData
import dmitry.man.weatherapplication.app.data.model.TodayWeatherModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class WeatherInteractor(
    private val weatherApi: WeatherApi,
    private val weatherRepo: WeatherRepository
) {

    private val weatherFiveDaysSubject = BehaviorSubject.create<FiveDaysWeatherData>()

    fun observeTodayWeather(): Observable<TodayWeatherModel> {
        return weatherRepo.getAll()
    }

    fun observeFiveDaysWeather(): Observable<FiveDaysWeatherData> {
        return weatherFiveDaysSubject.hide()
    }

    fun requestTodayWeather(): Completable {
        return Completable.fromAction {
            val response = weatherApi
                .getTodayWeatherData(LAT_CITY, LON_CITY, APP_WEATHER_ID)
                .execute()

            val result = response.body()
                ?: throw IllegalArgumentException("Today weather response is null")
            weatherRepo.save(result)
        }
    }

    fun requestFiveDaysWeather(): Completable {
        return Completable.fromAction {
            val response = weatherApi
                .getListWeatherData(LAT_CITY, LON_CITY, APP_WEATHER_ID)
                .execute()

            val result = response.body()
                ?: throw IllegalArgumentException("Five days weather response is null")
            weatherFiveDaysSubject.onNext(result)
        }
    }

    companion object {
        private const val LAT_CITY = 35F
        private const val LON_CITY = 139f
        private const val APP_WEATHER_ID = "f122a3a1694ef074598610d2d01c3293"
    }
}