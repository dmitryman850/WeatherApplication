package dmitry.man.weatherapplication.app.main.forecast

import android.view.View
import android.widget.TextView
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherItemModel
import dmitry.man.weatherapplication.app.data.model.ListItem

class ForecastDayOfTheWeekViewHolder(
    itemView: View
) : BaseViewHolderForecast<FiveDaysWeatherItemModel>(itemView) {

    var nameOfDay: TextView = itemView.findViewById(R.id.tv_day_of_the_week)

    override fun bind(item: FiveDaysWeatherItemModel, position: Int) {
        
    }
}