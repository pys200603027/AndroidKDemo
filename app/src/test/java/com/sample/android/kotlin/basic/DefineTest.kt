package com.sample.android.kotlin.basic

import org.junit.Test

class DefineTest {

    /**
     * 基础变量声明
     */
    @Test
    fun test() {

        val a: Int = 1;
        /**
         * 系统自动推断变量类型为Int
         */
        val b = 1;

        /**
         * 如果不在声明时初始化则必须提供变量类型
         */
        val c: Int
        c = 1;

        var x = 5
        x += 1
    }
}