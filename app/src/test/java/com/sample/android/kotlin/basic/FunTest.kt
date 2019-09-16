package com.sample.android.kotlin.basic

import org.junit.Test

class FunTest {

    /**
     * 函数定义使用关键字 fun，参数格式为：参数 : 类型
     */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 表达式作为函数体，返回类型自动推断：
     */
    fun sum1(a: Int, b: Int) = a + b

    /**
     * public 方法则必须明确写出返回类型
     */
    public fun sum2(a: Int, b: Int): Int = a + b

    /**
     * 函数的变长参数可以用 vararg 关键字进行标识
     */
    fun vars(vararg v: Int) {
        for (vt in v) {
            print(vt)
        }
    }

    /**
     * lambda表达式使用实例
     */
    @Test
    fun test() {
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        println(sumLambda(1, 2))
    }

    /**
     * 区间操作
     */
    @Test
    fun testRange() {

        for (i in 1..4) print(i)
        println()
        /**
         * // 什么都不输出
         */
        for (i in 4..1) print(i)
        println()
        for (i in 1..4 step 2) print(i)
        println()
    }
}