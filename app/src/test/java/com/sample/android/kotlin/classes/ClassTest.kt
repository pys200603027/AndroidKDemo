package com.sample.android.kotlin.classes

import android.content.Context
import android.util.AttributeSet
import android.view.View
import org.junit.Test

class ClassTest {

    /*
    Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后
     */
    class Person constructor(firstName: String) {}

    /*
    省略
     */
    class Person2(firstName: String) {}

    class Contact(val id: Int, var email: String)

    /**
     * 声明一个范型类
     */
    class MutableStack<E>(vararg items: E) {
        private val elements = items.toMutableList()

        fun push(element: E) = elements.add(element)

        fun peek(): E = elements.last()

        fun pop(): E = elements.removeAt(elements.size - 1)

        fun isEmpty() = elements.isEmpty()

        fun size() = elements.size

        override fun toString() = "MutableStack(${elements.joinToString()})"
    }


    class Customer(name: String) {
        /**
         * 直接在声明属性中使用
         */
        val customerKey = name.toUpperCase()
    }

    /**
     * init关键字 (通过声明的顺序执行)
     *
     */
    class InitOrderDemo(name: String) {
        val firstProperty = "First property:$name".also(::println)

        init {
            println("First initializer block that prints ${name}")
        }

        val secondProperty = "Second property:${name.length}".also(::println)

        init {
            println("Second initializer block that prints ${name.length}")
        }

        init {
            println("Three initializer block that prints ${name.length}")
        }
    }

    /**
     * 关于主构造器/ 次构造器
     */
    class Humen(val name: String) {
        init {
            println("这里会先执行,init block 仍属主构造器的一部分")
        }

        /**
         * 次构造器需要调用主构造器
         */
        constructor() : this("name") {
            println("init 执行完之后")
        }
    }

    /**
     * 构造函数私有化
     */
    class DontCreateMe private constructor() {

    }

    @Test
    public fun test1() {
        var c = InitOrderDemo("Y")
    }

    /**
     * 关于继承的时候，构造函数的写法
     */
    class MyView : View {
        constructor(ctx: Context) : super(ctx)

        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    }

    /**
     * 继承的时候，构造函数的写法
     */
    open class Base(p: Int)

    /**
     * 写法一
     */
    class Derived(p: Int) : Base(p)

    /**
     * 写法二
     */
    class De : Base {
        constructor(p: Int) : super(p)
    }
}