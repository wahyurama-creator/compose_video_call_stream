package com.way.streamvideo.video

import io.getstream.video.android.core.Call

data class VideoCallState(
    val call: Call,
    val callState: CallState? = null,
    val error: String? = null,
)

enum class CallState {
    JOINING,
    ACTIVE,
    ENDED,
}
