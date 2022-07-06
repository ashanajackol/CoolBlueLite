package com.ashana.test.coolblue.lite.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

@Composable
fun imageUtils(url: String,
               @DrawableRes defaultImage: Int): MutableState<Bitmap?> {

    //load the default image
    val bitmap: MutableState<Bitmap?> = mutableStateOf(null)
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
               bitmap.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                //not needed
            }

        })

    //load the original from server
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                //not needed
            }

        })
    return bitmap
}

@Composable
fun progressIndicator(isShow: Boolean){
    if(isShow) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp),
            horizontalArrangement = Arrangement.Center) {
            CircularProgressIndicator(
                color = Color.Black
            )
        }
    }
}

fun showToast(context: Context, title: String){
    Toast.makeText(context,title,Toast.LENGTH_SHORT).show()
}