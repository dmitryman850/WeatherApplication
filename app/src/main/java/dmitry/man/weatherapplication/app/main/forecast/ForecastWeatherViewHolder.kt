package dmitry.man.weatherapplication.app.main.forecast

import android.view.View
import android.widget.TextView
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherItemModel

class ForecastWeatherViewHolder(
    itemView: View
) : BaseViewHolderForecast<FiveDaysWeatherItemModel>(itemView) {

    private var time: TextView = itemView.findViewById(R.id.tv_time)
    private var cloud: TextView = itemView.findViewById(R.id.tv_cloud)
    private var temp: TextView = itemView.findViewById(R.id.tv_temp)

    override fun bind(item: FiveDaysWeatherItemModel, position: Int) {
        time.text = item.time
        cloud.text = item.descriptionWeather
        temp.text = item.temp
    }
}