package com.ashana.test.coolblue.lite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashana.test.coolblue.lite.ui.theme.CoolBlueLiteTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoolBlueLiteTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    SplashView()
                }
            }
        }
    }
}

@Composable
fun SplashView() {
    Column() {

        Text(
            stringResource(R.string.splash_title),
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(
            stringResource(R.string.splash_sub_title)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoolBlueLiteTheme {
        SplashView()
    }
}