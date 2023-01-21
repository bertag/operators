package net.bertag.operators.api

/**
 * Contract for adding two objects together (`this + other`).
 *
 * @param <T> the type of implementation
 */
interface Addable<T> {

    /**
     * Adds the other object to this one, returning a result of the same type.
     *
     * @param other another object
     * @return the result; may be `this` or a new instance depending on the implementation
     */
    operator fun plus(other: T): T
}