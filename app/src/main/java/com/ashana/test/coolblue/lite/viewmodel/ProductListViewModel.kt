package com.ashana.test.coolblue.lite.viewmodel

import androidx.lifecycle.ViewModel
import com.ashana.test.coolblue.lite.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val randomString: String,
    private val repository: ProductRepository): ViewModel() {

    init {
        println("************* ${randomString} and ${repository} ******************")
    }
}