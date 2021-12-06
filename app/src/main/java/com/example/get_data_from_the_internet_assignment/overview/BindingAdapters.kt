package com.example.get_data_from_the_internet_assignment.overview

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import com.example.get_data_from_the_internet_assignment.R
import com.example.get_data_from_the_internet_assignment.network.Photo
import java.util.*


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}


@BindingAdapter("listData")
//fun RecyclerView.setData(list : List<Photo>?) {
//
////    if(this.adapter==null){
////        this.adapter = PhotoGridAdapter()
////    }
fun bindRecyclerView(recyclerView: RecyclerView, list: List<Photo>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(list)
}

@BindingAdapter("ApiStatus")
fun bindStatus(statusImageView: ImageView, status: CountriesFlagsViewmodel.ApiStatus?) {
    when (status) {
        CountriesFlagsViewmodel.ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CountriesFlagsViewmodel.ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        CountriesFlagsViewmodel.ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
