package com.sample.android.kotlin.control

import org.junit.Test

class WhenTest {

    /**
     * when 类似其他语言的 switch 操作符
     */
    @Test
    public fun test1() {
        val x = 10
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> {
                // 注意这个块
                print("x 不是 1 ，也不是 2")
            }
        }
    }

    /*
    range
     */
    @Test
    public fun test2() {
        val x = 100
        when (x) {
            in 1..10 -> print("x is in the range")
//            in validNumbers -> print("x is valid")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }
    }

    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    @Test
    public fun test3() {
        println(hasPrefix("prefix"))
    }
}