package com.example.pexelsapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.domain.models.PhotoModel
import com.example.pexelsapp.domain.usecases.DeletePhotoUseCase
import com.example.pexelsapp.domain.usecases.GetAllPhotosUseCase
import com.example.pexelsapp.domain.usecases.GetPhotoByIdUseCase
import com.example.pexelsapp.domain.usecases.InsertPhotoUseCase
import com.example.pexelsapp.domain.usecases.UpdatePhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    // The use cases are injected into the ViewModel
    private val insertPhotoUseCase: InsertPhotoUseCase,
    private val updatePhotoUseCase: UpdatePhotoUseCase,
    private val deletePhotoUseCase: DeletePhotoUseCase,
    private val getAllPhotosUseCase: GetAllPhotosUseCase,
    private val getPhotoByIdUseCase: GetPhotoByIdUseCase
) : ViewModel() {
    // Expose a read-only LiveData of all photos
    val allPhotos: LiveData<List<PhotoModel>> = getAllPhotosUseCase.invoke()

    // Get a LiveData of a photo by its ID
    fun getPhotoById(id: Int): LiveData<PhotoModel> {
        return getPhotoByIdUseCase.invoke(id)
    }

    // Insert a new photo
    fun insert(photo: PhotoModel) {
        // Use the viewModelScope to launch a coroutine
        viewModelScope.launch {
            // Call the InsertPhotoUseCase to insert the photo
            insertPhotoUseCase.invoke(photo)
        }
    }

    // Update an existing photo
    fun update(photo: PhotoModel) {
        // Use the viewModelScope to launch a coroutine
        viewModelScope.launch {
            // Call the UpdatePhotoUseCase to update the photo
            updatePhotoUseCase.invoke(photo)
        }
    }

    // Delete a photo
    fun delete(photo: PhotoModel) {
        // Use the viewModelScope to launch a coroutine
        viewModelScope.launch {
            // Call the DeletePhotoUseCase to delete the photo
            deletePhotoUseCase.invoke(photo)
        }
    }
}