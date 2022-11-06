@file:JvmName("Ops")
package net.bertag.operators

import net.bertag.operators.api.Add
import net.bertag.operators.api.Divide
import net.bertag.operators.api.Multiply
import net.bertag.operators.api.Subtract
import java.util.function.BinaryOperator

/**
 * Adds the two numbers together (e.g.: `a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Int?.plus(other: Int?) = if (allNull(this, other)) null else (this ?: 0) + (other ?: 0)

/**
 * Adds the two numbers together (e.g.: `a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Long?.plus(other: Long?) = if (allNull(this, other)) null else (this ?: 0L) + (other ?: 0L)

/**
 * Adds the two numbers together (e.g.: `a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Short?.plus(other: Short?) = if (allNull(this, other)) null else ((this ?: 0) + (other ?: 0)).toShort()

/**
 * Adds the two numbers together (e.g.: `a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Float?.plus(other: Float?) = if (allNull(this, other)) null else (this ?: 0F) + (other ?: 0F)

/**
 * Adds the two numbers together (e.g.: `a + b`) if at least one input is non-null (substituting 0 for the
 * other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the sum as described
 */
operator fun Double?.plus(other: Double?) = if (allNull(this, other)) null else (this ?: 0.0) + (other ?: 0.0)

/**
 * Adds the two objects together (e.g.: `a * b`) using [Add.plus] if both inputs are non-null.
 * If one input is null, the other input is returned; if both are null, null is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the sum as described
 * @param <T> the type of objects being subtracted
 */
operator fun <T : Add<T>> T?.plus(other: T?) = this.op(other) { x, y -> x + y }

/**
 * Subtracts the second number from the first (e.g.: `a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Int?.minus(other: Int?) = if (allNull(this, other)) null else (this ?: 0) - (other ?: 0)

/**
 * Subtracts the second number from the first (e.g.: `a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Long?.minus(other: Long?) = if (allNull(this, other)) null else (this ?: 0L) - (other ?: 0L)

/**
 * Subtracts the second number from the first (e.g.: `a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Short?.minus(other: Short?) = if (allNull(this, other)) null else ((this ?: 0) - (other ?: 0)).toShort()

/**
 * Subtracts the second number from the first (e.g.: `a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Float?.minus(other: Float?) = if (allNull(this, other)) null else (this ?: 0F) - (other ?: 0F)

/**
 * Subtracts the second number from the first (e.g.: `a - b`) if at least one input is non-null (substituting
 * 0 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Double?.minus(other: Double?) = if (allNull(this, other)) null else (this ?: 0.0) - (other ?: 0.0)

/**
 * Subtracts the second object from the first (e.g.: `a - b`) using [Subtract.minus] if both
 * inputs are non-null.  If one input is null, the other input is returned; if both are null, null is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the difference as described
 * @param <T> the type of objects being subtracted
</T> */
operator fun <T : Subtract<T>> T?.minus(other: T?) = this.op(other) { x, y -> x - y }

/**
 * Multiplies the two numbers together (e.g.: `a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Int?.times(other: Int?) = if (allNull(this, other)) null else (this ?: 1) * (other ?: 1)

/**
 * Multiplies the two numbers together (e.g.: `a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Long?.times(other: Long?) = if (allNull(this, other)) null else (this ?: 1L) * (other ?: 1L)

/**
 * Multiplies the two numbers together (e.g.: `a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Short?.times(other: Short?) = if (allNull(this, other)) null else ((this ?: 1) * (other ?: 1)).toShort()

/**
 * Multiplies the two numbers together (e.g.: `a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Float?.times(other: Float?) = if (allNull(this, other)) null else (this ?: 1F) * (other ?: 1F)

/**
 * Multiplies the two numbers together (e.g.: `a * b`) if at least one input is non-null (substituting 1 for
 * the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the product as described
 */
operator fun Double?.times(other: Double?) = if (allNull(this, other)) null else (this ?: 1.0) * (other ?: 1.0)

/**
 * Multiplies the two objects together (e.g.: `a * b`) using [Multiply.times] if both inputs are
 * non-null.  If one input is null, the other input is returned; if both are null, null is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the product as described
 * @param <T> the type of objects being multiplied
 */
operator fun <T : Multiply<T>> T?.times(other: T?) = this.op(other) { x, y -> x * y }

/**
 * Divides the second number from the first (e.g.: `a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Int?.div(other: Int?) = if (allNull(this, other)) null else (this ?: 1) / (other ?: 1)

/**
 * Divides the second number from the first (e.g.: `a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Long?.div(other: Long?) = if (allNull(this, other)) null else (this ?: 1L) / (other ?: 1L)

/**
 * Divides the second number from the first (e.g.: `a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Short?.div(other: Short?) = if (allNull(this, other)) null else ((this ?: 1) / (other ?: 1)).toShort()

/**
 * Divides the second number from the first (e.g.: `a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Float?.div(other: Float?) = if (allNull(this, other)) null else (this ?: 1F) / (other ?: 1F)

/**
 * Divides the second number from the first (e.g.: `a / b`) if at least one input is non-null (substituting
 * 1 for the other input if it is null), or null if both inputs are null.
 *
 * @receiver some nullable number
 * @param other another nullable number
 * @return the difference as described
 */
operator fun Double?.div(other: Double?) = if (allNull(this, other)) null else (this ?: 1.0) / (other ?: 1.0)

/**
 * Divides the second object from the first (e.g.: `a / b`) using [Divide.div] if both inputs
 * are non-null.  If one input is null, the other input is returned; if both are null, null is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @return the product as described
 * @param <T> the type of objects being divided
 */
operator fun <T : Divide<T>> T?.div(other: T?) = op(other) { x, y -> x / y }

/**
 * Performs the given operation on the given inputs if they are both non-null.  If one input is null, the other
 * input is returned; if both are null, null is returned.
 *
 * @receiver some nullable object
 * @param other another nullable object
 * @param opFunction the operation to perform
 * @return the result as described
 * @param <T> the type of objects being operated upon
 */
fun <T> T?.op(other: T?, opFunction: BinaryOperator<T>): T? {
    return if (allNull(this, other)) null
    else if (this == null) other
    else if (other == null) this
    else opFunction.apply(this, other)
}

/**
 * Determines if both objects are null.
 *
 * @param a some nullable object
 * @param b another nullable object
 * @return true if both objects are null; false if either or both is non-null
 */
private fun allNull(a: Any?, b: Any?) = (a == null && b == null)
