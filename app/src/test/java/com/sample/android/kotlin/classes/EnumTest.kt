package com.sample.android.kotlin.classes

import org.junit.Test

class EnumTest {
    /**
     * 普通定义
     */
    enum class Color {
        RED, BLACk, BLUE, GREEN, WHITE
    }

    /**
     * 可以被初始化
     */
    enum class Color2(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF)
    }

    /*
    使用枚举常量
     */
    @Test
    public fun test1() {
        //遍历所有
        for (value in Color2.values()) {
            print(value)
        }
        println()

        val valueOf = Color2.valueOf("RED")
        println(valueOf)
    }

    /**
     * 默认名称为枚举字符名，值从0开始。若需要指定值，则可以使用其构造函数
     */
    enum class Shape(value: Int) {
        ovel(100),
        rectangle(200)
    }

    /**
     * 枚举还支持以声明自己的匿名类及相应的方法、以及覆盖基类的方法
     */
    enum class ProtocolState {
        WAITING {
            override fun signal() = TALKING
        },

        TALKING {
            override fun signal() = WAITING
        };

        abstract fun signal(): ProtocolState
    }


}