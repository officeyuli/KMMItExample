package com.officeyuli.kmmitexample.ktor

import com.officeyuli.kmmforitframwork.ktor.response.CafeResponseItem

interface CafeApi {
    suspend fun fetchCafeFromApi(city:String): List<CafeResponseItem>
}