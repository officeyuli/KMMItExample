package com.officeyuli.kmmitexample

import org.koin.core.KoinApplication
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults
import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.Settings
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

fun initKoinIos(userDefaults: NSUserDefaults,doOnStartup: () ->Unit): KoinApplication = initKoin(
    module{
        single<Settings>{AppleSettings(userDefaults)}
        single { doOnStartup }
    }
)

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier) { parametersOf(parameter) }
}

fun Koin.get(objCClass: ObjCClass, parameter: Any): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, null) { parametersOf(parameter) }
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?): Any {
    val kClazz = getOriginalKotlinClass(objCClass)!!
    return get(kClazz, qualifier, null)
}