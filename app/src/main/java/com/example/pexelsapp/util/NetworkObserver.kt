package com.example.pexelsapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

class NetworkObserver(private val context: Context) : LiveData<Boolean>() {
    // Get the ConnectivityManager from the provided Context
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    // Define a NetworkCallback that updates the LiveData with the network connectivity status
    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        // When a network becomes available, post true to the LiveData
        override fun onAvailable(network: Network) {
            postValue(true)
        }

        // When a network is lost, post false to the LiveData
        override fun onLost(network: Network) {
            postValue(false)
        }

        // When network capabilities change, post the internet connectivity status to the LiveData
        override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
            postValue(networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET))
        }
    }

    // When the LiveData becomes active, register the NetworkCallback with the ConnectivityManager
    override fun onActive() {
        super.onActive()
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

    // When the LiveData becomes inactive, unregister the NetworkCallback
    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}