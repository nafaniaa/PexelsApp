package com.example.pexelsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pexelsapp.R

@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxWidth()){
        Image(
            painter = painterResource(R.drawable.loading_img),
            contentDescription = "loading",
            modifier = Modifier
                .size(200.dp)
        )

    }
}