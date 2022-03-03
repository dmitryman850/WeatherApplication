package dmitry.man.weatherapplication.app.di

import dagger.Component
import dmitry.man.weatherapplication.app.data.FiveDaysWeatherRepository
import dmitry.man.weatherapplication.app.data.TodayWeatherRepository
import dmitry.man.weatherapplication.app.main.MainActivityPresenter
import dmitry.man.weatherapplication.app.main.forecast.ForecastFragmentPresenter
import dmitry.man.weatherapplication.app.main.today.TodayFragmentPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, ContextModule::class])
interface MainComponent {

    fun inject(todayFragmentPresenter: TodayFragmentPresenter)
    fun inject(forecastFragmentPresenter: ForecastFragmentPresenter)
    fun inject(mainActivityPresenter: MainActivityPresenter)
    fun inject(todayWeatherRepository: TodayWeatherRepository)
    fun inject(fiveDaysWeatherRepository: FiveDaysWeatherRepository)
}