package com.example.get_data_from_the_internet_assignment.overview

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.get_data_from_the_internet_assignment.network.Photo
import java.util.*


@BindingAdapter("imageUrl")
fun bindImage (imageView: ImageView, imgUrl: String?){

    imgUrl?.let {

      val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

      imageView.load(imgUri) {

      }

    }
}


@BindingAdapter("listData")
fun RecyclerView.setData(list : List<Photo>?) {

    if(this.adapter==null){
        this.adapter = PhotoGridAdapter()
    }

    val adapter = this.adapter as PhotoGridAdapter
    adapter.submitList(list)
}