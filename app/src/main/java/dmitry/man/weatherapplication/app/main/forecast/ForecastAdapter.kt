package dmitry.man.weatherapplication.app.main.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.ListItem

class ForecastAdapter(
) : RecyclerView.Adapter<BaseViewHolderForecast<*>>() {

    private var listOfWeather: List<ListItem?>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolderForecast<*> {
        var holder: BaseViewHolderForecast<*>? = null
        val viewForecastWeather = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_forecast_weather, parent, false)

        val viewDayOfTheWeek = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_day_of_the_week_forecast_weather, parent, false)
        when (viewType) {
            0 -> {
                holder = ForecastWeatherViewHolder(viewForecastWeather)
            }
            1 -> {
                holder = ForecastDayOfTheWeekViewHolder(viewDayOfTheWeek)
            }
        }
        return holder as BaseViewHolderForecast<*>
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 1
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolderForecast<*>, position: Int) {
        val item = listOfWeather?.get(position) ?: return
        when (holder) {
            is ForecastWeatherViewHolder -> {
                holder.bind(item, position)
            }
            is ForecastDayOfTheWeekViewHolder -> {
                holder.bind(item, position)
            }
            else -> {
                throw IllegalArgumentException(
                    "No viewHolder to show this data, did you forgot " +
                            "to add it to the onBindViewHolder?"
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfWeather?.size ?: 0
    }

    fun submitList(newList: List<ListItem?>) {
        listOfWeather = newList
        notifyDataSetChanged()
    }
}