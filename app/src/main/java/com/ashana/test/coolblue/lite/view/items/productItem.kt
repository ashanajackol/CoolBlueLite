package com.ashana.test.coolblue.lite.view.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashana.test.coolblue.lite.R
import com.ashana.test.coolblue.lite.domain.model.Products
import com.ashana.test.coolblue.lite.util.imageUtils

@Composable
fun productItem(
    product: Products,
    onClickAction: () -> Unit
){
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clickable(onClick = onClickAction)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            //product image
            product.productImage?.let { url ->
                val image = imageUtils(url = url, defaultImage = R.drawable.ic_no_preview).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 5.dp)
                            .fillMaxHeight()
                            .width(60.dp),
                        contentScale = ContentScale.Inside)
                }
            }

            //title, price, delivery option
            product.productName?.let { title ->
                Column(modifier = Modifier
                    .weight(3f)
                    .padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 8.dp),
                    verticalArrangement = Arrangement.Center)
                {

                    //title
                    Text(
                        text = title,
                        color = Color.Black,
                        modifier = Modifier.wrapContentWidth(Alignment.Start),
                        maxLines = 2,
                        style = MaterialTheme.typography.h5,
                        fontSize = 17.sp)

                    //price
                    Text(
                        text = "USD.${product.salesPriceIncVat.toString()}",
                        color = Color.Gray,
                        modifier = Modifier.wrapContentWidth(Alignment.Start),
                        maxLines = 1,
                        style = MaterialTheme.typography.h6,
                        fontSize = 14.sp)

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
                                    text = product.reviewInformation?.reviewSummary?.reviewAverage.toString(),
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    style = MaterialTheme.typography.h6)
                            }
                        }
                        Text(
                            modifier = Modifier.padding(start = 10.dp),
                            text = "${product.reviewInformation?.reviewSummary?.reviewCount.toString()} reviews",
                            color = Color.Gray,
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.h6)
                    }

                    //delivery option
                    Text(
                        text = "Fast delivery- ${product.nextDayDelivery.toString()}",
                        color = Color.Gray,
                        modifier = Modifier
                            .wrapContentWidth(Alignment.Start)
                            .padding(top = 12.dp),
                        maxLines = 1,
                        style = MaterialTheme.typography.h6,
                        fontSize = 14.sp)

                }

                //next icon
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
    }
