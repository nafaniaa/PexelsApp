package com.example.pexelsapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelsapp.domain.models.PhotoModel
import com.example.pexelsapp.domain.usecases.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    // The GetPhotosUseCase is injected into the ViewModel
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {
    // A private mutable LiveData for storing the list of photos
    private val _photos = MutableLiveData<List<PhotoModel>>()
    // A public read-only LiveData for exposing the list of photos
    val photos: LiveData<List<PhotoModel>> get() = _photos

    // This block is executed when the ViewModel is created
    init {
        // Fetch the photos from the use case
        fetchPhotos()
    }

    // This method fetches the photos from the use case
    private fun fetchPhotos() {
        // Use the viewModelScope to launch a coroutine
        viewModelScope.launch {
            // Call the GetPhotosUseCase and get the result
            val result = getPhotosUseCase()
            // Post the result to the _photos MutableLiveData
            _photos.postValue(result)
        }
    }
}