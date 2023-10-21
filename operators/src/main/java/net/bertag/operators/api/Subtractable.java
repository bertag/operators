package net.bertag.operators.api;

/**
 * Contract for subtracting one object from another (`this - other`).
 *
 * @param <T> the type of implementation
 */
public interface Subtractable<T> {

    /**
     * Subtracts the other object from this one, returning a result of the same type.
     *
     * @param other another object
     * @return the result; may be `this` or a new instance depending on the implementation
     */
    T minus(T other);
}
