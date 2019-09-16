package com.sample.android.kotlin.control

import org.junit.Test

class IfTest {

    @Test
    public fun basic() {
        val a = 1
        val b = 2
        var max = a
        if (a < b) max = b

        // 使用 else
        if (a > b) {
            max = a
        } else {
            max = b
        }

        //val c = if (condition) a else b
        val result = if (a > b) a else b
    }

    @Test
    fun range() {
        val x = 5
        val y = 9
        if (x in 1..8) {
            println("x 在区间内")
        }
    }
}