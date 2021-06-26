package com.adhityabagasmiwa.submissionjetpackpro.di

import android.content.Context
import com.adhityabagasmiwa.submissionjetpackpro.data.source.CatalogueRepository
import com.adhityabagasmiwa.submissionjetpackpro.data.source.remote.RemoteDataSource

object Injection {

    fun provideRepository(context: Context) : CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource)
    }
}