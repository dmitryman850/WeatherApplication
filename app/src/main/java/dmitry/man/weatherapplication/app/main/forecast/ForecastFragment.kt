package dmitry.man.weatherapplication.app.main.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
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
}