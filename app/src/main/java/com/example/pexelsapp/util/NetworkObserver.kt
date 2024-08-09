package com.example.pexelsapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NetworkObserver(private val context: Context) {
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val _networkStatus = MutableStateFlow(NetworkStatus.Available)
    val networkStatus: StateFlow<NetworkStatus> get() = _networkStatus

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            _networkStatus.value = NetworkStatus.Available
        }

        override fun onLost(network: Network) {
            _networkStatus.value = NetworkStatus.Unavailable
        }

        override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
            when {
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) -> {
                    if (networkCapabilities.linkDownstreamBandwidthKbps < 150) { // arbitrary weak connection threshold
                        _networkStatus.value = NetworkStatus.Weak
                    } else {
                        _networkStatus.value = NetworkStatus.Available
                    }
                }
                else -> _networkStatus.value = NetworkStatus.Unavailable
            }
        }
    }

    fun startObserving() {
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

    fun stopObserving() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}

enum class NetworkStatus {
    Available, Weak, Unavailable
}