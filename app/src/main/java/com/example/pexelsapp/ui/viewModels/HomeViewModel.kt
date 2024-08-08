package com.example.pexelsapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelsapp.domain.models.PhotoModel
import com.example.pexelsapp.domain.usecases.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {
    private val _photos = MutableStateFlow<List<PhotoModel>>(emptyList())
    val photos: StateFlow<List<PhotoModel>> get() = _photos.asStateFlow()

    init {
        getPhotos("")
    }

     fun getPhotos(query: String, perPage: Int = HomeViewModel.DEFAULT_PAGE_SIZE, page: Int = 1) {
        viewModelScope.launch {
            val result = getPhotosUseCase(query, perPage, page)
            _photos.value = result
        }
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 15
    }
}