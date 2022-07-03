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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.R
import kotlin.math.min

@Composable
fun productItemTest(){
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 12.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            //product image
                Image(painter = painterResource(id = R.drawable.ic_empty_cart_small),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .widthIn(min = 50.dp)
                        .padding(start = 8.dp),
                    contentScale = ContentScale.Crop)


            //title, price, delivery option
                Column(modifier = Modifier
                    .padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 12.dp),
                verticalArrangement = Arrangement.Center) {
                    //title
                    Text(
                        text = "Sample title asdasdas asdasd asdasda",
                        modifier = Modifier.wrapContentWidth(Alignment.Start),
                        maxLines = 2,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h5,
                        fontSize = 18.sp)
                    //price
                    Text(
                        text = "USD.456",
                        color = Color.Gray,
                        modifier = Modifier.wrapContentWidth(Alignment.Start),
                        maxLines = 1,
                        style = MaterialTheme.typography.h6,
                        fontSize = 15.sp)
                    //delivery option
                    Text(
                        text = "Fast delivery- true",
                        color = Color.Gray,
                        modifier = Modifier.wrapContentWidth(Alignment.Start)
                            .padding(top = 12.dp),
                        maxLines = 1,
                        style = MaterialTheme.typography.h6,
                        fontSize = 15.sp)
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun preview(){
    productItemTest()
}
