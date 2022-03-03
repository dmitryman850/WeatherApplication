package dmitry.man.weatherapplication.app.data.model

data class TodayWeatherModel(
    val cityName: String?,
    val countryName: String?,
    val temp: String?,
    val rainPercent: String?,
    val hpa: String?,
    val speedWind: String?,
    val directionWind: String?,
    val rainmm: String?,
    val descriptionWeather: String?
)
