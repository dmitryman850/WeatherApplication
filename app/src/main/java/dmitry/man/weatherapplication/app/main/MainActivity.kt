package dmitry.man.weatherapplication.app.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), MainActivityScreen {

    private lateinit var binding: ActivityMainBinding

    @InjectPresenter
    lateinit var activityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(
            R.id.nav_host_fragment_activity_main
        )
        navView.setupWithNavController(navController)
    }
}