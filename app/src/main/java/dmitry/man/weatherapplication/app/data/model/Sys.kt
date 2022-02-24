package dmitry.man.weatherapplication.app.data.model

import com.google.gson.annotations.SerializedName

data class Sys(

	@field:SerializedName("pod")
	val pod: String? = null
)