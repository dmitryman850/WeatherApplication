package dmitry.man.weatherapplication.app.main.forecast

import android.view.View
import android.widget.TextView
import dmitry.man.weatherapplication.R
import dmitry.man.weatherapplication.app.data.model.ListItem

class ForecastWeatherViewHolder(
    itemView: View
) : BaseViewHolderForecast<ListItem?>(itemView) {

    private var time: TextView = itemView.findViewById(R.id.tv_time)
    private var cloud: TextView = itemView.findViewById(R.id.tv_cloud)
    private var temp: TextView = itemView.findViewById(R.id.tv_temp)

    override fun bind(item: ListItem?, position: Int) {
        time.text = item?.dtTxt
        cloud.text = toUpperCaseFirstLetter(item?.weather?.get(FIRST_ITEM)?.description)
        temp.text = (item?.main?.temp?.minus(KELVIN_TO_CELCIUS_ZERO))?.toInt()?.toString()
    }

    private fun toUpperCaseFirstLetter(line: String?): String? {
        var result: String? = ""
        result += line?.substring(0, 1)?.uppercase()

        for (i in 1 until line?.length!!) {
            if (" " == line.substring(i - 1, i)) result += line.substring(i, i + 1)
                .uppercase() else result += line.substring(i, i + 1)
        }
        return result
    }

    companion object {
        private const val KELVIN_TO_CELCIUS_ZERO = 273.15
        private const val FIRST_ITEM = 0
    }
}