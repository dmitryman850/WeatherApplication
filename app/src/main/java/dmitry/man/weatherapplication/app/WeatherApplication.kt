package dmitry.man.weatherapplication.app

import android.app.Application
import dmitry.man.weatherapplication.app.di.DaggerMainComponent
import dmitry.man.weatherapplication.app.di.MainComponent

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .build()
    }

    companion object {
        lateinit var mainComponent: MainComponent
            private set
    }
}