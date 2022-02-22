package dmitry.man.weatherapplication.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dmitry.man.weatherapplication.databinding.FragmentForecastBinding

class ForecastFragment : MvpAppCompatFragment(), ForecastScreen {

    private var _binding: FragmentForecastBinding? = null

    private val binding get() = _binding!!

    @InjectPresenter
    private var presenter: ForecastPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForecastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}