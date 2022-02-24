package dmitry.man.weatherapplication.app.data.model

import com.google.gson.annotations.SerializedName

data class Coord(

	@field:SerializedName("lon")
	val lon: Int? = null,

	@field:SerializedName("lat")
	val lat: Int? = null
)