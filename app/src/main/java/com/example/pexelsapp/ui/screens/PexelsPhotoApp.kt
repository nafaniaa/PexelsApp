package com.example.pexelsapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pexelsapp.R
import com.example.pexelsapp.ui.viewmodels.PhotosViewModels


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PexelsPhotoApp(
    modifier: Modifier = Modifier
) {
    val photosViewModels: PhotosViewModels =
        viewModel(factory = PhotosViewModels.Factory)

   Scaffold(
       modifier = modifier.fillMaxSize(),
       topBar = {
           TopAppBar (
               title = {
                   Text(text = stringResource(id = R.string.app_name))
               }
           )
       }
   ) {
       Surface (
           modifier = Modifier
               .fillMaxSize()
               .padding(it),
           color = Color.White
       ){
           HomeScreen(
               photosUiState =photosViewModels.photosUiState ,
               retryAction = { photosViewModels::getPhotos })

       }

   }
}
