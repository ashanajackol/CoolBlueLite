package com.ashana.test.coolblue.lite.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.repository.IProductRepository
import com.ashana.test.coolblue.lite.repository.ProductRepository
import com.ashana.test.coolblue.lite.util.ValidatorUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: IProductRepository): ViewModel() {

    val products: MutableState<List<Product>> = mutableStateOf(listOf())
    val textSearchItem = mutableStateOf("")
    val doneLoading = mutableStateOf(false)

    private var _validSearchItem = MutableLiveData<Boolean>()
    val validSearchItem: LiveData<Boolean> = _validSearchItem

    init {
        //SearchProduct(textSearchItem.value)
    }

    fun SearchProduct(searchItem: String){
        doneLoading.value = false
        viewModelScope.launch {
            val response = repository.searchProduct(
                query = searchItem,
                page = 1
            )
            doneLoading.value = true
            products.value = response
        }
    }

    fun onSearchItemChanges(searchItem: String){
        textSearchItem.value = searchItem
        _validSearchItem.value = ValidatorUtils.ValidateSearchInput(searchItem)
    }
}