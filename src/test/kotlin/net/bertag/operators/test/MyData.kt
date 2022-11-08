package net.bertag.operators.test

import net.bertag.operators.api.Addable
import net.bertag.operators.api.Dividable
import net.bertag.operators.api.Multipliable
import net.bertag.operators.api.Subtractable
import net.bertag.operators.plus
import net.bertag.operators.minus
import net.bertag.operators.times
import net.bertag.operators.div

data class MyData(
    val someKey: String,
    val someInt: Int?,
    val someDouble: Double?
): Addable<MyData>, Subtractable<MyData>, Multipliable<MyData>, Dividable<MyData> {

    override operator fun plus(other: MyData): MyData {
        return copy(
            someInt = someInt + other.someInt,
            someDouble = someDouble + other.someDouble)
    }

    override operator fun minus(other: MyData): MyData {
        return copy(
            someInt = someInt - other.someInt,
            someDouble = someDouble - other.someDouble)
    }

    override operator fun times(other: MyData): MyData {
        return copy(
            someInt = someInt * other.someInt,
            someDouble = someDouble * other.someDouble)
    }

    override operator fun div(other: MyData): MyData {
        return copy(
            someInt = someInt / other.someInt,
            someDouble = someDouble / other.someDouble)
    }
}