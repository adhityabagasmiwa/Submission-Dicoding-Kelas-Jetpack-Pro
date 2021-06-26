package com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailEntity(
    val id: Int? = null,
    val title: String? = null,
    val overview: String? = null,
    val runtime: Int? = null,
    val genres: List<String>? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,
) : Parcelable
