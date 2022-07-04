package com.ashana.test.coolblue.lite.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ashana.test.coolblue.lite.R
import com.ashana.test.coolblue.lite.util.showToast
import com.ashana.test.coolblue.lite.view.items.ProgressItem
import com.ashana.test.coolblue.lite.view.items.productItem
import com.ashana.test.coolblue.lite.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment: Fragment() {

    val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {

                val products = viewModel.products.value
                val searchItem = viewModel.textSearchItem
                val doneLoading = viewModel.doneLoading
                val validSearchItem = viewModel.validSearchItem

                val titleShopping_1 = resources.getString(R.string.fragment_list_appbar_title_part_1)
                var titleShopping_2 = resources.getString(R.string.fragment_list_appbar_title_part_2)

                Surface(
                        elevation = 8.dp,
                        modifier = Modifier.fillMaxSize(),
                        color = Color.White) {

                    //main container
                    Column() {
                        // app bar impl
                        TopAppBar(title = { Text(
                                buildAnnotatedString {
                                     withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                                         append(titleShopping_1)
                                     }
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(titleShopping_2)
                                    }
                                },
                                color = Color.White,
                                fontSize = 18.sp,
                                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) },
                                backgroundColor = Color.Black)

                    //search text and card list container
                    Column {

                            val context = LocalContext.current
                            val focusManager = LocalFocusManager.current

                            //search field
                            OutlinedTextField (
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Gray,
                                cursorColor = Color.Black
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            value = searchItem.value,
                            onValueChange = {
                                viewModel.onSearchItemChanges(it)
                            },
                            label = {
                                Image(painter = painterResource(id = android.R.drawable.ic_menu_search),
                                    contentDescription = null)
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = {
                                focusManager.moveFocus(FocusDirection.Down)
                                if (validSearchItem.value == true)
                                    viewModel.SearchProduct(searchItem.value)
                                else
                                    showToast(context = context)
                            }),
                            singleLine = true)

                        Spacer(modifier = Modifier.padding(5.dp))

                        //card view and progress indicator holder
                        Box(modifier = Modifier.fillMaxWidth()) {
                            LazyColumn() {
                                itemsIndexed(
                                    items = products
                                ) { index, item ->
                                    productItem(product = item, onClickAction = {})
                                }
                            }
                            ProgressItem(isShow = !doneLoading.value)
                        }
                    }
                }
                }
            }
        }
    }
}