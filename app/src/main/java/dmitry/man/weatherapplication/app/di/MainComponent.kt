package dmitry.man.weatherapplication.app.di

import dagger.Component
import dmitry.man.weatherapplication.app.main.MainActivityPresenter
import dmitry.man.weatherapplication.app.main.today.TodayFragmentPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface MainComponent {

    fun inject(todayFragmentPresenter: TodayFragmentPresenter)
    fun inject(mainActivityPresenter: MainActivityPresenter)
}