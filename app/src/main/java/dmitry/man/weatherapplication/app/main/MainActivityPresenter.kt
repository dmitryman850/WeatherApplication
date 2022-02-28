package dmitry.man.weatherapplication.app.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import dmitry.man.weatherapplication.app.WeatherApplication
import dmitry.man.weatherapplication.app.main.interactor.WeatherInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainActivityScreen>() {

    @Inject
    lateinit var weatherInteractor: WeatherInteractor

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        weatherInteractor.requestTodayWeather()
            .subscribeOn(Schedulers.io())
            .doOnError {
                it.printStackTrace()
            }
            .subscribe()
            .also { disposables.add(it) }

        weatherInteractor.requestFiveDaysWeather()
            .subscribeOn(Schedulers.io())
            .doOnError {
                it.printStackTrace()
            }
            .subscribe()
            .also { disposables.add(it) }
    }

    override fun onDestroy() {
        super.onDestroy()

        disposables.clear()
    }

    init {
        WeatherApplication.mainComponent.inject(this)
    }
}