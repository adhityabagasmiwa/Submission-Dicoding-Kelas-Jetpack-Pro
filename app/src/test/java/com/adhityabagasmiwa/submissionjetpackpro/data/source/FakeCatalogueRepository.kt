package com.adhityabagasmiwa.submissionjetpackpro.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.DetailEntity
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.RemoteDataSource
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.movies.MoviesItems
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowDetailsResponse
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.response.tvshow.TvShowItems

class FakeCatalogueRepository (private val remoteDataSource: RemoteDataSource) : CatalogueDataSource {

    override fun getMovies(): LiveData<List<CatalogueEntity>> {
        val movieResults = MutableLiveData<List<CatalogueEntity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.GetMoviesCallback {
            override fun onResponse(movies: List<MoviesItems>?) {
                val movieList = ArrayList<CatalogueEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = CatalogueEntity(id, title, posterPath, voteAverage, overview)
                            movieList.add(movie)
                        }
                    }
                    movieResults.postValue(movieList)
                }
            }
        })
        return movieResults
    }

    override fun getTvShow(): LiveData<List<CatalogueEntity>> {
        val tvShowResults = MutableLiveData<List<CatalogueEntity>>()
        remoteDataSource.getTvShow(object : RemoteDataSource.GetTvShowCallback {
            override fun onResponse(tvShows: List<TvShowItems>?) {
                val tvShowList = ArrayList<CatalogueEntity>()
                if (tvShows != null) {
                    for (response in tvShows) {
                        with(response) {
                            val tvShow = CatalogueEntity(id, name, posterPath, voteAverage, overview)
                            tvShowList.add(tvShow)
                        }
                    }
                    tvShowResults.postValue(tvShowList)
                }
            }
        })
        return tvShowResults
    }

    override fun getDetailsMovies(movieId: String): LiveData<DetailEntity> {
        val movieDetailResult = MutableLiveData<DetailEntity>()
        remoteDataSource.getDetailsMovies(object : RemoteDataSource.GetDetailsMovieCallback {
            override fun onResponse(movieDetail: MoviesDetailsResponse?) {
                if (movieDetail != null) {
                    with(movieDetail) {
                        val listGenres = ArrayList<String>()
                        if (genres != null) {
                            for (genre in genres!!) {
                                listGenres.add(genre.name!!)
                            }
                        }

                        val movie = DetailEntity(
                            id = id,
                            title = title,
                            overview = overview,
                            runtime = runtime,
                            genres = listGenres,
                            backdropPath = backdropPath,
                            posterPath = posterPath,
                            voteCount = voteCount,
                            voteAverage = voteAverage,
                            releaseDate = releaseDate
                        )
                        movieDetailResult.postValue(movie)
                    }
                }
            }
        }, movieId)
        return movieDetailResult
    }

    override fun getDetailsTvShow(tvId: String): LiveData<DetailEntity> {
        val tvShowDetailResult = MutableLiveData<DetailEntity>()
        remoteDataSource.getDetailsTvShow(object : RemoteDataSource.GetDetailsTvShowCallback {
            override fun onResponse(tvShowDetail: TvShowDetailsResponse?) {
                if (tvShowDetail != null) {
                    with(tvShowDetail) {
                        val listGenres = ArrayList<String>()
                        if (genres != null) {
                            for (genre in genres!!) {
                                listGenres.add(genre.name!!)
                            }
                        }

                        val tvShow = DetailEntity(
                            id = id,
                            title = name,
                            overview = overview,
                            runtime = episodeRunTime?.average()?.toInt(),
                            genres = listGenres,
                            backdropPath = backdropPath,
                            posterPath = posterPath,
                            voteCount = voteCount,
                            voteAverage = voteAverage,
                            releaseDate = firstAirDate
                        )
                        tvShowDetailResult.postValue(tvShow)
                    }
                }
            }
        }, tvId)
        return tvShowDetailResult
    }
}