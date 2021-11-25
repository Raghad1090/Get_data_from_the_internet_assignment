package com.example.get_data_from_the_internet_assignment.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.get_data_from_the_internet_assignment.databinding.FragmentCountriesFlagsBinding
import com.example.get_data_from_the_internet_assignment.databinding.GridViewItemBinding
import com.example.get_data_from_the_internet_assignment.overview.CountriesFlagsViewmodel


class Countries_Flags_Fragment : Fragment() {

    private val viewModel : CountriesFlagsViewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val binding = FragmentCountriesFlagsBinding.inflate(inflater)

        val binding = GridViewItemBinding.inflate(inflater)

        binding.photosGrid.adapter = PhotoGridAdapter()

        binding.lifecycleOwner = this

        binding.photo = viewModel

        // Inflate the layout for this fragment
        return binding.root

    }
}