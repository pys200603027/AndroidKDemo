package com.sample.android.kotlin.classes

import android.content.Context
import android.view.View
import org.junit.Test

/*
Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类：
Any 默认提供了三个函数：

equals()

hashCode()

toString()
 */
class DerivedTest {

    /*
    基础继承
     */
    open class Base(p: Int)

    class Derived(p: Int) : Base(p)

    open class Person(var name: String, var age: Int)
    class Student(name: String, age: Int, var no: String, var scroe: Int) : Person(name, age) {}

    /*
    子类没有主构造函数
     */
    class MyView : View {
        constructor(ct: Context) : super(ct) {}
    }

    @Test
    public fun Test1() {
        var s = Student("Ronoob", 18, "s123", 89)
        println("name:${s.name}")
        println("age:${s.age}")
    }

    /*
    重写
     */
    open class P {
        open fun study() {
            println("1")
        }
    }

    class Stu : P() {
        override fun study() {
            println("2")
        }
    }

    /*
    重写歧义消除
     */
    open class A {
        open fun f() {
            print("A")
        }

        fun a() {
            print("a")
        }
    }

    interface B {
        fun f() {
            print("B")
        }

        fun b() {
            print("b")
        }
    }

    class C : A(), B {
        override fun f() {
            super<A>.f()
            super<B>.f()
        }
    }

    @Test
    public fun test2() {
        var c = C()
        c.f()
    }

    /*
    属性重写
     */
    open class Foo {
        open val x: Int = 0
            get() {
                field
                return 0
            }
    }

    class Bar1 : Foo() {
        override var x: Int = 1
    }

}