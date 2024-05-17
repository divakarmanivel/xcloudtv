package com.divakar.xcloudtv.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.divakar.xcloudtv.LocalNavController
import com.divakar.xcloudtv.R

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(
    onThemeColorModeClick: () -> Unit,
    onLocaleChangeClick: () -> Unit
) {
    val navHostController = LocalNavController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 75.dp),
            fontFamily = FontFamily.SansSerif,
            text = "XCloud TV",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 60.sp,
            style = MaterialTheme.typography.labelLarge.copy(textMotion = TextMotion.Animated)
        )
        Button(
            modifier = Modifier
                .width(120.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { navHostController.navigate("game") }
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_gaming),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Play",
                style = MaterialTheme.typography.labelLarge.copy(textMotion = TextMotion.Animated)
            )
        }
        Button(
            modifier = Modifier
                .width(120.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { onThemeColorModeClick() }
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_palette),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Themes",
                style = MaterialTheme.typography.labelLarge.copy(textMotion = TextMotion.Animated)
            )
        }
        Button(
            modifier = Modifier
                .width(120.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { onLocaleChangeClick() }
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_translate),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Locales",
                style = MaterialTheme.typography.labelLarge.copy(textMotion = TextMotion.Animated)
            )
        }
    }
}