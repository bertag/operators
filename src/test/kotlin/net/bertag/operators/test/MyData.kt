package net.bertag.operators.test

import net.bertag.operators.api.Addable
import net.bertag.operators.api.Subtractable
import net.bertag.operators.api.Multipliable
import net.bertag.operators.api.Dividable
import net.bertag.operators.api.Scalable
import net.bertag.operators.div
import net.bertag.operators.minus
import net.bertag.operators.plus
import net.bertag.operators.scale
import net.bertag.operators.times
import kotlin.math.roundToInt
import kotlin.math.roundToLong

data class MyData(
    val someKey: String,
    val someInt: Int?,
    val someLong: Long?,
    val someShort: Short?,
    val someFloat: Float?,
    val someDouble: Double?,
): Addable<MyData>, Subtractable<MyData>, Multipliable<MyData>, Dividable<MyData>, Scalable<MyData> {

    constructor(someKey: String, templateValue: Double?) : this(
        someKey = someKey,
        someInt = templateValue?.roundToInt(),
        someLong = templateValue?.roundToLong(),
        someShort = templateValue?.roundToInt()?.toShort(),
        someFloat = templateValue?.toFloat(),
        someDouble = templateValue)

    override operator fun plus(other: MyData): MyData {
        return copy(
            someInt = someInt + other.someInt,
            someLong = someLong + other.someLong,
            someShort = someShort + other.someShort,
            someFloat = someFloat + other.someFloat,
            someDouble = someDouble + other.someDouble)
    }

    override operator fun minus(other: MyData): MyData {
        return copy(
            someInt = someInt - other.someInt,
            someLong = someLong - other.someLong,
            someShort = someShort - other.someShort,
            someFloat = someFloat - other.someFloat,
            someDouble = someDouble - other.someDouble)
    }

    override operator fun times(other: MyData): MyData {
        return copy(
            someInt = someInt * other.someInt,
            someLong = someLong * other.someLong,
            someShort = someShort * other.someShort,
            someFloat = someFloat * other.someFloat,
            someDouble = someDouble * other.someDouble)
    }

    override operator fun div(other: MyData): MyData {
        return copy(
            someInt = (someInt?.toDouble() / other.someInt?.toDouble())?.roundToInt(),
            someLong = (someLong?.toDouble() / other.someLong?.toDouble())?.roundToLong(),
            someShort = (someShort?.toDouble() / other.someShort?.toDouble())?.roundToInt()?.toShort(),
            someFloat = (someFloat / other.someFloat),
            someDouble = (someDouble / other.someDouble))
    }

    override fun scale(factor: Double): MyData {
        return copy(
            someInt = someInt.scale(factor),
            someLong = someLong.scale(factor),
            someShort = someShort.scale(factor),
            someFloat = someFloat.scale(factor),
            someDouble = someDouble.scale(factor))
    }
}