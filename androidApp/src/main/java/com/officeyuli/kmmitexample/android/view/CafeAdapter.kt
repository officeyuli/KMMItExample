package com.officeyuli.kmmitexample.android.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.officeyuli.kmmforitframwork.ktor.response.CafeResponseItem
import com.officeyuli.kmmitexample.android.R

class CafeAdapter : RecyclerView.Adapter<CafeViewHolder>() {
    var cafeList = listOf<CafeResponseItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cafe, parent, false)

        return CafeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        val cafe: CafeResponseItem = cafeList[position]
        holder.bind(cafe)
    }

    override fun getItemCount() = cafeList.size
}