package com.adhityabagasmiwa.submissionjetpackpro.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.adhityabagasmiwa.submissionjetpackpro.data.source.CatalogueRepository
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instaTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository : CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<CatalogueEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.getTvShows()
        val tvShows = MutableLiveData<List<CatalogueEntity>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(catalogueRepository.getTvShow()).thenReturn(tvShows)
        val tvShow = viewModel.getTvShow().value
        verify(catalogueRepository).getTvShow()
        assertNotNull(tvShow)
        assertEquals(10, tvShow?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}