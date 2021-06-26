package com.adhityabagasmiwa.submissionjetpackpro.data.source.remote

import android.util.Log
import com.adhityabagasmiwa.submissionjetpackpro.BuildConfig.API_KEY
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesItems
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowItems
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowResponse
import com.adhityabagasmiwa.submissionjetpackpro.network.ApiConfig
import com.adhityabagasmiwa.submissionjetpackpro.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    private val TAG = "RemoteDataSource"
    private val apiConfig = ApiConfig

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource()
        }
    }

    fun getMovies(callback: GetMoviesCallback) {
        EspressoIdlingResource.increment()
        val client = apiConfig.getApiService().getMovies(API_KEY)
        client.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                callback.onResponse(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e(TAG, t.printStackTrace().toString())
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTvShow(callback: GetTvShowCallback) {
        EspressoIdlingResource.increment()
        val client = apiConfig.getApiService().getTvShow(API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                callback.onResponse(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, t.printStackTrace().toString())
            }
        })
    }

    fun getDetailsMovies(callback: GetDetailsMovieCallback, movieId: String) {
        EspressoIdlingResource.increment()
        val client = apiConfig.getApiService().getDetailsMovies(movieId, API_KEY)
        client.enqueue(object : Callback<MoviesDetailsResponse> {
            override fun onResponse(call: Call<MoviesDetailsResponse>, response: Response<MoviesDetailsResponse>) {
                callback.onResponse(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesDetailsResponse>, t: Throwable) {
                Log.e(TAG, t.printStackTrace().toString())
            }
        })
    }

    fun getDetailsTvShow(callback: GetDetailsTvShowCallback, tvId: String) {
        EspressoIdlingResource.increment()
        val client = apiConfig.getApiService().getDetailsTvShow(tvId, API_KEY)
        client.enqueue(object : Callback<TvShowDetailsResponse> {
            override fun onResponse(call: Call<TvShowDetailsResponse>, response: Response<TvShowDetailsResponse>) {
                callback.onResponse(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowDetailsResponse>, t: Throwable) {
                Log.e(TAG, t.printStackTrace().toString())
            }
        })
    }

    interface GetMoviesCallback {
        fun onResponse(movies: List<MoviesItems>?)
    }

    interface GetTvShowCallback {
        fun onResponse(tvShows: List<TvShowItems>?)
    }

    interface GetDetailsMovieCallback {
        fun onResponse(movieDetail: MoviesDetailsResponse?)
    }

    interface GetDetailsTvShowCallback {
        fun onResponse(tvShowDetail: TvShowDetailsResponse?)
    }
}