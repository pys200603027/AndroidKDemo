package com.sample.android.kotlin.basic

import org.junit.Test

class NullTest {

    @Test
    fun Test() {
        /**
         * 类型后面加?表示可为空
         */
        val age: String? = "23"

        /**
         * 抛出空指针异常
         */
        val ages = age!!.toInt()

        /**
         * 不做处理返回 null
         */
        val ages1 = age?.toInt()

        /**
         * age为空返回-1
         */
        val ages2 = age?.toInt() ?: -1

    }

    /**
     * 我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)
     */
    fun getStringLenght(obj: Any): Int? {

        if (obj is String) {
            return obj.length
        }
        return null
    }

    /**
     * 另外一种写法
     */
    fun getStringLenght2(obj: Any): Int? {
        if (obj !is String) {
            return null
        }
        return obj.length
    }

    /**
     * 写法3
     */
    fun getStringLenght3(obj: Any): Int? {
        // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
        if (obj is String && obj.length > 0)
            return obj.length
        return null
    }
}