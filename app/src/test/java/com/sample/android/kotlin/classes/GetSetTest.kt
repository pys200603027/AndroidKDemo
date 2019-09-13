package com.sample.android.kotlin.classes

import org.junit.Test


class GetSetTest {
    /*
    关于GetSet
    如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去类型，val不允许设置setter函数，因为它是只读的

    var <propertyName>[: <PropertyType>] [= <property_initializer>]
    [<getter>]
    [<setter>]

     */
//    val allByDefault:Int? // 错误: 需要一个初始化语句, 默认实现了 getter 和 setter 方法 (val 代表了final)

    var initialized = 1
    //    var simple:Int? // 类型为 Int ，默认实现 getter ，但必须在构造函数中初始化
    var inferred = 1 // 类型为 Int 类型,默认实现 getter

    //field关键字声明,field 关键词只能用于属性的访问器
    var lastName: String = "Ye"
        get() = field.toUpperCase()
        set

    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) field = value
            else field = 1
        }

    var height: Float = 145.4F
        private set

    @Test
    public fun test() {
        var getset: GetSetTest = GetSetTest()

        getset.lastName = "Yang"
        println("lastName:${getset.lastName}")

        getset.no = 9
        println("no:${getset.no}")

        getset.no = 20
        println("no:${getset.no}")
    }

    //关于延迟加载
    lateinit var subject: GetSetTest

}