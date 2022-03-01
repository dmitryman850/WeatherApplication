package dmitry.man.weatherapplication.app.main.forecast

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolderForecast<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}