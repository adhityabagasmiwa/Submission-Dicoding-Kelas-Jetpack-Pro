package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.data.source.CatalogueRepository
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.DetailEntity

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    private lateinit var result: LiveData<DetailEntity>

    fun setCatalogue(id: String, type: String) {
        when (type) {
            R.string.movies_type.toString() -> {
                result = catalogueRepository.getDetailsMovies(id)
            }
            R.string.tv_type.toString() -> {
                result = catalogueRepository.getDetailsTvShow(id)
            }
        }
    }

    fun getCatalogueDetail() = result
}