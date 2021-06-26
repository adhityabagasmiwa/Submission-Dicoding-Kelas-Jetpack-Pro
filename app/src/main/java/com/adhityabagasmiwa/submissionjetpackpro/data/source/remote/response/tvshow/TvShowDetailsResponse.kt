package com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowDetailsResponse(
	val id: Int? = null,
	val name: String? = null,
	val overview: String? = null,
	val genres: List<GenresItem>? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null,

	@field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("episode_run_time")
	val episodeRunTime: List<Int>? = null,
)

data class GenresItem(
	val id: Int? = null,
	val name: String? = null
)

