package com.example.get_data_from_the_internet_assignment.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.get_data_from_the_internet_assignment.network.CountriesApi
import com.example.get_data_from_the_internet_assignment.network.Photo
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*


class CountriesFlagsViewmodel : ViewModel() {

    enum class ApiStatus {LOADING , ERROR , DONE }

    private val _photos = MutableLiveData<List<Photo>>()

    val photos: LiveData<List<Photo>> = _photos


    private val _name = MutableLiveData<List<Photo>>()
    val name: LiveData<List<Photo>> = _name


    private val _status = MutableLiveData<ApiStatus>()

    val status: LiveData<ApiStatus> = _status

    init {
        getCountriesPhotos()
    }


    private fun getCountriesPhotos() {

        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
//                val listResult = CountriesApi.retrofitService.getPhotos()
                _photos.value = CountriesApi.retrofitService.getPhotos().data
                _status.value = ApiStatus.DONE
            } catch (e: Exception){
                _status.value = ApiStatus.ERROR
                _photos.value = listOf()
            }

        }
    }
}