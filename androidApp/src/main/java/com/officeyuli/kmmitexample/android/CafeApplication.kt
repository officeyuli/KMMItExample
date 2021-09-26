package com.officeyuli.kmmitexample.android

import android.app.Application
import android.content.Context
import android.util.Log
import com.officeyuli.kmmitexample.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class CafeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            module{
                single<Context> {this@CafeApplication}
                viewModel { MainViewModel() }
                single{
                    { Log.e("CafeAndroidApp", "init Koin! " )}
                }
            }
        )
    }
}