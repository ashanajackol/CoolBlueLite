package com.ashana.test.coolblue.lite.util

object ValidatorUtils {

    //validate the search input of 'ProductListFragment'
    fun ValidateSearchInput(input: String): Boolean {
        if (input.isEmpty())
            return false
        return true
    }
}