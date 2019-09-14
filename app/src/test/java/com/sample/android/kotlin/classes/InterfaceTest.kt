package com.sample.android.kotlin.classes

import org.junit.Test

class InterfaceTest {
    /*
    Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
     */

    /*
    接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
     */
    interface MyInterface {
        var name: String //name 属性, 抽象的

        fun bar()    // 未实现
        fun foo() {  //已实现
            // 可选的方法体
            println("foo")
        }
    }


    class Child : MyInterface {
        override var name: String = "runoob" //重写属性

        override fun bar() {
            // 方法体
            println("bar")
        }
    }

    @Test
    fun test1() {
        val c = Child()
        c.foo();
        c.bar();
    }

    /*
    函数重写 (歧义消除问题)
     */
    interface A {
        fun foo() {
            print("A")
        }   // 已实现

        fun bar()                  // 未实现，没有方法体，是抽象的
    }

    interface B {
        fun foo() {
            print("B")
        }   // 已实现

        fun bar() {
            print("bar")
        } // 已实现
    }

    class C : A {
        override fun bar() {
            print("bar")
        }   // 重写
    }

    class D : A, B {
        override fun foo() {
            super<A>.foo()
            super<B>.foo()
        }

        override fun bar() {
            super<B>.bar()
        }
    }


}