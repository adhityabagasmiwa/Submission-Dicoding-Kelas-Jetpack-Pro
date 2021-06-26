package com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowItems(
	val id: Int? = null,
	val name: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	val overview: String? = null,

	@field:SerializedName("first_air_date")
	val firstAirDate: String? = null,

	@field:SerializedName("vote_count")
	var voteCount: Int? = null,

	@field:SerializedName("backdrop_path")
	var backdropPath: String? = null,

)
