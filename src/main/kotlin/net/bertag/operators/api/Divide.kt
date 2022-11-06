package net.bertag.operators.api

/**
 * Contract for dividing one objects by another (e.g.: `this / other`). Implementations should take care to
 * ensure that divide-by-zero possibilities are handled appropriately for their use case.
 *
 * @param <T> the type of implementation
 */
interface Divide<T> {
    operator fun div(other: T): T
}