package com.example.get_data_from_the_internet_assignment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.get_data_from_the_internet_assignment.network.countriesApi
import java.lang.Exception

class countriesViewmodel : ViewModel() {


    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getCountriesPhotos()
    }


    private fun getCountriesPhotos() {

        viewModelScope.launch {
            try {
                val listResult = countriesApi.retrofitService.getPhotos()
                _status.value = "Success: ${listResult.size} countries photos retrieved"
            } catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}