package com.ashana.test.coolblue.lite.view.items.testPreview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashana.test.coolblue.lite.R

@Composable
fun productItemTest(){
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 12.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            //product image
                Image(painter = painterResource(id = R.drawable.ic_no_preview),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(60.dp),
                    contentScale = ContentScale.Inside)


            //title, price, delivery option
                Column(modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 12.dp)) {
                    //title
                    Text(
                        text = "Sample title asdasdas sdfsd dsfsd",
                        modifier = Modifier
                            .wrapContentWidth(Alignment.Start)
                            .wrapContentHeight(Alignment.Top),
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
                    //review
                    Row(Modifier.padding(top = 10.dp)) {
                            Box(
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(20.dp)
                                    .background(Color.Black,
                                        shape = RoundedCornerShape(50.dp))){
                                Row (verticalAlignment = Alignment.CenterVertically,
                                     horizontalArrangement = Arrangement.Center,
                                     modifier = Modifier.fillMaxWidth()) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_rating),
                                        contentDescription = null,
                                        modifier = Modifier.padding(2.dp))
                                    Text(
                                        text = "4.7",
                                        color = Color.White,
                                        fontSize = 12.sp,
                                        style = MaterialTheme.typography.h6)
                                }
                            }
                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = "34 reviews",
                            color = Color.Gray,
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.h6)
                    }
                    //delivery option
                    Text(
                        text = "24h delivery- true",
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(top = 10.dp),
                        maxLines = 1,
                        style = MaterialTheme.typography.h6,
                        fontSize = 15.sp)
                }

            Image(
                painter = painterResource(id = R.drawable.ic_angle_right),
                contentDescription = null,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp),
                contentScale = ContentScale.Inside)
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun preview(){
    productItemTest()
}
