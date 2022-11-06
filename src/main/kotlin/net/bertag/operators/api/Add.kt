package net.bertag.operators.api

/**
 * Contract for adding two objects together (e.g.: `this + other`).
 *
 * @param <T> the type of implementation
 */
interface Add<T> {
    operator fun plus(other: T): T
}