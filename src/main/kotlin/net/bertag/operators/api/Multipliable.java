package net.bertag.operators.api;

/**
 * Contract for multiplying two objects together (`this * other`).
 *
 * @param <T> the type of implementation
 */
public interface Multipliable<T> {

    /**
     * Multiplies this object by the other object, returning a result of the same type.
     *
     * @param other another object
     * @return the result; may be `this` or a new instance depending on the implementation
     */
    T times(T other);
}
