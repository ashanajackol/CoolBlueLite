package com.ashana.test.coolblue.lite

import com.ashana.test.coolblue.lite.util.ValidatorUtils
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ProductListFragmentTest {

    //test, user enter value and press search -> true
    @Test
    fun inputIsValid() {
        val searchText = "Apple"
        assertTrue("Search input entered", ValidatorUtils.ValidateSearchInput(searchText))
    }

    //test, user enter nothing and press search -> false
    @Test
    fun inputIsInValid() {
        val searchText = ""
        assertFalse("Search input not entered", ValidatorUtils.ValidateSearchInput(searchText))
    }
}