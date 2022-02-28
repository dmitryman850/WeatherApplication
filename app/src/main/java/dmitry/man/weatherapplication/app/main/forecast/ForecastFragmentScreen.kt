package dmitry.man.weatherapplication.app.main.forecast

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherData

interface ForecastFragmentScreen : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoad(show: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun refreshWeatherData(data: FiveDaysWeatherData)
}