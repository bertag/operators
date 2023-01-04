package net.bertag.operators.api

/**
 * Contract for scaling an object by a given factor.
 *
 * @param <T> the type of implementation
 */
interface Scalable<T> {
    fun scale(factor: Double): T
}