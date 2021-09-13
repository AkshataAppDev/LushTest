package com.lush.practicaltest.repo

import com.lush.practicaltest.util.performGetOperation
import com.lush.practicaltest.api.ApiService
import com.lush.practicaltest.api.RemoteDataSource
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val apiService: ApiService
) {

    fun create(): ApiRepository =
        ApiRepository(remoteDataSource, apiService)

    fun getRocketList() =
        performGetOperation(
            networkCall = { remoteDataSource.getRocketList() },
        )
}