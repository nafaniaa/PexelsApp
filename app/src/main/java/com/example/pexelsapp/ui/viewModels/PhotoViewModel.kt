package com.example.pexelsapp.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.local.entities.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoDao: PhotoDao
) : ViewModel() {

    val photos = MutableLiveData<List<Photo>>()

    fun insertPhoto(photo: Photo) {
        viewModelScope.launch {
            photoDao.insert(photo)
        }
    }

    fun loadPhotos() {
        viewModelScope.launch {
            photos.value = photoDao.getAllPhotos()
        }
    }
}