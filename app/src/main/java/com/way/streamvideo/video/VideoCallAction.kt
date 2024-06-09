package com.way.streamvideo.video

sealed interface VideoCallAction {
    data object OnDisconnectClick: VideoCallAction
    data object  JoinCallClick: VideoCallAction

}