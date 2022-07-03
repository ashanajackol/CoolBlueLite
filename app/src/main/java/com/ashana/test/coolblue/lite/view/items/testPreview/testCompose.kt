package com.ashana.test.coolblue.lite.view.items.testPreview

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.R

@Composable
fun productItemTest(){
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row() {
            //product image
                Image(painter = painterResource(id = R.drawable.ic_empty_cart_small),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp),
                    contentScale = ContentScale.Crop)


            //title, price, delivery option
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)) {
                    //title
                    Text(
                        text = "Sample title",
                        modifier = Modifier.wrapContentWidth(Alignment.Start),
                        maxLines = 2,
                        style = MaterialTheme.typography.h5)
                    //price
                    Text(
                        text = "USD.456",
                        modifier = Modifier.wrapContentWidth(Alignment.Start),
                        maxLines = 1,
                        style = MaterialTheme.typography.h5)
                    //delivery option
                    Text(
                        text = "Fast delivery- true",
                        modifier = Modifier.wrapContentWidth(Alignment.Start),
                        maxLines = 1,
                        style = MaterialTheme.typography.h5)
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun preview(){
    productItemTest()
}
