package com.ashana.test.coolblue.lite.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashana.test.coolblue.lite.domain.model.Products
import com.ashana.test.coolblue.lite.repository.IProductRepository
import com.ashana.test.coolblue.lite.util.ValidatorUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val PageSize = 24

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: IProductRepository): ViewModel() {

    val products: MutableState<List<Products>> = mutableStateOf(listOf())
    val textSearchItem = mutableStateOf("")
    val doneLoading = mutableStateOf(false)
    val page = mutableStateOf(1)
    var scrollPosition = 0

    private var _validSearchItem = MutableLiveData<Boolean>()
    val validSearchItem: LiveData<Boolean> = _validSearchItem

    init {
        SearchProduct(textSearchItem.value)
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

    fun goNextPage(){
        viewModelScope.launch {
            if ( (scrollPosition+1) > (page.value* PageSize) ) {
                doneLoading.value = false
                incrementPageCount()
                if (page.value > 1) {
                    val newSearchResult = repository.searchProduct(
                        query = textSearchItem.value,
                        page = page.value
                    )
                    addProductsToList(newSearchResult)
                }
                doneLoading.value = true
            }
        }
    }

    private fun incrementPageCount() {
        page.value = page.value + 1;
    }

    fun onChangePageScrollingPosition(position: Int) {
        scrollPosition = position
        println("********** index is **** ${position}")
    }

    private fun addProductsToList(products: List<Products>){
        val currentList = ArrayList(this.products.value)
        currentList.addAll(products)
        this.products.value = currentList
    }

    fun onSearchItemChanges(searchItem: String){
        textSearchItem.value = searchItem
        _validSearchItem.value = ValidatorUtils.ValidateSearchInput(searchItem)
    }
}