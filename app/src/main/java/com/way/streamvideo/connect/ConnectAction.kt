package com.way.streamvideo.connect

interface ConnectAction {
    data class OnNameChanged(val name: String) : ConnectAction
    data object OnConnectClicked : ConnectAction
}