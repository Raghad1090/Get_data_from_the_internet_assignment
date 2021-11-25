package com.example.get_data_from_the_internet_assignment.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.get_data_from_the_internet_assignment.databinding.FragmentCountriesFlagsBinding
import com.example.get_data_from_the_internet_assignment.databinding.GridViewItemBinding



class Countries_Flags_Fragment : Fragment() {

    private val viewModel : CountriesFlagsViewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCountriesFlagsBinding.inflate(inflater)

//        val binding = GridViewItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.photosGrid.adapter = PhotoGridAdapter()

        // Inflate the layout for this fragment
        return binding.root
    }
}