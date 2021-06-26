package com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies

import com.google.gson.annotations.SerializedName

data class MoviesItems(
    val id: Int? = null,
    val title: String? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    val overview: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("vote_count")
    var voteCount: Int? = null,

    @field:SerializedName("backdrop_path")
    var backdropPath: String? = null,
)
