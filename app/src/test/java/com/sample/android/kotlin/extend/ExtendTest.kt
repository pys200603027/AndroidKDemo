package com.sample.android.kotlin.extend

import org.junit.Test

/*
扩展的作用域

通常扩展函数或属性定义在顶级包下
package foo
fun Example.goo(){}

使用
import foo.Example.goo // 导入所有名为 goo 的扩展
 */
class ExtendTest {

    class User(var name: String)

    /*
    扩展函数可以在已有类中添加[新的方法]，不会对原类做修改，扩展函数定义形式：

    fun receiverType.functionName(params){
        body
    }
     */
    fun User.print() {
        print("用户名:$name")
    }

    @Test
    public fun test1() {
        var user = User("Runoob")
        user.print()
    }

    /**
     * 扩展kotlin现有类
     */
    fun MutableList<Int>.swp(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    @Test
    public fun test2() {
        var l = mutableListOf(1, 2, 3)
        l.swp(0, 2)
        println(l.toString())
    }

    /*
    扩展函数是静态解析的
     */
    open class C

    class D : C()

    fun C.foo() = "c" // 扩展函数 foo
    fun D.foo() = "d"

    /*
    这里声明的时C,静态解析就是调用了c.foo()
     */
    fun printFoo(c: C) {
        println(c.foo())  // 类型是 C 类
    }

    @Test
    public fun test3() {
        var c = D();
        printFoo(c)
    }

    /*
    若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
     */
    class C1 {
        fun foo() {
            println("成员函数")
        }
    }

    fun C1.foo() {
        println("扩展函数")
    }

    @Test
    public fun test4() {
        var c = C1()
        c.foo()
    }

    /*
    扩展一个空对象
     */
    fun Any?.toString(): String {
        if (this == null) {
            return "null"
        }
        return toString()
    }

    @Test
    public fun test5() {
        var l = null
        println(l.toString())
    }

    /*
    扩展属性
     */
    val <T> List<T>.lastIndex: Int
        get() = size - 1


    /*
    半生对象的扩展
     */
    class MyClass {
        companion object {}  // 将被称为 "Companion"
    }

    fun MyClass.Companion.foo() {
        println("伴随对象的扩展函数")
    }

    //注意这里用val
    val MyClass.Companion.no: Int
        get() = 10

    @Test
    public fun test6() {
        println("no:${MyClass.no}")
        MyClass.foo()
    }

    /**
     *扩展声明为它类成员 （在一个类内部你可以为另一个类声明扩展。）
     */

    class D2 {
        fun bar() {
            println("D bar")
        }
    }

    class C2 {

        fun bar() {
            println("C bar")
        }  // 与 D 类 的 bar 同名

        fun baz() {
            println("C baz")
        }

        /**
         *该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先
         */
        fun D2.foo2() {
            bar()         // 调用 D.bar()，扩展接收者优先
            this@C2.bar()  // 调用 C.bar()
        }

        fun D2.foo() {
            bar()
            baz()
        }

        fun caller(d: D2) {
            d.foo()
            d.foo2()
        }
    }

    @Test
    public fun test7() {
        val c = C2()
        val d = D2()
        c.caller(d)
    }

    /**
     * 扩展的继承情况
     *  可以声明为 open , 而且可以在子类中覆盖
     */

    open class D3 {
    }

    class D4 : D3() {
    }

    open class C4 {
        //这里扩展了D3
        open fun D3.foo() {
            println("D.foo in C")
        }

        //这里扩展D4
        open fun D4.foo() {
            println("D1.foo in C")
        }

        fun caller(d: D3) {
            d.foo()   // 调用扩展函数
        }
    }

    class C5 : C4() {
        override fun D3.foo() {
            println("D3.foo is over")
        }

        override fun D4.foo() {
            println("D4.foo is over")
        }
    }

    @Test
    public fun test8() {
        C4().caller(D3())
        C5().caller(D3())
        C4().caller(D4())
    }


}