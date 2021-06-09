package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import com.adhityabagasmiwa.submissionjetpackpro.data.model.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies() : List<CatalogueEntity> = DataDummy.getMovies()
}