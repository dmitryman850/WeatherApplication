package dmitry.man.weatherapplication.app.main.forecast

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import dmitry.man.weatherapplication.app.WeatherApplication
import dmitry.man.weatherapplication.app.main.interactor.WeatherInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class ForecastFragmentPresenter : MvpPresenter<ForecastFragmentScreen>() {

    @Inject
    lateinit var weatherInteractor: WeatherInteractor

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        weatherInteractor.observeFiveDaysWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoad(true)
            }
            .subscribe(
                {
                    viewState.showLoad(false)
                    viewState.refreshWeatherData(it)
                },
                {
                    viewState.showError()
                    it.printStackTrace()
                }
            )
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