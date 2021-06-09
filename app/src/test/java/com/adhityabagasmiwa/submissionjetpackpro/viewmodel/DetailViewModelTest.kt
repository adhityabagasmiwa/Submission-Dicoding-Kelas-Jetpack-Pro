package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.getMovies()[0]
    private val dummyTvShow = DataDummy.getTvShows()[0]
    private val moviesId = dummyMovies.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        moviesId?.let { viewModel.setSelectedMovies(it) }
        tvShowId?.let { viewModel.setSelectedTvShow(it) }
    }

    @Test
    fun getMoviesById() {
        val movies = viewModel.getMoviesById()
        assertNotNull(movies)
        assertEquals(dummyMovies.title, movies.title)
        assertEquals(dummyMovies.release_date, movies.release_date)
        assertEquals(dummyMovies.genres, movies.genres)
        assertEquals(dummyMovies.duration, movies.duration)
        assertEquals(dummyMovies.vote_count, movies.vote_count)
        assertEquals(dummyMovies.score, movies.score)
        assertEquals(dummyMovies.overview, movies.overview)
        assertEquals(dummyMovies.trailer_key, movies.trailer_key)
        assertEquals(dummyMovies.poster, movies.poster)
        assertEquals(dummyMovies.big_poster, movies.big_poster)
    }

    @Test
    fun getTvShowById() {
        val tvShow = viewModel.getTvShowById()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.release_date, tvShow.release_date)
        assertEquals(dummyTvShow.genres, tvShow.genres)
        assertEquals(dummyTvShow.duration, tvShow.duration)
        assertEquals(dummyTvShow.vote_count, tvShow.vote_count)
        assertEquals(dummyTvShow.score, tvShow.score)
        assertEquals(dummyTvShow.overview, tvShow.overview)
        assertEquals(dummyTvShow.trailer_key, tvShow.trailer_key)
        assertEquals(dummyTvShow.poster, tvShow.poster)
        assertEquals(dummyTvShow.big_poster, tvShow.big_poster)
    }
}