package com.example.get_data_from_the_internet_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.get_data_from_the_internet_assignment.viewModel.countriesViewmodel


class number_of_countries_Fragment : Fragment() {

    private val viewModel : countriesViewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_number_of_countries_, container, false)
    }


}