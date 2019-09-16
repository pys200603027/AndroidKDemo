package com.sample.android.kotlin.loop

import org.junit.Test

/*
for 循环可以对任何提供迭代器（iterator）的对象进行遍历，语法如下:
for (item in collection) print(item)
 */
class LoopTest {

    @Test
    public fun testArrayLoop() {
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
        }

        /**
         * 这里index用于索引
         */
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

    }

    @Test
    public fun testWhile() {
        println("----while 使用-----")
        var x = 5
        while (x > 0) {
            println(x--)
        }

        println("----do...while 使用-----")
        var y = 5
        do {
            println(y--)
        } while (y > 0)
    }

    /*
    return。默认从最直接包围它的函数或者匿名函数返回。
    break。终止最直接包围它的循环。
    continue。继续下一次最直接包围它的循环。
     */
    @Test
    public fun testLoopControl() {
        for (i in 1..10) {
            if (i == 3) continue  // i 为 3 时跳过当前循环，继续下一次循环
            println(i)
            if (i > 5) break   // i 为 6 时 跳出循环
        }
    }
}