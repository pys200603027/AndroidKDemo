package com.sample.android.kotlin.classes

import kotlin.math.exp

/**
 * 密封类
 * 每个枚举常量只存在一个实例，而密封类 的一个子类可以有可包含状态的多个实例
 */
class SealedTest {

    sealed class Expr {
        data class Const(val number: Double) : Expr()
        data class Sum(val e1: Expr, val e2: Expr) : Expr()
        object NotAtNumber : Expr()

        fun eval(expr: Expr): Double = when (expr) {
            is Const -> expr.number
            is Sum -> eval(expr.e1) + eval(expr.e2)
            NotAtNumber -> Double.NaN
        }
    }
}