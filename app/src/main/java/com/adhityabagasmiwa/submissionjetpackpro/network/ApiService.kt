package com.adhityabagasmiwa.submissionjetpackpro.network

import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie?&sort_by=popularity.desc")
    fun getMovies(
        @Query("api_key") apiKey: String
    ): Call<MoviesResponse>

    @GET("discover/tv")
    fun getTvShow(
        @Query("api_key") apiKey: String
    ): Call<TvShowResponse>

    @GET("movie/{movie_id}")
    fun getDetailsMovies(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<MoviesDetailsResponse>

    @GET("tv/{tv_id}")
    fun getDetailsTvShow(
        @Path("tv_id") tvId: String,
        @Query("api_key") apiKey: String
    ): Call<TvShowDetailsResponse>
}