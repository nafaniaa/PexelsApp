package com.example.pexelsapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pexelsapp.R
import com.example.pexelsapp.data.PexelsPhoto


@Composable
fun PhotosGridScreen(
    photos: List<PexelsPhoto>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp)
    ){
        itemsIndexed(photos){_, photo ->
            PhotosCard(pexelsPhoto = photo)
        }
    }
}

@Composable
fun PhotosCard(
    pexelsPhoto: PexelsPhoto,
    modifier: Modifier = Modifier
){
    Card (
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(7.dp))
    ){
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(pexelsPhoto.url?.replace("http", "https"))
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.image_placeholder_light),
            placeholder = painterResource(R.drawable.image_placeholder_light),
            contentDescription = "pexel_photo",
            contentScale = ContentScale.Crop
        )

    }
}