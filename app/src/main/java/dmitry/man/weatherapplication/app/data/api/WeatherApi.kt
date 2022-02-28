package dmitry.man.weatherapplication.app.data.api

import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherData
import dmitry.man.weatherapplication.app.data.model.TodayWeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/weather?")
    fun getTodayWeatherData(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("appid") appId: String
    ): Call<TodayWeatherData>

    @GET("/data/2.5/forecast?")
    fun getListWeatherData(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("appid") appId: String
    ): Call <FiveDaysWeatherData>

}