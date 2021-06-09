package com.adhityabagasmiwa.submissionjetpackpro.data.model

data class CatalogueEntity(
    var id: Int? = 0,
    var title: String? = null,
    var release_date: String? = null,
    var genres: String? = null,
    var duration: String? = null,
    var vote_count: Int? = 0,
    var score: Double? = 0.0,
    var overview: String? = null,
    var trailer_key: String? = null,
    var poster: Int? = 0,
    var big_poster: String? = null
)
