package com.example.get_data_from_the_internet_assignment.network

import com.squareup.moshi.Json

data class CountriesFlagsPhoto (val error : Boolean , val msg: String , val data : List<photos>)

data class photos (@Json(name = "name") val name : String, @Json(name = "flag") val flagUrl: String)