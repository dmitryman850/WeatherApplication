package dmitry.man.weatherapplication.app.main.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.TodayWeatherData
import dmitry.man.weatherapplication.databinding.FragmentTodayBinding

class TodayFragment : MvpAppCompatFragment(), TodayFragmentScreen {

    private lateinit var binding: FragmentTodayBinding

    @InjectPresenter
    lateinit var fragmentPresenter: TodayFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodayBinding.inflate(inflater)
        return binding.root
    }

    override fun showLoad(show: Boolean) {
        binding.pgLoad.isVisible = show
    }

    override fun showError() {

    }

    override fun refreshWeatherData(
        data: TodayWeatherData
    ) {
        val notFound = resources.getString(R.string.weather_not_found)

        val cityName = data.name ?: notFound
        val countryName = data.sys?.country
        val temp = (data.main?.temp?.minus(KELVIN_TO_CELCIUS_ZERO))?.toInt()?.toString() ?: notFound
        val rainPercent = data.main?.humidity?.toString() ?: notFound
        val hpa = data.main?.pressure?.toString() ?: notFound
        val speedWind =
            (data.wind?.speed?.times(WIND_SPEED_MS_TO_KMH))?.toInt()?.toString() ?: notFound
        val directionWind = data.wind?.deg?.toString() ?: notFound
        val rainmm = data.clouds?.all?.toString() ?: notFound
        val descriptionWeather = data.weather?.get(FIRST_ITEM)?.main ?: notFound

        binding.tvCityCountryToday.text =
            resources.getString(R.string.weather_city_placeholder, cityName, countryName)
        binding.tvTemp.text = resources.getString(R.string.weather_temperature_placeholder, temp)
        binding.tvTypeSun.text = descriptionWeather
        binding.tvRainPercentToday.text =
            resources.getString(R.string.weather_percent_placeholder, rainPercent)
        binding.tvRainMmToday.text =
            resources.getString(R.string.weather_rain_mm_placeholder, rainmm)
        binding.tvHpaToday.text = resources.getString(R.string.weather_hpa_placeholder, hpa)
        binding.tvSpeedWindToday.text =
            resources.getString(R.string.weather_wind_speed_placeholder, speedWind)
        binding.tvDirectionWindToday.text = directionWind
    }

    companion object {
        private const val KELVIN_TO_CELCIUS_ZERO = 273.15
        private const val WIND_SPEED_MS_TO_KMH = 3.6
        private const val FIRST_ITEM = 0
    }

}