package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhityabagasmiwa.submissionjetpackpro.data.source.CatalogueRepository
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvShow() : LiveData<List<CatalogueEntity>> = catalogueRepository.getTvShow()
}