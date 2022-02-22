package dmitry.man.weatherapplication.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dmitry.man.weatherapplication.databinding.FragmentTodayBinding

class TodayFragment : MvpAppCompatFragment(), TodayScreen {

    private var _binding: FragmentTodayBinding? = null

    private val binding get() = _binding!!

    @InjectPresenter
    private var presenter: TodayPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}