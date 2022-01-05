package com.nadia.frenzy.ui

//Hilt is a dependency injection library
/*Timber is a logging utility class. we usually end up writing lot of log statements and before the release,
we’ll cleanup the log statements by removing them manually (even though logs can be disabled in release build).
This tedious process can be avoided easily by using Timber. */

import android.app.Application
import com.nadia.frenzy.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}