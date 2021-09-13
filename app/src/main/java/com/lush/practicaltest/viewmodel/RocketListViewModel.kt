package com.lush.practicaltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lush.practicaltest.util.Resource
import com.lush.practicaltest.api.response.RocketDataResponse
import com.lush.practicaltest.repo.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RocketListViewModel @Inject constructor(
    private val repository: ApiRepository,
) : ViewModel() {

    fun getRocketList(): LiveData<Resource<ArrayList<RocketDataResponse.RocketDataResponseItem>>> {
        return repository.getRocketList()
    }

}
