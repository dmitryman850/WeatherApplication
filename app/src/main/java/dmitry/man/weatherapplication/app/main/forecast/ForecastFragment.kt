package dmitry.man.weatherapplication.app.main.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherModel
import dmitry.man.weatherapplication.databinding.FragmentForecastBinding

class ForecastFragment : MvpAppCompatFragment(), ForecastFragmentScreen {

    @InjectPresenter
    lateinit var fragmentPresenter: ForecastFragmentPresenter

    private lateinit var forecastAdapter: ForecastAdapter
    private lateinit var binding: FragmentForecastBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForecastBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forecastAdapter = ForecastAdapter()
        binding.rvForecast.layoutManager = LinearLayoutManager(requireContext())
        binding.rvForecast.adapter = forecastAdapter
    }

    override fun showLoad(show: Boolean) {
        binding.pgLoad.isVisible = show
    }

    override fun showError() {
        Toast.makeText(context, R.string.toast_error, Toast.LENGTH_LONG).show()
    }

    override fun refreshWeatherData(data: FiveDaysWeatherModel) {
        val notFound = resources.getString(R.string.weather_not_found)

        val cityName = data.cityName ?: notFound

        binding.tvCityForecast.text = cityName

        data.listWeather?.let { forecastAdapter.submitList(it) }
    }
}