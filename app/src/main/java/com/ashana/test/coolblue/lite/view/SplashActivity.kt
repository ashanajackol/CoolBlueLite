package com.ashana.test.coolblue.lite.view

import com.ashana.test.coolblue.lite.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashana.test.coolblue.lite.ui.theme.CoolBlueLiteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashView()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },2000)

    }
}

@Composable
fun SplashView() {

    val title_1 = stringResource(id = R.string.splash_title_part_1)
    val title_2 = stringResource(id = R.string.splash_title_part_2)

    Surface(
        color = Color.Black,
        modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White,
                                                fontWeight = FontWeight.Light)){
                        append(title_1)
                    }
                    withStyle(style = SpanStyle(color = Color.White,
                        fontWeight = FontWeight.Bold)){
                        append(title_2)
                    }
                },
                fontSize = 32.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoolBlueLiteTheme {
        SplashView()
    }
}