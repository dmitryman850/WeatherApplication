package dmitry.man.weatherapplication.app.data.model

data class FiveDaysWeatherModel(
    val cityName: String?,
    val listWeather: List<FiveDaysWeatherItemModel>?
)
