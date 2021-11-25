package com.example.get_data_from_the_internet_assignment.overview

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.get_data_from_the_internet_assignment.network.CountriesFlagsPhoto


@BindingAdapter("imageUrl")
fun bindImage (imageView: ImageView, imgUrl: String?){

    imgUrl?.let {

      val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

      imageView.load(imgUri) {
      }
    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<CountriesFlagsPhoto>?) {

    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}


