package dmitry.man.weatherapplication.app.main.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.TodayWeatherModel
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
        Toast.makeText(context, R.string.toast_error, Toast.LENGTH_LONG).show()
    }

    override fun refreshWeatherData(
        data: TodayWeatherModel
    ) {
        val notFoundValue = requireContext().resources.getString(R.string.weather_not_found)

        val cityName = data.cityName ?: notFoundValue
        val countryName = data.countryName ?: notFoundValue
        val temp = data.temp ?: notFoundValue
        val rainPercent = data.rainPercent ?: notFoundValue
        val hpa = data.hpa ?: notFoundValue
        val speedWind = data.speedWind ?: notFoundValue
        val directionWind = data.directionWind ?: notFoundValue
        val rainmm = data.rainmm ?: notFoundValue
        val descriptionWeather = data.descriptionWeather ?: notFoundValue

        binding.tvCityCountryToday.text = resources.getString(
            R.string.weather_city_placeholder,
            cityName,
            countryName
        )
        binding.tvTemp.text = resources.getString(
            R.string.weather_temperature_placeholder,
            temp
        )
        binding.tvTypeSun.text = descriptionWeather
        binding.tvRainPercentToday.text = resources.getString(
            R.string.weather_percent_placeholder,
            rainPercent
        )
        binding.tvRainMmToday.text = resources.getString(
            R.string.weather_rain_mm_placeholder,
            rainmm
        )
        binding.tvHpaToday.text = resources.getString(
            R.string.weather_hpa_placeholder,
            hpa
        )
        binding.tvSpeedWindToday.text = resources.getString(
            R.string.weather_wind_speed_placeholder,
            speedWind
        )
        binding.tvDirectionWindToday.text = directionWind
    }
}