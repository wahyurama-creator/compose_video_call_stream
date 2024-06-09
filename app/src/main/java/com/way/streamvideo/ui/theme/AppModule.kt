package com.way.streamvideo.ui.theme

import com.way.streamvideo.StreamApp
import com.way.streamvideo.connect.ConnectViewModel
import com.way.streamvideo.video.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    factory {
        val app = androidContext().applicationContext as StreamApp
        app.client
    }

    viewModelOf(::ConnectViewModel)
    viewModelOf(::VideoCallViewModel)

}