package com.example.get_data_from_the_internet_assignment.overview

import android.provider.Contacts
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.get_data_from_the_internet_assignment.databinding.GridViewItemBinding
import com.example.get_data_from_the_internet_assignment.network.Photo


class PhotoGridAdapter : ListAdapter<Photo, PhotoGridAdapter.CountriesFlagsPhotoViewHolder>(DiffCallback) {


    class CountriesFlagsPhotoViewHolder (private var binding:
    GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.photo = photo
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {

            return oldItem.name == newItem.name

        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.flagUrl == newItem.flagUrl
        }
    }


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.CountriesFlagsPhotoViewHolder {

        return CountriesFlagsPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.CountriesFlagsPhotoViewHolder, position: Int) {

        val flagPhoto = getItem(position)
        holder.bind(flagPhoto)
    }



}


