package com.ashana.test.coolblue.lite

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class CoroutineRule(private val dispatcher: CoroutineDispatcher = StandardTestDispatcher()):
TestWatcher(), TestCoroutineScope by TestCoroutineScope(dispatcher){

    override fun starting(description: Description) {
        super.finished(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        kotlinx.coroutines.test.runTest {  }
        Dispatchers.resetMain()
    }
}