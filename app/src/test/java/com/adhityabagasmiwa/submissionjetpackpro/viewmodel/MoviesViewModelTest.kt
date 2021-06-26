package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.adhityabagasmiwa.submissionjetpackpro.data.source.CatalogueRepository
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instaTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository : CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<CatalogueEntity>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(catalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.getMovies()
        val movies = MutableLiveData<List<CatalogueEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getMovies()).thenReturn(movies)
        val movie = viewModel.getMovies().value
        verify(catalogueRepository).getMovies()
        assertNotNull(movie)
        assertEquals(10, movie?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}