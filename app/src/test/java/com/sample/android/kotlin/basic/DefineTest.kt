package com.sample.android.kotlin.basic

import org.junit.Test
/*
1. 可变变量定义：var 关键字
2. 不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
 */
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