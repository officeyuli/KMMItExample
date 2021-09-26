package com.officeyuli.kmmitexample.android

import androidx.lifecycle.*
import com.officeyuli.kmmforitframwork.ktor.response.CafeResponseItem
import com.officeyuli.kmmitexample.DataRepository
import com.officeyuli.kmmitexample.ktor.CafeApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel() , KoinComponent{
    private val dataRepository: DataRepository = DataRepository()
    private val cafeList = MutableLiveData<List<CafeResponseItem>>()
    val cafeListLiveData: LiveData<List<CafeResponseItem>> = Transformations.map(cafeList) { it }

    fun fetchCafeList(cityName :String = "taipei"){
        viewModelScope.launch {
            val response = async {  dataRepository.fetchCafesFromNetwork(cityName)}
            cafeList.value = response.await()
        }
    }
}