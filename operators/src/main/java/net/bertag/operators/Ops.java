package net.bertag.operators;

import net.bertag.operators.api.Addable;
import net.bertag.operators.api.Dividable;
import net.bertag.operators.api.Multipliable;
import net.bertag.operators.api.Scalable;
import net.bertag.operators.api.Subtractable;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Utility class defining null-safe transformation operations.
 */
public class Ops {

    /**
     * Adds the two numbers together (`a + b`) if at least one input is non-null (substituting 0 for the other input if
     * it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described, or null if both inputs are null
     */
    public static Integer plus(Integer a, Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0) + defaultIfNull(b, 0);
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described, or null if both inputs are null
     */
    public static Long plus(Long a, Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0L) + defaultIfNull(b, 0L);
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described, or null if both inputs are null
     */
    public static Short plus(Short a, Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 0) + defaultIfNull(b, (short) 0));
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described, or null if both inputs are null
     */
    public static Float plus(Float a, Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0f) + defaultIfNull(b, 0f);
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described, or null if both inputs are null
     */
    public static Double plus(Double a, Double b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0d) + defaultIfNull(b, 0d);
    }

    /**
     * Adds the two objects together ({@code a + b}) using {@link Addable#plus(Object)} if both inputs are non-null; if
     * either input is null, the other input is returned.
     *
     * @param a some nullable object
     * @param b another nullable object
     * @return the sum as described, or null if both inputs are null
     * @param <T> the type of objects being added
     */
    public static <T extends Addable<T>> T plus(T a, T b) {
        return op(a, b, Addable::plus);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described, or null if both inputs are null
     */
    public static Integer minus(Integer a, Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0) - defaultIfNull(b, 0);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described, or null if both inputs are null
     */
    public static Long minus(Long a, Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0L) - defaultIfNull(b, 0L);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described, or null if both inputs are null
     */
    public static Short minus(Short a, Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 0) - defaultIfNull(b, (short) 0));
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described, or null if both inputs are null
     */
    public static Float minus(Float a, Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0f) - defaultIfNull(b, 0f);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described, or null if both inputs are null
     */
    public static Double minus(Double a, Double b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0d) - defaultIfNull(b, 0d);
    }

    /**
     * Subtracts the second object from the first ({@code a - b}) using {@link Subtractable#minus(Object)} if both
     * inputs are non-null; if either input is null, the other input is returned.
     *
     * @param a some nullable object
     * @param b another nullable object
     * @return the difference as described, or null if both inputs are null
     * @param <T> the type of objects being subtracted
     */
    public static <T extends Subtractable<T>> T minus(T a, T b) {
        return op(a, b, Subtractable::minus);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described, or null if both inputs are null
     */
    public static Integer times(Integer a, Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1) * defaultIfNull(b, 1);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described, or null if both inputs are null
     */
    public static Long times(Long a, Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1L) * defaultIfNull(b, 1L);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described, or null if both inputs are null
     */
    public static Short times(Short a, Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 1) * defaultIfNull(b, (short) 1));
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described, or null if both inputs are null
     */
    public static Float times(Float a, Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1f) * defaultIfNull(b, 1f);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described, or null if both inputs are null
     */
    public static Double times(Double a, Double b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1d) * defaultIfNull(b, 1d);
    }

    /**
     * Multiplies the two objects together ({@code a * b}) using {@link Multipliable#times(Object)} if both inputs are
     * non-null; if either input is null, the other input is returned.
     *
     * @param a some nullable object
     * @param b another nullable object
     * @return the product as described, or null if both inputs are null
     * @param <T> the type of objects being multiplied
     */
    public static <T extends Multipliable<T>> T times(T a, T b) {
        return op(a, b, Multipliable::times);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described, or null if both inputs are null
     */
    public static Integer div(Integer a, Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1) / defaultIfNull(b, 1);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described, or null if both inputs are null
     */
    public static Long div(Long a, Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1L) / defaultIfNull(b, 1L);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described, or null if both inputs are null
     */
    public static Short div(Short a, Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 1) / defaultIfNull(b, (short) 1));
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described, or null if both inputs are null
     */
    public static Float div(Float a, Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1f) / defaultIfNull(b, 1f);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described, or null if both inputs are null
     */
    public static Double div(Double a, Double b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1d) / defaultIfNull(b, 1d);
    }

    /**
     * Divides the second object from the first ({@code a / b}) using {@link Dividable#div(Object)} if both inputs are
     * non-null; if either input is null, the other input is returned.
     *
     * @param a some nullable object
     * @param b another nullable object
     * @return the quotient as described, or null if both inputs are null
     * @param <T> the type of objects being divided
     */
    public static <T extends Dividable<T>> T div(T a, T b) {
        return op(a, b, Dividable::div);
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result rounded to the nearest integer as described, or null if {@code value} is null
     */
    public static Integer scale(Integer value, Double factor) {
        return value != null ? (int) Math.round(value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result rounded to the nearest (long) integer as described, or null if {@code value} is null
     */
    public static Long scale(Long value, Double factor) {
        return value != null ? Math.round(value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result rounded to the nearest (short) integer as described, or null if {@code value} is null
     */
    public static Short scale(Short value, Double factor) {
        return value != null ? (short) Math.round(value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described, or null if {@code value} is null
     */
    public static Float scale(Float value, Double factor) {
        return value != null ? (float) (value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described, or null if {@code value} is null
     */
    public static Double scale(Double value, Double factor) {
        return value != null ? value * defaultIfNull(factor, 1d) : null;
    }

    /**
     * Scales a {@link Scalable} object by a given factor if both are non-null.  If the first argument is null, null is
     * returned; if the factor is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described, or null if {@code value} is null
     */
    public static <T extends Scalable<T>> T scale(T value, Double factor) {
        return apply(value, factor, Scalable::scale);
    }

    /**
     * Applies the given transformation to an object if it is not null.  If the value is null, then null is returned.
     *
     * @param value some nullable value
     * @param opFunction the operation to perform
     * @return the result as described, or null if {@code value} is null
     * @param <T> the type of object being operated on
     * @param <R> the type of result
     */
    public static <T, R> R map(T value, Function<T, R> opFunction) {
        return value != null ? opFunction.apply(value) : null;
    }

    /**
     * Performs the given operation on the given inputs if they are both non-null.  If one input is null, the other
     * input is returned; if both are null, null is returned.
     *
     * @param a some nullable object
     * @param b another nullable object
     * @param opFunction the operation to perform
     * @return the result as described, or null if both inputs are null
     * @param <T> the type of objects being operated upon
     */
    public static <T> T op(T a, T b, BinaryOperator<T> opFunction) {
        if (a == null) return b;
        else if (b == null) return a;
        else return opFunction.apply(a, b);
    }

    /**
     * Applies the given transformation to an object if the other input is non-null.  If the receiver (Kotlin) — or first
     * argument (Java) — is null, then null is returned; if `other` is null, then the receiver will be returned.
     *
     * @param receiver some nullable object
     * @param other another nullable object
     * @param opFunction the operation to perform
     * @return the result as described, or null if {@code receiver} is null
     * @param <T> the type of objects being operated upon
     */
    public static <T, U> T apply(T receiver, U other, BiFunction<T, U, T> opFunction) {
        if (receiver == null) return null;
        else if (other == null) return receiver;
        else return opFunction.apply(receiver, other);
    }

    /**
     * Determines if both objects are null.
     *
     * @param a some nullable object
     * @param b another nullable object
     * @return true if both objects are null; false if either or both is non-null
     */
    private static boolean allNull(Object a, Object b) {
        return a == null && b == null;
    }

    // Taken from https://commons.apache.org/proper/commons-lang/javadocs/api-3.1/src-html/org/apache/commons/lang3/ObjectUtils.html.
    // Original code licensed as follows:
    //
    // Licensed to the Apache Software Foundation (ASF) under one or more
    // contributor license agreements.  See the NOTICE file distributed with
    // this work for additional information regarding copyright ownership.
    // The ASF licenses this file to You under the Apache License, Version 2.0
    // (the "License"); you may not use this file except in compliance with
    // the License.  You may obtain a copy of the License at
    //
    //      http://www.apache.org/licenses/LICENSE-2.0
    //
    // Unless required by applicable law or agreed to in writing, software
    // distributed under the License is distributed on an "AS IS" BASIS,
    // WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    // See the License for the specific language governing permissions and
    // limitations under the License.
    /**
     * <p>Returns a default value if the object passed is {@code null}.</p>
     *
     * <pre>
     * ObjectUtils.defaultIfNull(null, null)      = null
     * ObjectUtils.defaultIfNull(null, "")        = ""
     * ObjectUtils.defaultIfNull(null, "zz")      = "zz"
     * ObjectUtils.defaultIfNull("abc", *)        = "abc"
     * ObjectUtils.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
     * </pre>
     *
     * @param <T> the type of the object
     * @param object  the {@code Object} to test, may be {@code null}
     * @param defaultValue  the default value to return, may be {@code null}
     * @return {@code object} if it is not {@code null}, defaultValue otherwise
     */
    private static <T> T defaultIfNull(T object, T defaultValue) {
        return object != null ? object : defaultValue;
    }
}
