package net.bertag.operators

import net.bertag.operators.api.Addable
import net.bertag.operators.api.Dividable
import net.bertag.operators.api.Multipliable
import net.bertag.operators.api.Scalable
import net.bertag.operators.api.Subtractable
import java.util.function.BiFunction
import java.util.function.BinaryOperator

/**
 * Adds the two numbers together (`a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or returning null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Int?.plus(other: Int?): Int? = Ops.plus(this, other)

/**
 * Adds the two numbers together (`a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or returning null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Long?.plus(other: Long?): Long? = Ops.plus(this, other)

/**
 * Adds the two numbers together (`a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or returning null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Short?.plus(other: Short?): Short? = Ops.plus(this, other)

/**
 * Adds the two numbers together (`a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or returning null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Float?.plus(other: Float?): Float? = Ops.plus(this, other)

/**
 * Adds the two numbers together (`a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or returning null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Double?.plus(other: Double?): Double? = Ops.plus(this, other)

/**
 * Adds the two objects together (`a + b`) using [Addable.plus] if both inputs are non-null; if either input is null,
 * the other input is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the sum as described, or null if both inputs are null
 * @param <T> the type of objects being added
 */
operator fun <T : Addable<T>?> T?.plus(other: T?): T = Ops.plus(this, other)

/**
 * Subtracts the second number from the first (`a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Int?.minus(other: Int?): Int? = Ops.minus(this, other)

/**
 * Subtracts the second number from the first (`a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Long?.minus(other: Long?): Long? = Ops.minus(this, other)

/**
 * Subtracts the second number from the first (`a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Short?.minus(other: Short?): Short? = Ops.minus(this, other)

/**
 * Subtracts the second number from the first (`a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Float?.minus(other: Float?): Float? = Ops.minus(this, other)

/**
 * Subtracts the second number from the first (`a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Double?.minus(other: Double?): Double? = Ops.minus(this, other)

/**
 * Subtracts the second object from the first (`a - b`) using [Subtractable.minus] if both inputs are non-null; if
 * either input is null, the other input is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the difference as described, or null if both inputs are null
 * @param <T> the type of objects being subtracted
 */
operator fun <T : Subtractable<T>?> T?.minus(other: T?): T = Ops.minus(this, other)

/**
 * Multiplies the two numbers together (`a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Int?.times(other: Int?): Int? = Ops.times(this, other)

/**
 * Multiplies the two numbers together (`a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Long?.times(other: Long?): Long? = Ops.times(this, other)

/**
 * Multiplies the two numbers together (`a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Short?.times(other: Short?): Short? = Ops.times(this, other)

/**
 * Multiplies the two numbers together (`a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Float?.times(other: Float?): Float? = Ops.times(this, other)

/**
 * Multiplies the two numbers together (`a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Double?.times(other: Double?): Double? = Ops.times(this, other)

/**
 * Multiplies the two objects together (`a * b`) using [Multipliable.times] if both inputs are non-null; if either input
 * is null, the other input is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the product as described, or null if both inputs are null
 * @param <T> the type of objects being multiplied
 */
operator fun <T : Multipliable<T>?> T?.times(other: T?): T = Ops.times(this, other)

/**
 * Divides the second number from the first (`a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the quotient as described
 */
operator fun Int?.div(other: Int?): Int? = Ops.div(this, other)

/**
 * Divides the second number from the first (`a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the quotient as described
 */
operator fun Long?.div(other: Long?): Long? = Ops.div(this, other)

/**
 * Divides the second number from the first (`a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the quotient as described
 */
operator fun Short?.div(other: Short?): Short? = Ops.div(this, other)

/**
 * Divides the second number from the first (`a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the quotient as described
 */
operator fun Float?.div(other: Float?): Float? = Ops.div(this, other)

/**
 * Divides the second number from the first (`a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the quotient as described
 */
operator fun Double?.div(other: Double?): Double? = Ops.div(this, other)

/**
 * Divides the second object from the first (`a / b`) using [Dividable.div] if both inputs are non-null; if either input
 * is null, the other input is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the quotient as described, or null if both inputs are null
 * @param <T> the type of objects being divided
 */
operator fun <T : Dividable<T>?> T?.div(other: T?): T = Ops.div(this, other)

/**
 * Scales a number by a given factor if both are non-null.  If the receiver (Kotlin) — or first argument (Java) — is
 * null, null is returned; if the factor is null, no scaling will be applied.
 *
 * @receiver some nullable number
 * @param factor a nullable factor
 * @return the scaled result as described, rounded to the nearest integer
 */
fun Int?.scale(factor: Double?): Int? = Ops.scale(this, factor)

/**
 * Scales a number by a given factor if both are non-null.  If the receiver (Kotlin) — or first argument (Java) — is
 * null, null is returned; if the factor is null, no scaling will be applied.
 *
 * @receiver some nullable number
 * @param factor a nullable factor
 * @return the scaled result as described, rounded to the nearest (long) integer
 */
fun Long?.scale(factor: Double?): Long? = Ops.scale(this, factor)

/**
 * Scales a number by a given factor if both are non-null.  If the receiver (Kotlin) — or first argument (Java) — is
 * null, null is returned; if the factor is null, no scaling will be applied.
 *
 * @receiver some nullable number
 * @param factor a nullable factor
 * @return the scaled result as described, rounded to the nearest (short) integer
 */
fun Short?.scale(factor: Double?): Short? = Ops.scale(this, factor)

/**
 * Scales a number by a given factor if both are non-null.  If the receiver (Kotlin) — or first argument (Java) — is
 * null, null is returned; if the factor is null, no scaling will be applied.
 *
 * @receiver some nullable number
 * @param factor a nullable factor
 * @return the scaled result as described
 */
fun Float?.scale(factor: Double?): Float? = Ops.scale(this, factor)

/**
 * Scales a number by a given factor if both are non-null.  If the receiver (Kotlin) — or first argument (Java) — is
 * null, null is returned; if the factor is null, no scaling will be applied.
 *
 * @receiver some nullable number
 * @param factor a nullable factor
 * @return the scaled result as described
 */
fun Double?.scale(factor: Double?): Double? = Ops.scale(this, factor)

/**
 * Scales a [Scalable] object by a given factor if both are non-null.  If the receiver (Kotlin) — or first argument
 * (Java) — is null, null is returned; if the factor is null, no scaling will be applied.
 *
 * @receiver some nullable number
 * @param factor a nullable factor
 * @return the scaled result as described
 */
fun <T : Scalable<T>?> T?.scale(factor: Double?): T = Ops.scale(this, factor)

// We omit the `map` method because Kotlin already has built-in tooling for that functionality.

/**
 * Performs the given operation on the given inputs if they are both non-null.  If one input is null, the other input is
 * returned; if both are null, null is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @param opFunction the operation to perform
 * @return the result as described
 * @param <T> the type of objects being operated upon
 */
fun <T> T?.op(other: T?, opFunction: BinaryOperator<T>): T? = Ops.op(this, other, opFunction)

/**
 * Applies the given transformation to an object if the other input is non-null.  If the receiver (Kotlin) — or first
 * argument (Java) — is null, then null is returned; if `other` is null, then the receiver will be returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @param opFunction the operation to perform
 * @return the result as described
 * @param <T> the type of objects being operated upon
 */
fun <T, U> T?.apply(other: U?, opFunction: BiFunction<T, U, T>): T? = Ops.apply(this, other, opFunction)
