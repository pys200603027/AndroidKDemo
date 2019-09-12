package com.sample.android.kotlin.basic

import org.junit.Test

class StringTest {

    /*
    $ 表示一个变量名或者变量值
    $varName 表示变量值
    ${varName.fun()} 表示变量的方法返回值
     */
    @Test
    fun Test() {
        var a = 1
        val s1 = "a is $a"

        println(s1)

        a = 2
        var s2 = "${s1.replace("is", "was")},but now is $a"

        println(s2)
    }
}