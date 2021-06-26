package com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies

import com.google.gson.annotations.SerializedName

data class MoviesDetailsResponse(
    val id: Int? = null,
    val title: String? = null,
    val overview: String? = null,
    val runtime: Int? = null,
    val genres: List<GenresItem>? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,
)

data class GenresItem(
    val id: Int? = null,
    val name: String? = null
)
