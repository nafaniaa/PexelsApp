package com.example.pexelsapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pexelsapp.ui.viewmodels.PhotosUiState

@Composable
fun HomeScreen(
    photosUiState: PhotosUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
){
    when(photosUiState){
        is PhotosUiState.Loading -> LoadingScreen(modifier = modifier)
        is PhotosUiState.Success -> PhotosGridScreen(
            photos = photosUiState.photoSearch,
            modifier = modifier
        )
        is PhotosUiState.Error -> NetworkStubScreen(retryAction)
    }

}