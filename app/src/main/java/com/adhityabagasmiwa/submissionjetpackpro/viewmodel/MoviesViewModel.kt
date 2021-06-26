package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhityabagasmiwa.submissionjetpackpro.data.source.CatalogueRepository
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity

class MoviesViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getMovies() : LiveData<List<CatalogueEntity>> = catalogueRepository.getMovies()
}