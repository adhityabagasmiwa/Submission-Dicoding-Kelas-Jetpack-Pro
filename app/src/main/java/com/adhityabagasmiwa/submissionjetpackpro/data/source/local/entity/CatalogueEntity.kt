package com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatalogueEntity(
    val id: Int? = null,
    val title: String? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("vote_average")
    val voteAverage: Double? = null,

    val overview: String? = null,

    @field:SerializedName("release_date")
    var releaseDate: String? = null,

    var genres: List<String>? = null,
    var runtime: Int? = null,

    @field:SerializedName("vote_count")
    var voteCount: Int? = null,

    @field:SerializedName("backdrop_path")
    var backdropPath: String? = null,
) : Parcelable
