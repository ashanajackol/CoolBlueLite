package com.ashana.test.coolblue.lite.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class SearchProductFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Test()
            }
        }
    }
}

@Composable
fun Test() {
    Text(
        text = "This is a sample compose",
        fontSize = 20.sp)
}

@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
    Test()
}