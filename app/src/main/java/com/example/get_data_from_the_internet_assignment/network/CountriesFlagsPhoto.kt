package com.example.get_data_from_the_internet_assignment.network

import com.squareup.moshi.Json
import java.util.*

data class CountriesFlagsPhoto (val error : Boolean , val msg: String , val data : List<Photo>)

data class Photo (@Json(name = "name") val name : String, @Json(name = "flag") val flagUrl: String)