package com.sample.android.kotlin.classes

import org.junit.Test

/*
    classModifier: 类属性修饰符，标示类本身特性。

    abstract    // 抽象类
    final       // 类不可继承，默认属性
    enum        // 枚举类
    open        // 类可继承，类默认是final的
    annotation  // 注解类

    accessModifier: 访问权限修饰符

    private    // 仅在同一个文件中可见
    protected  // 同一个文件中或子类可见
    public     // 所有调用的地方都可见
    internal   // 同一个模块中可见


 */
class ObjTest {

    /**
     * 可继承类
     */
    open class Base {
        open fun f() {}
    }

    /*
       抽象类
        */
    abstract class Dericed : Base() {
        abstract override fun f()
    }

    private var bar: Int = 1
    var v = "property"

    /*
    内部类
    内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
     */
    inner class Inner {
        fun foo() = bar

        fun innerTest() {
            var o = this@ObjTest
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }

    /*
    匿名内部类
     */
    interface TestInterface {
        fun test()
    }

    fun setTest(test: TestInterface) {
        test.test()
    }

    @Test
    public fun testInner() {
        var obj: ObjTest = ObjTest()
        obj.setTest(object : TestInterface {
            override fun test() {
                println("对象表达式创建匿名内部类的实例")
            }
        })
    }

}