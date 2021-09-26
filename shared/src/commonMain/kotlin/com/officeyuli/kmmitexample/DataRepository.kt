package com.officeyuli.kmmitexample

import com.officeyuli.kmmitexample.ktor.CafeApi
import com.officeyuli.kmmitexample.ktor.CafeApiImpl

class DataRepository {
    companion object {
        val tag = DataRepository::class.simpleName
    }

    private val ktorApi: CafeApi by lazy { CafeApiImpl() }

    suspend fun fetchCafesFromNetwork(cityName: String) =ktorApi.fetchCafeFromApi(cityName)

//    suspend fun fetchCafesFromNetwork(cityName: String): DataState {
//        return try {
//            val cafeResponseItemList =  ktorApi.fetchCafeFromApi(cityName)
//            if(cafeResponseItemList.isEmpty()){
//                DataState(empty = true)
//            } else {
//                DataState(cafeResponseItemList)
//            }
//        } catch (e: Exception) {
//            println(e.message)
//            DataState(exception = "Can't fetch data from Network")
//        }
//
//    }

}