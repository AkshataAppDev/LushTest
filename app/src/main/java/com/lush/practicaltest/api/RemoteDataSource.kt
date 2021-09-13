package com.lush.practicaltest.api

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource() {

    suspend fun getRocketList() =
        getResult { apiService.getRocketList() }

}