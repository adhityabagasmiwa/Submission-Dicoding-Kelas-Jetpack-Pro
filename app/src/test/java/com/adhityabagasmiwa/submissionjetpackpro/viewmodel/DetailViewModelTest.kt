package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.data.source.CatalogueRepository
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.DetailEntity
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.getDetailsMovies()
    private val dummyTvShow = DataDummy.getDetailsTvShow()
    private val moviesId = dummyMovies.id.toString()
    private val tvShowId = dummyTvShow.id.toString()

    @get:Rule
    var instaTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository : CatalogueRepository

    @Mock
    private lateinit var observer: Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getMoviesById() {
        val movie = MutableLiveData<DetailEntity>()
        movie.value = dummyMovies

        `when`(catalogueRepository.getDetailsMovies(moviesId)).thenReturn(movie)
        viewModel.setCatalogue(moviesId, R.string.movies_type.toString())
        val movies = viewModel.getCatalogueDetail().value as DetailEntity
        verify(catalogueRepository).getDetailsMovies(moviesId)

        assertNotNull(movies)
        assertEquals(dummyMovies.title, movies.title)
        assertEquals(dummyMovies.overview, movies.overview)
        assertEquals(dummyMovies.runtime, movies.runtime)
        assertEquals(dummyMovies.genres, movies.genres)
        assertEquals(dummyMovies.backdropPath, movies.backdropPath)
        assertEquals(dummyMovies.posterPath, movies.posterPath)
        assertEquals(dummyMovies.voteCount, movies.voteCount)
        assertEquals(dummyMovies.voteAverage, movies.voteAverage)
        assertEquals(dummyMovies.releaseDate, movies.releaseDate)

        viewModel.getCatalogueDetail().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getTvShowById() {
        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getDetailsTvShow(tvShowId)).thenReturn(tvShow)
        viewModel.setCatalogue(tvShowId, R.string.tv_type.toString())
        val tvShows = viewModel.getCatalogueDetail().value as DetailEntity
        verify(catalogueRepository).getDetailsTvShow(tvShowId)

        assertNotNull(tvShows)
        assertEquals(dummyTvShow.title, tvShows.title)
        assertEquals(dummyTvShow.overview, tvShows.overview)
        assertEquals(dummyTvShow.runtime, tvShows.runtime)
        assertEquals(dummyTvShow.genres, tvShows.genres)
        assertEquals(dummyTvShow.backdropPath, tvShows.backdropPath)
        assertEquals(dummyTvShow.posterPath, tvShows.posterPath)
        assertEquals(dummyTvShow.voteCount, tvShows.voteCount)
        assertEquals(dummyTvShow.voteAverage, tvShows.voteAverage)
        assertEquals(dummyTvShow.releaseDate, tvShows.releaseDate)

        viewModel.getCatalogueDetail().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}