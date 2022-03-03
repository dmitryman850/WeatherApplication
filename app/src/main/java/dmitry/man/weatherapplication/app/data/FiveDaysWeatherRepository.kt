package dmitry.man.weatherapplication.app.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dmitry.man.weatherapplication.app.WeatherApplication
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherData
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherItemModel
import dmitry.man.weatherapplication.app.data.model.FiveDaysWeatherModel
import dmitry.man.weatherapplication.app.db.FiveDaysWeatherDatabase
import dmitry.man.weatherapplication.app.db.dao.FiveDaysWeatherDao
import dmitry.man.weatherapplication.app.db.entity.FiveDaysWeatherDataEntity
import dmitry.man.weatherapplication.app.db.entity.FiveDaysWeatherItem
import io.reactivex.Observable
import java.lang.reflect.Type
import javax.inject.Inject

class FiveDaysWeatherRepository(
    private val dao: FiveDaysWeatherDao,
    private val gson: Gson
) {

    @Inject
    lateinit var fiveDaysWeatherDb: FiveDaysWeatherDatabase

    fun save(data: FiveDaysWeatherData) {
        dao.insert(data.toEntity())
    }

    fun getAll(): Observable<FiveDaysWeatherModel> {
        return dao.getAll().map {
            it.toModel()
        }
    }

    private fun FiveDaysWeatherData.toEntity(): FiveDaysWeatherDataEntity {
        val list = this.list?.map {
            FiveDaysWeatherItem(
                it?.main?.temp?.minus(KELVIN_TO_CELCIUS_ZERO)?.toInt()?.toString(),
                it?.dtTxt,
                toUpperCaseFirstLetter(it?.weather?.get(FIRST_ITEM)?.description)
            )
        }

        return FiveDaysWeatherDataEntity(
            0,
            this.city?.name,
            gson.toJson(list)
        )
    }

    private fun FiveDaysWeatherDataEntity.toModel(): FiveDaysWeatherModel {
        val type: Type = object : TypeToken<List<FiveDaysWeatherItemModel>>() {}.type

        return FiveDaysWeatherModel(
            this.cityName,
            gson.fromJson<List<FiveDaysWeatherItemModel>>(this.listWeather, type)
        )
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

    init {
        WeatherApplication.mainComponent.inject(this)
    }

    companion object {
        private const val KELVIN_TO_CELCIUS_ZERO = 273.15
        private const val FIRST_ITEM = 0
    }
}