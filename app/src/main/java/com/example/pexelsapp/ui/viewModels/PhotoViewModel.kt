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
    private val insertPhotoUseCase: InsertPhotoUseCase,
    private val updatePhotoUseCase: UpdatePhotoUseCase,
    private val deletePhotoUseCase: DeletePhotoUseCase,
    private val getAllPhotosUseCase: GetAllPhotosUseCase,
    private val getPhotoByIdUseCase: GetPhotoByIdUseCase
) : ViewModel() {

    val allPhotos: LiveData<List<PhotoModel>> = getAllPhotosUseCase.invoke()

    fun getPhotoById(id: Int): LiveData<PhotoModel> {
        return getPhotoByIdUseCase.invoke(id)
    }

    fun insert(photo: PhotoModel) {
        viewModelScope.launch {
            insertPhotoUseCase.invoke(photo)
        }
    }

    fun update(photo: PhotoModel) {
        viewModelScope.launch {
            updatePhotoUseCase.invoke(photo)
        }
    }

    fun delete(photo: PhotoModel) {
        viewModelScope.launch {
            deletePhotoUseCase.invoke(photo)
        }
    }
}