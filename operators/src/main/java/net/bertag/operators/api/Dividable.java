package net.bertag.operators.api;

/**
 * Contract for dividing one objects by another (`this / other`). Implementations should take care to
 * ensure that divide-by-zero possibilities are handled appropriately for their use case.
 *
 * @param <T> the type of implementation
 */
public interface Dividable<T> {

    /**
     * Divides this object by the other one, returning a result of the same type.
     *
     * @param other another object
     * @return the result; may be `this` or a new instance depending on the implementation
     */
    T div(T other);
}
