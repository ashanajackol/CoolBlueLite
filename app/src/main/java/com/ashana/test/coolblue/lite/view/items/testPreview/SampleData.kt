package com.ashana.test.coolblue.lite.view.items.testPreview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.ashana.test.coolblue.lite.domain.model.Product

//this class is for testing composable functions which required objects as parameters
class SampleData() : PreviewParameterProvider<Product>  {

    override val values: Sequence<Product>
        get() = sequenceOf(Product(listOf(),2,true,123,"","Test title",425.00,45,9.5))
}