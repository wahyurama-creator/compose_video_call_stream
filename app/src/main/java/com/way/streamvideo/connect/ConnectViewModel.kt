package com.way.streamvideo.connect

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.way.streamvideo.StreamApp

class ConnectViewModel(private val app: Application) : AndroidViewModel(app) {
    var state by mutableStateOf(ConnectState())
        private set

    fun onAction(action: ConnectAction) {
        when (action) {
            ConnectAction.OnConnectClicked -> {
                connectToRoom()
            }

            is ConnectAction.OnNameChanged -> {
                state = state.copy(name = action.name)
            }
        }
    }

    private fun connectToRoom() {
        state = state.copy(errorMessage = null)
        if (state.name.isBlank()) {
            state = state.copy(
                errorMessage = "The username can't blank"
            )
            return
        }

        // Initialize Video Client
        (app as StreamApp).initVideoClient(state.name)

        state = state.copy(isConnected = true)
    }
}