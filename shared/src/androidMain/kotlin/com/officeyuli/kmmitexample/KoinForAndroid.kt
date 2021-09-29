package com.officeyuli.kmmitexample

import com.russhwolf.settings.AndroidSettings
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import com.russhwolf.settings.Settings

actual val platformModule: Module = module {
    single<SqlDriver>{
        AndroidSqliteDriver(CafeDB.Schema,get(),"CafeDb")
    }
    single<Settings>{
        AndroidSettings(get())
    }
}