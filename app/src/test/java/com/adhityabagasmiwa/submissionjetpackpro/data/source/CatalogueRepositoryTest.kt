package com.adhityabagasmiwa.submissionjetpackpro.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.RemoteDataSource
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy
import com.adhityabagasmiwa.submissionjetpackpro.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.mock

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val moviesResponse = DataDummy.getRemoteMovies()
    private val moviesId = moviesResponse[0].id.toString()
    private val moviesDetail = DataDummy.getRemoteDetailsMovies()

    private val tvShowResponse = DataDummy.getRemoteTvShow()
    private val tvShowId = tvShowResponse[0].id.toString()
    private val tvShowDetail = DataDummy.getRemoteDetailsTvShow()

    @Test
    fun getMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.GetMoviesCallback).onResponse(moviesResponse)
            null
        }.`when`(remote).getMovies(any())

        val moviesEntities = LiveDataTestUtil.getValue(catalogueRepository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(moviesEntities)
        assertEquals(moviesResponse.size, moviesEntities.size)
    }

    @Test
    fun getTvShow() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.GetTvShowCallback).onResponse(tvShowResponse)
            null
        }.`when`(remote).getTvShow(any())

        val tvShowsEntities = LiveDataTestUtil.getValue(catalogueRepository.getTvShow())
        verify(remote).getTvShow(any())
        assertNotNull(tvShowsEntities)
        assertEquals(tvShowResponse.size, tvShowsEntities.size)
    }

    @Test
    fun getDetailsMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.GetDetailsMovieCallback).onResponse(moviesDetail)
            null
        }.`when`(remote).getDetailsMovies(any(), eq(moviesId))

        val moviesDetailsEntity = LiveDataTestUtil.getValue(catalogueRepository.getDetailsMovies(moviesId))
        verify(remote).getDetailsMovies(any(), eq(moviesId))
        assertNotNull(moviesDetailsEntity)
        assertEquals(moviesDetail.id, moviesDetailsEntity.id)
    }

    @Test
    fun getDetailsTvShow() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.GetDetailsTvShowCallback).onResponse(tvShowDetail)
            null
        }.`when`(remote).getDetailsTvShow(any(), eq(tvShowId))

        val tvShowsEntities = LiveDataTestUtil.getValue(catalogueRepository.getDetailsTvShow(tvShowId))
        verify(remote).getDetailsTvShow(any(), eq(tvShowId))
        assertNotNull(tvShowsEntities)
        assertEquals(tvShowDetail.id, tvShowsEntities.id)
    }
}