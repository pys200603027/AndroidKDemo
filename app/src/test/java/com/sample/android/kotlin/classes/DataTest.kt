package com.sample.android.kotlin.classes

import org.junit.Test

/*
 * Kotlin 可以创建一个只包含数据的类，关键字为 data：
 *
 * 编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：
    equals() / hashCode()
    toString() 格式如 "User(name=John, age=42)"
    componentN() functions 对应于属性，按声明顺序排列
    copy() 函数

*  为了保证生成代码的一致性以及有意义，数据类需要满足以下条件：
    主构造函数至少包含一个参数。
    所有的主构造函数的参数必须标识为val 或者 var ;
    数据类不可以声明为 abstract, open, sealed 或者 inner;
    数据类不能继承其他类 (但是可以实现接口)。

 */
class DataTest {

    data class User(val name: String, val age: Int)

    @Test
    public fun test1() {
        val jack = User(name = "Jack", age = 1)
        val copy = jack.copy(age = 2)
        println(jack)
        println(copy)
    }

    /**
     * 组件函数允许数据类在解构声明中使用
     */
    @Test
    public fun test2() {
        val jane = User("Jane", 35)
        val (name, age) = jane
        println("$name, $age years of age") // prints "Jane, 35 years of age"
    }
}