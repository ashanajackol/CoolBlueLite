package com.ashana.test.coolblue.lite.view.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.R

@Composable
fun productItem(
    product: Product,
    onClickAction: () -> Unit
){
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClickAction)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            //product image
            product.productImage?.let { url ->
                Image(painter = painterResource(id = R.drawable.ic_empty_cart_small),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .widthIn(min = 50.dp)
                        .padding(start = 8.dp),
                contentScale = ContentScale.Crop)
            }

            //title, price, delivery option
            product.productName?.let { title ->
                Column(modifier = Modifier
                    .fillMaxHeight()
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
                    //delivery option
                    Text(
                        text = "Fast delivery- .${product.nextDayDelivery.toString()}",
                        color = Color.Gray,
                        modifier = Modifier.wrapContentWidth(Alignment.Start)
                            .padding(top = 12.dp),
                        maxLines = 1,
                        style = MaterialTheme.typography.h6,
                        fontSize = 14.sp)

                }
            }
            }
        }
    }
