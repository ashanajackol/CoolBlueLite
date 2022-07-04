package com.ashana.test.coolblue.lite.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ashana.test.coolblue.lite.repository.DummyShoppingRepository
import com.ashana.test.coolblue.lite.helper.getOrAwaitValueTest
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

class ProductListViewModelTest {

    @get:Rule
    var taskExecuteRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ProductListViewModel

    @Before
    fun setup() {
        viewModel = ProductListViewModel(DummyShoppingRepository())
    }

    @Test
    fun `get product list by parsing empty query, returns error`() {
        viewModel.onSearchItemChanges("")
        val status = viewModel.validSearchItem.getOrAwaitValueTest()
        assertEquals(status, false)
    }
}