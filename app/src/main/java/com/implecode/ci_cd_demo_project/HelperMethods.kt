package com.implecode.ci_cd_demo_project

object HelperMethods {

    fun calculateSum(number1: String, number2: String): String {
        return number1.toInt().plus(number2.toInt()).toString()
    }
}