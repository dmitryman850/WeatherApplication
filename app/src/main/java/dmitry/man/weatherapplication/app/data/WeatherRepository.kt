package dmitry.man.weatherapplication.app.data

import dmitry.man.weatherapplication.app.WeatherApplication
import dmitry.man.weatherapplication.app.data.model.TodayWeatherData
import dmitry.man.weatherapplication.app.data.model.TodayWeatherModel
import dmitry.man.weatherapplication.app.db.TodayWeatherDatabase
import dmitry.man.weatherapplication.app.db.dao.TodayWeatherDao
import dmitry.man.weatherapplication.app.db.entity.TodayWeatherDataEntity
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepository(private val dao: TodayWeatherDao) {

    @Inject
    lateinit var todayWeatherDb: TodayWeatherDatabase

    fun save(data: TodayWeatherData) {
        dao.insert(data.toEntity())
    }

    fun getAll(): Observable<TodayWeatherModel> {
        return dao.getAll().map {
            it.toModel()
        }
    }

    private fun TodayWeatherData.toEntity(): TodayWeatherDataEntity {
        return TodayWeatherDataEntity(
            0,
            this.name,
            this.sys?.country,
            (this.main?.temp?.minus(KELVIN_TO_CELCIUS_ZERO))?.toInt()?.toString(),
            this.main?.humidity?.toString(),
            this.main?.pressure?.toString(),
            (this.wind?.speed?.times(WIND_SPEED_MS_TO_KMH))?.toInt()?.toString(),
            this.wind?.deg?.toString(),
            this.clouds?.all?.toString(),
            this.weather?.get(FIRST_ITEM)?.main

        )
    }

    private fun TodayWeatherDataEntity.toModel(): TodayWeatherModel {
        return TodayWeatherModel(
            this.cityName,
            this.countryName,
            this.temp,
            this.rainPercent,
            this.hpa,
            this.speedWind,
            this.directionWind,
            this.rainmm,
            this.descriptionWeather
        )
    }

    companion object {
        private const val KELVIN_TO_CELCIUS_ZERO = 273.15
        private const val WIND_SPEED_MS_TO_KMH = 3.6
        private const val FIRST_ITEM = 0
    }

    init {
        WeatherApplication.mainComponent.inject(this)
    }

}