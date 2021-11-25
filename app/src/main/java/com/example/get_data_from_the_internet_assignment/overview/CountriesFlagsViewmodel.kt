package com.example.get_data_from_the_internet_assignment.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.get_data_from_the_internet_assignment.network.CountriesApi
import com.example.get_data_from_the_internet_assignment.network.photos
import kotlinx.coroutines.launch
import java.lang.Exception

class CountriesFlagsViewmodel : ViewModel() {


    private val _photos = MutableLiveData<List<photos>>()

    val photos: LiveData<List<photos>> = _photos


    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getCountriesPhotos()
    }


    private fun getCountriesPhotos() {

        viewModelScope.launch {
            try {
                val listResult = CountriesApi.retrofitService.getPhotos()
                _status.value = "Success: countries photos retrieved"
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}