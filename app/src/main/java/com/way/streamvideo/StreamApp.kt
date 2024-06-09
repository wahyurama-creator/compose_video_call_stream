package com.way.streamvideo

import android.app.Application
import com.way.streamvideo.ui.theme.appModule
import io.getstream.video.android.core.StreamVideo
import io.getstream.video.android.core.StreamVideoBuilder
import io.getstream.video.android.model.User
import io.getstream.video.android.model.UserType
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StreamApp : Application() {

    private var currentName: String? = null
    var client: StreamVideo? = null

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StreamApp)
            modules(appModule)
        }
    }

    fun initVideoClient(username: String) {
        if (client == null || username != currentName) {
            StreamVideo.removeClient()
            currentName = username

            client = StreamVideoBuilder(
                context = applicationContext,
                apiKey = "88f5mezsmv2j",
                user = User(
                    id = username,
                    name = username,
                    type = UserType.Guest
                )
            ).build()
        }
    }
}