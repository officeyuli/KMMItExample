package com.officeyuli.kmmitexample.ktor.response

import com.officeyuli.kmmforitframwork.ktor.response.CafeResponseItem

data class DataState(
    val data: List<CafeResponseItem>? = null,
    val exception: String? = null,
    val empty: Boolean = false,
    val loading: Boolean = false
)
