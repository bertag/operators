package net.bertag.operators.api

/**
 * Contract for subtracting one object from another (e.g.: `this - other`).
 *
 * @param <T> the type of implementation
 */
interface Subtractable<T> {
    operator fun minus(other: T): T
}