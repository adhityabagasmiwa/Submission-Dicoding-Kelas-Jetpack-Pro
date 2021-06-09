package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import com.adhityabagasmiwa.submissionjetpackpro.data.model.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow() : List<CatalogueEntity> = DataDummy.getTvShows()
}