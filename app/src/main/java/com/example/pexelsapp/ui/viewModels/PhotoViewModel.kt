package com.example.pexelsapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pexelsapp.domain.models.PhotoModel
import com.example.pexelsapp.domain.usecases.DeletePhotoUseCase
import com.example.pexelsapp.domain.usecases.GetAllPhotosUseCase
import com.example.pexelsapp.domain.usecases.GetPhotoByIdUseCase
import com.example.pexelsapp.domain.usecases.GetPhotosUseCase
import com.example.pexelsapp.domain.usecases.InsertPhotoUseCase
import com.example.pexelsapp.domain.usecases.UpdatePhotoUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoViewModel @Inject constructor(
    private val insertPhotoUseCase: InsertPhotoUseCase,
    private val updatePhotoUseCase: UpdatePhotoUseCase,
    private val deletePhotoUseCase: DeletePhotoUseCase,
    private val getPhotoByIdUseCase: GetPhotoByIdUseCase,
    private val getPhotosUseCase: GetPhotosUseCase,
    private val getAllPhotosUseCase: GetAllPhotosUseCase
) : ViewModel() {

    private val _allPhotos = MutableStateFlow<List<PhotoModel>>(emptyList())
    val allPhotos: Flow<List<PhotoModel>> = _allPhotos

    init {
        loadAllPhotos()
    }

    fun loadAllPhotos() {
        viewModelScope.launch {
            getAllPhotosUseCase.invoke().collect { photos ->
                _allPhotos.value = photos
            }
        }
    }

    fun getPhotoById(id: Int): LiveData<PhotoModel?> {
        return getPhotoByIdUseCase.invoke(id).asLiveData()
    }

    fun insertPhoto(photo: PhotoModel) {
        viewModelScope.launch {
            insertPhotoUseCase.invoke(photo)
        }
    }

    fun updatePhoto(photo: PhotoModel) {
        viewModelScope.launch {
            updatePhotoUseCase.invoke(photo)
        }
    }

    fun deletePhoto(photo: PhotoModel) {
        viewModelScope.launch {
            deletePhotoUseCase.invoke(photo)
        }
    }

    fun loadPhotos(query: String, perPage: Int = DEFAULT_PAGE_SIZE, page: Int = 1) {
        viewModelScope.launch {
            getPhotosUseCase(query, perPage, page)
        }
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 15
    }
}