package com.implecode.ci_cd_demo_project

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HelperMethodsTest {

    @Test
    fun `calculate sum returns correct sum`(){
        val sum = HelperMethods.calculateSum("10","10")
        assert(sum == "20")
    }
}