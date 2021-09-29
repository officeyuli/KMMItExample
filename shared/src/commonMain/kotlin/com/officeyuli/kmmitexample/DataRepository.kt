package com.officeyuli.kmmitexample

import com.officeyuli.kmmforitframwork.ktor.response.CafeResponseItem
import com.officeyuli.kmmitexample.ktor.CafeApi
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DataRepository :KoinComponent {
    companion object {
        val tag = DataRepository::class.simpleName
    }

    private val ktorApi: CafeApi by inject()
    private val dbHelper: DatabaseHelper by inject()

    suspend fun fetchCafesFromNetwork(cityName: String) =ktorApi.fetchCafeFromApi(cityName)

    fun getCafeFromDb(): Flow<List<CAFE>> = dbHelper.selectAllItems()
    suspend fun insertCafeToDB(cafeResponse: List<CafeResponseItem>) {
        dbHelper.insertCafeList(cafeResponse)
    }
}