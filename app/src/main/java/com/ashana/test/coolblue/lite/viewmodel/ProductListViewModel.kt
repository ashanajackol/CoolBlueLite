package com.ashana.test.coolblue.lite.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val randomString: String,
    private val repository: ProductRepository): ViewModel() {

    val products: MutableState<List<Product>> = mutableStateOf(listOf())
    val textSearchItem = mutableStateOf("")

    init {
        SearchProduct(textSearchItem.value)
    }

    fun SearchProduct(searchItem: String){
        viewModelScope.launch {
            val response = repository.searchProduct(
                query = searchItem,
                page = 1
            )
            products.value = response
        }
    }

    fun onSearchItemChanges(searchItem: String){
        textSearchItem.value = searchItem
    }
}