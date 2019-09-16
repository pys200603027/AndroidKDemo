package com.sample.android.kotlin.delegate

import org.junit.Test
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegateTest {

    /**
     * 类委托
     */

    // 创建接口
    interface Base {
        fun print()
    }

    // 实现此接口的被委托的类
    class BaseImpl(val x: Int) : Base {
        override fun print() {
            print(x)
        }
    }

    // 通过关键字 by 建立委托类
    class Derived(b: Base) : Base by b

    @Test
    public fun test1() {
        val b = BaseImpl(10)
        Derived(b).print()
    }

    /**
     * 属性委托:属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理。
     */
    /*
    格式:
    val/var <属性名>: <类型> by <表达式>
    var/val：属性类型(可变/只读)
    属性名：属性名称
    类型：属性的数据类型
    表达式：委托代理类

    要求：
    属性委托要求
    对于只读属性(也就是说val属性), 它的委托必须提供一个名为getValue()的函数。该函数接受以下参数：
    thisRef —— 必须与属性所有者类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型
    property —— 必须是类型 KProperty<*> 或其超类型
    这个函数必须返回与属性相同的类型（或其子类型）。
    对于一个值可变(mutable)属性(也就是说,var 属性),除 getValue()函数之外,它的委托还必须 另外再提供一个名为setValue()的函数, 这个函数接受以下参数:
    property —— 必须是类型 KProperty<*> 或其超类型
    new value —— 必须和属性同类型或者是它的超类型。
     */

    /**
     * 定义一个被委托的类
     */
    class Delegate() {
        operator fun getValue(thisRef: Example?, property: KProperty<*>): String {
            return "$thisRef, 这里委托了 ${property.name} 属性"
        }

        operator fun setValue(thisRef: Example?, property: KProperty<*>, value: String) {
            println("$thisRef 的 ${property.name} 属性赋值为 $value")
        }

    }

    class Example {
        var p: String by Delegate()
    }

    @Test
    public fun test2() {
        val e = Example()
        println(e.p)

        e.p = "Runoob"
        println(e.p)
    }

    /**
     * 延迟属性Lazy
     */
    val lazyValue: String by lazy {
        println("computed") // 第一次调用输出，第二次调用不执行
        "Hello"
    }

    @Test
    public fun test3() {
        println(lazyValue)
        println(lazyValue)
    }

    /**
     * 可观察属性 Observable
     */
    class User {
        var name: String by Delegates.observable("") { prop, old, new ->
            println("old:$old-> new :$new")
        }
    }

    @Test
    public fun test4() {
        val user = User()
        user.name = "first"
        user.name = "second"
    }

    /**
     * 把属性储存在映射中
     * 如果使用 var 属性，需要把 Map 换成 MutableMap
     */
    class Site(val map: Map<String, Any?>) {
        val name: String by map
        val url: String by map
    }

    @Test
    public fun test5() {
        val site = Site(mapOf("name" to "Test", "url" to "www.example.com"))
        println(site.name)
        println(site.url)
    }

    /**
     * Not Null
     */
    class Foo {
        var notNullBar: String by Delegates.notNull()
    }

    @Test
    public fun test6() {
        var foo = Foo()
        foo.notNullBar = "bar"
        println(foo.notNullBar)

    }

    /**
     * 局部委托属性
     *
     */
//    memoizedFoo 变量只会在第一次访问时计算。 如果 someCondition 失败，那么该变量根本不会计算。
//    fun example(computeFoo: () -> Foo) {
//        val memoizedFoo by lazy(computeFoo)
//
//        if (someCondition && memoizedFoo.isValid()) {
//            memoizedFoo.doSomething()
//        }
//    }


}