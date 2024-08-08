package com.example.pexelsapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _isDataLoaded = MutableStateFlow(false)
    val isDataLoaded: StateFlow<Boolean> get() = _isDataLoaded

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            delay(3000) // Simulate loading time
            _isDataLoaded.value = true
        }
    }
}