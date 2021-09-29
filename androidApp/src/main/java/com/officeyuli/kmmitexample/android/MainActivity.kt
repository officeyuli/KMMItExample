package com.officeyuli.kmmitexample.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.officeyuli.kmmitexample.Greeting
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.officeyuli.kmmitexample.android.view.CafeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private val adapter : CafeAdapter by lazy { CafeAdapter() }
    private lateinit var cafeRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchCafeList("taipei")
        viewModel.fetchCafeFromDB()
        viewModel.cafeListLiveData.observe(this, Observer {
            adapter.cafeList = it
            adapter.notifyDataSetChanged()
        })

        cafeRecyclerView = findViewById(R.id.rv_cafeList)
        cafeRecyclerView.adapter = adapter
        cafeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cafeRecyclerView.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        )
    }
}
