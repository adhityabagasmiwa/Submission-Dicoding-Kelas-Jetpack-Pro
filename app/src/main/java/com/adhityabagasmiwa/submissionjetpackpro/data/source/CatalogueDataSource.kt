package com.adhityabagasmiwa.submissionjetpackpro.data.source

import androidx.lifecycle.LiveData
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.DetailEntity

interface CatalogueDataSource {
    fun getMovies(): LiveData<List<CatalogueEntity>>

    fun getTvShow(): LiveData<List<CatalogueEntity>>

    fun getDetailsMovies(movieId: String): LiveData<DetailEntity>

    fun getDetailsTvShow(tvId: String): LiveData<DetailEntity>
}