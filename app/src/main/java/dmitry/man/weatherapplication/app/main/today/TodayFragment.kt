package dmitry.man.weatherapplication.app.main.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import dmitry.man.weatherapplication.databinding.FragmentTodayBinding

class TodayFragment : MvpAppCompatFragment(), TodayScreen {

    private lateinit var binding: FragmentTodayBinding

    @InjectPresenter
    private lateinit var presenter: TodayPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTodayBinding.inflate(inflater)
        return binding.root
    }
}