package dmitry.man.weatherapplication.app.main.today

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import dmitry.man.weatherapplication.app.data.model.TodayWeatherData
import dmitry.man.weatherapplication.app.data.model.TodayWeatherModel
import dmitry.man.weatherapplication.app.db.entity.TodayWeatherDataEntity

interface TodayFragmentScreen : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoad(show: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun refreshWeatherData(data: TodayWeatherModel)
}