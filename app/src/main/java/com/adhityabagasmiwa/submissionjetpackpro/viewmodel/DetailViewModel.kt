package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import com.adhityabagasmiwa.submissionjetpackpro.data.model.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy

class DetailViewModel : ViewModel() {
    private var moviesId: Int = 0
    private var tvId: Int = 0
    private lateinit var result: CatalogueEntity

    private fun getMovies(): List<CatalogueEntity> = DataDummy.getMovies()

    private fun getTvShow(): List<CatalogueEntity> = DataDummy.getTvShows()

    fun setSelectedMovies(moviesId: Int) {
        this.moviesId = moviesId
    }

    fun setSelectedTvShow(tvId: Int) {
        this.tvId = tvId
    }

    fun getMoviesById(): CatalogueEntity {
        val listMovies = getMovies()
        for (movies in listMovies) {
            if (movies.id == moviesId) {
                result = movies
            }
        }
        return result
    }

    fun getTvShowById(): CatalogueEntity {
        val listTvShow = getTvShow()
        for (tvShow in listTvShow) {
            if (tvShow.id == tvId) {
                result = tvShow
            }
        }
        return result
    }
}