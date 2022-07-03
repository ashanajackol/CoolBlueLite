package com.ashana.test.coolblue.lite.view

import com.ashana.test.coolblue.lite.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.ashana.test.coolblue.lite.network.ProductService
import com.ashana.test.coolblue.lite.ui.theme.CoolBlueLiteTheme
import com.ashana.test.coolblue.lite.viewmodel.ProductListViewModel
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

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
    val surfaceColor = "#1923e3"
    Surface(
        color = Color(surfaceColor.toColorInt()),
        modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            Text(
                stringResource(R.string.splash_title),
                fontSize = 40.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                stringResource(R.string.splash_sub_title),
                fontSize = 60.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
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