package com.example.pexelsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pexelsapp.R

@Composable
fun NetworkStubScreen(retryAction: () -> Unit, modifier: Modifier = Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Image(
            painter = painterResource(R.drawable.no_network_icon) ,
            contentDescription = stringResource(R.string.no_network),
            modifier = Modifier
                .width(41.6.dp)
                .height(33.3.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Button(onClick =  retryAction,
            modifier = Modifier
                .background(Color.White)
        ) {
            Text(
                text = stringResource(R.string.try_again),
                textAlign = TextAlign.Center,
                fontSize = 6.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = mulishFamily,
                color = Color(R.color.AppRed)
            )
        }
    }
}

