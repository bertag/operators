package net.bertag.operators.api

/**
 * Contract for multiplying two objects together (e.g.: `this * other`).
 *
 * @param <T> the type of implementation
 */
interface Multiply<T> {
    operator fun times(other: T): T
}