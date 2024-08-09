package com.example.pexelsapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pexelsapp.custom.CustomNetworkStatusView
import com.example.pexelsapp.presentation.adapters.PhotoAdapter
import com.example.pexelsapp.ui.viewModels.PhotoViewModel
import com.example.pexelsapp.util.NetworkObserver
import com.example.pexelsapp.util.NetworkStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: PhotoViewModel by viewModels()
    private val networkObserver by lazy { NetworkObserver(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setupNetworkObserver()
        setupRecyclerView()
        setupThemeToggleButton()

        lifecycleScope.launch {
            viewModel.allPhotos.collect { photos ->
                (findViewById<RecyclerView>(R.id.recycler_view).adapter as? PhotoAdapter)?.submitList(photos)
            }
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PhotoAdapter()
    }

    private fun setupNetworkObserver() {
        val networkStatusView = findViewById<CustomNetworkStatusView>(R.id.networkStatusView)
        networkObserver.startObserving()

        lifecycleScope.launch {
            networkObserver.networkStatus.collect { status ->
                when (status) {
                    NetworkStatus.Available -> networkStatusView.hideStatus()
                    NetworkStatus.Weak -> networkStatusView.showStatus("Weak Internet Connection", isCritical = false)
                    NetworkStatus.Unavailable -> networkStatusView.showStatus("No Internet Connection", isCritical = true)
                }
            }
        }
    }

    private fun setupThemeToggleButton() {
        findViewById<Button>(R.id.themeToggleButton).setOnClickListener {
            toggleTheme()
        }
    }

    private fun toggleTheme() {
        val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            android.content.res.Configuration.UI_MODE_NIGHT_YES -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            android.content.res.Configuration.UI_MODE_NIGHT_NO -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkObserver.stopObserving()
    }
}