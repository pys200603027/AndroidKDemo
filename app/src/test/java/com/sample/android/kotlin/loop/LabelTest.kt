package com.sample.android.kotlin.loop

import org.junit.Test

class LabelTest {

    @Test
    fun testReturn() {
        val ints = arrayListOf<Int>(0, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        ints.forEach lit@{
            //            if (it == 0) return@lit //类似continue
            if (it == 0) return
            print(it)
        }
    }

    /*
    通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名
     */
    @Test
    fun testReturn2() {
        val ints = arrayListOf<Int>(0, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        ints.forEach {
            if (it == 0) return@forEach
            print(it)
        }
    }
}