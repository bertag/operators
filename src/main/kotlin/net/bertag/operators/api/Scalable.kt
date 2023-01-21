package net.bertag.operators.api

/**
 * Contract for scaling an object by a given factor.
 *
 * @param <T> the type of implementation
 */
interface Scalable<T> {

    /**
     * Multiplies this object by a constant factor, returning a result of the same type.
     *
     * @param factor the scale factor
     * @return the result; may be `this` or a new instance depending on the implementation
     */
    fun scale(factor: Double): T
}