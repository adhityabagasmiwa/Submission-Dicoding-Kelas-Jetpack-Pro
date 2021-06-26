package com.adhityabagasmiwa.submissionjetpackpro.utils

import android.content.Context
import android.widget.ImageView
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun timeConvertMovies(runtime: Int): String {
    val hours = runtime / 60
    val minutes = runtime % 60
    return "$hours hours $minutes mins"
}

fun timeConvertTvShow(runtime: Int): String {
    val hours = runtime / 60
    val minutes = runtime % 60
    return when (hours) {
        0 -> {
            "$minutes mins / episode"
        }
        1 -> {
            "$hours hours / episode"
        }
        else -> {
            "$hours hours $minutes mins / episode"
        }
    }
}

fun formatDate(date: String): String {
    val dateOld = LocalDate.parse(date)
    val dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val dateNew = dateOld.format(dateFormat)
    return if (dateOld != null) {
        dateNew.toString()
    } else {
        ""
    }
}

fun glideConfig(context: Context, url: String, imageView: ImageView) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
        )
        .into(imageView)
}