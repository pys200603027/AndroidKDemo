package com.sample.android.kotlin.datatype

import org.junit.Test

class DataTypeTest {
    /*
        十进制：123
        长整型以大写的 L 结尾：123L
        16 进制以 0x 开头：0x0F
        2 进制以 0b 开头：0b00001011
        注意：8进制不支持
        Kotlin 同时也支持传统符号表示的浮点数值：

        Doubles 默认写法: 123.5, 123.5e10
        Floats 使用 f 或者 F 后缀：123.5f
     */
    //下划线使数字常量更易读
    val oneMillion = 1_000_000

    val creditCardNumber = 1234_5678_9012_3456L

    val socialSecurityNumber = 999_99_9999L

    val hexBytes = 0xFF_EC_DE_5E

    val bytes = 0b11010010_01101001_10010100_10010010

    /**
     * 在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。(有问题)
     */
    @Test
    public fun testCompare() {

        val a: Int = 10;
        println(a === a)

        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
        println(boxedA == anotherBoxedA) // true，值相等
    }

    /*
        toByte(): Byte
        toShort(): Short
        toInt(): Int
        toLong(): Long
        toFloat(): Float
        toDouble(): Double
        toChar(): Char
     */
    @Test
    public fun testToXXX() {
        val b: Byte = 1 // OK, 字面值是静态检测的
//        val i: Int = b // 错误
        val i: Int = b.toInt() // OK

        val l = 1L + 3 // Long + Int => Long
    }

    /*
    char 无法和int转换，需要''
     */
    @Test
    public fun testChar() {
        val c: Char = '9'
        println(c.toInt() - '0'.toInt())
    }

    /*
    注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）
     */
    @Test
    public fun testArray() {
        val a = arrayOf(1, 2, 3)
        val b = Array(3, { i -> (i * 2) })

        println(a[0])
        println(b[1])

        /*
        除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样
         */
        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]
        println(x[0])
    }

    /*
    Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串
    String 可以通过 trimMargin() 方法来删除多余的空白
     */
    @Test
    public fun testString() {
        val text = """
                    多行字符串
                    多行字符串
                    """
        println(text)   // 输出有一些前置空格
    }

    @Test
    public fun testStringTemp() {

        val i = 10
        val s = "i = $i" // 求值结果为 "i = 10"
        println(s)
    }

    @Test
    public fun testStringTemp2() {
        val s = "runoob"
        val str = "$s.length is ${s.length}" // 求值结果为 "runoob.length is 6"
        println(str)
    }

    /*
    转义字符
     */
    @Test
    public fun testStringOrigin() {
        val price = """
            ${'$'}9.99
        """.trimIndent()
        println(price)
    }

}