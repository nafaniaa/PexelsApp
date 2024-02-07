package com.example.pexelsapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pexelsapp.R

@Composable
fun EmptyBookmarksScreenTextAndButton(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = stringResource(R.string.you_have_not_saved_anything_yet),
            fontFamily = mulishFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
            )

        Spacer(modifier = Modifier.height(4.dp))

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .background(Color.White)
        ) {
            Text(
                text = stringResource(R.string.explore),
                fontFamily = mulishFamily,
                fontWeight = FontWeight.Normal,
                color = Color(R.color.AppRed),
                textAlign = TextAlign.Center
            )

        }
    }
}