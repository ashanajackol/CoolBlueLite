package com.ashana.test.coolblue.lite.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
                LazyColumn() {
                    itemsIndexed(
                        items = products
                    ){
                        index, item ->
                        productItem(product = item) {}

                    }
                    }
                }
            }
        }
    }