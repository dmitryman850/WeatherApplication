package dmitry.man.weatherapplication.app.main.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherData
import dmitry.man.weatherapplication.databinding.FragmentForecastBinding

class ForecastFragment : MvpAppCompatFragment(), ForecastFragmentScreen {

    private lateinit var binding: FragmentForecastBinding

    @InjectPresenter
    lateinit var fragmentPresenter: ForecastFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForecastBinding.inflate(inflater)
        return binding.root
    }

    override fun showLoad(show: Boolean) {
        binding.pgLoad.isVisible = show
    }

    override fun showError() {

    }

    override fun refreshWeatherData(data: FiveDaysWeatherData) {
        val notFound = resources.getString(R.string.weather_not_found)

        val cityName = data.city?.name ?: notFound

        binding.tvCityForecast.text = cityName
    }
}