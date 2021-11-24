package com.example.get_data_from_the_internet_assignment.network

import com.squareup.moshi.Json

data class countriesPhoto (@Json(name = "id") val id : String, @Json(name = "img_src") val imgSrcUrl: String) {

}