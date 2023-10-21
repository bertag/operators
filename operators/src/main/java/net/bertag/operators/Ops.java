package net.bertag.operators;

import net.bertag.operators.api.Addable;
import net.bertag.operators.api.Dividable;
import net.bertag.operators.api.Multipliable;
import net.bertag.operators.api.Scalable;
import net.bertag.operators.api.Subtractable;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.framework.qual.DefaultQualifier;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static org.checkerframework.framework.qual.TypeUseLocation.PARAMETER;
import static org.checkerframework.framework.qual.TypeUseLocation.RETURN;

/**
 * Utility class defining null-safe transformation operations.
 */
@DefaultQualifier(value = NonNull.class, locations = {PARAMETER, RETURN})
public class Ops {

    /**
     * Adds the two numbers together (`a + b`) if at least one input is non-null (substituting 0 for the other input if
     * it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described
     */
    @Nullable
    public static Integer plus(@Nullable Integer a, @Nullable Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0) + defaultIfNull(b, 0);
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described
     */
    @Nullable
    public static Long plus(@Nullable Long a, @Nullable Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0L) + defaultIfNull(b, 0L);
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described
     */
    @Nullable
    public static Short plus(@Nullable Short a, @Nullable Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 0) + defaultIfNull(b, (short) 0));
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described
     */
    @Nullable
    public static Float plus(@Nullable Float a, @Nullable Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0f) + defaultIfNull(b, 0f);
    }

    /**
     * Adds the two numbers together ({@code a + b}) if at least one input is non-null (substituting 0 for the other
     * input if it is null), or returning null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the sum as described
     */
    @Nullable
    public static Double plus(@Nullable Double a, @Nullable Double b) {
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
    @Nullable
    public static <T extends Addable<T>> T plus(@Nullable T a, @Nullable T b) {
        return op(a, b, Addable::plus);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described
     */
    @Nullable
    public static Integer minus(@Nullable Integer a, @Nullable Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0) - defaultIfNull(b, 0);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described
     */
    @Nullable
    public static Long minus(@Nullable Long a, @Nullable Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0L) - defaultIfNull(b, 0L);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described
     */
    @Nullable
    public static Short minus(@Nullable Short a, @Nullable Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 0) - defaultIfNull(b, (short) 0));
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described
     */
    @Nullable
    public static Float minus(@Nullable Float a, @Nullable Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 0f) - defaultIfNull(b, 0f);
    }

    /**
     * Subtracts the second number from the first ({@code a - b}) if at least one input is non-null (substituting 0 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the difference as described
     */
    @Nullable
    public static Double minus(@Nullable Double a, @Nullable Double b) {
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
    @Nullable
    public static <T extends Subtractable<T>> T minus(@Nullable T a, @Nullable T b) {
        return op(a, b, Subtractable::minus);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described
     */
    @Nullable
    public static Integer times(@Nullable Integer a, @Nullable Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1) * defaultIfNull(b, 1);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described
     */
    @Nullable
    public static Long times(@Nullable Long a, @Nullable Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1L) * defaultIfNull(b, 1L);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described
     */
    @Nullable
    public static Short times(@Nullable Short a, @Nullable Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 1) * defaultIfNull(b, (short) 1));
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described
     */
    @Nullable
    public static Float times(@Nullable Float a, @Nullable Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1f) * defaultIfNull(b, 1f);
    }

    /**
     * Multiplies the two numbers together ({@code a * b}) if at least one input is non-null (substituting 1 for the
     * other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the product as described
     */
    @Nullable
    public static Double times(@Nullable Double a, @Nullable Double b) {
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
    @Nullable
    public static <T extends Multipliable<T>> T times(@Nullable T a, @Nullable T b) {
        return op(a, b, Multipliable::times);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described
     */
    @Nullable
    public static Integer div(@Nullable Integer a, @Nullable Integer b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1) / defaultIfNull(b, 1);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described
     */
    @Nullable
    public static Long div(@Nullable Long a, @Nullable Long b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1L) / defaultIfNull(b, 1L);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described
     */
    @Nullable
    public static Short div(@Nullable Short a, @Nullable Short b) {
        return allNull(a, b) ? null : (short) (defaultIfNull(a, (short) 1) / defaultIfNull(b, (short) 1));
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described
     */
    @Nullable
    public static Float div(@Nullable Float a, @Nullable Float b) {
        return allNull(a, b) ? null : defaultIfNull(a, 1f) / defaultIfNull(b, 1f);
    }

    /**
     * Divides the second number from the first ({@code a / b}) if at least one input is non-null (substituting 1 for
     * the other input if it is null), or null if both inputs are null.
     *
     * @param a some nullable number
     * @param b another nullable number
     * @return the quotient as described
     */
    @Nullable
    public static Double div(@Nullable Double a, @Nullable Double b) {
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
    @Nullable
    public static <T extends Dividable<T>> T div(@Nullable T a, @Nullable T b) {
        return op(a, b, Dividable::div);
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described, rounded to the nearest integer
     */
    @Nullable
    public static Integer scale(@Nullable Integer value, @Nullable Double factor) {
        return value != null ? (int) Math.round(value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described, rounded to the nearest (long) integer
     */
    @Nullable
    public static Long scale(@Nullable Long value, @Nullable Double factor) {
        return value != null ? Math.round(value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described, rounded to the nearest (short) integer
     */
    @Nullable
    public static Short scale(@Nullable Short value, @Nullable Double factor) {
        return value != null ? (short) Math.round(value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described
     */
    @Nullable
    public static Float scale(@Nullable Float value, @Nullable Double factor) {
        return value != null ? (float) (value * defaultIfNull(factor, 1d)) : null;
    }

    /**
     * Scales a number by a given factor if both are non-null.  If the {@code value} is null, null is returned; if the
     * {@code factor} is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described
     */
    @Nullable
    public static Double scale(@Nullable Double value, @Nullable Double factor) {
        return value != null ? value * defaultIfNull(factor, 1d) : null;
    }

    /**
     * Scales a {@link Scalable} object by a given factor if both are non-null.  If the first argument is null, null is
     * returned; if the factor is null, no scaling will be applied.
     *
     * @param value some nullable number
     * @param factor a nullable factor
     * @return the scaled result as described
     */
    @Nullable
    public static <T extends Scalable<T>> T scale(@Nullable T value, @Nullable Double factor) {
        return apply(value, factor, Scalable::scale);
    }

    /**
     * Applies the given transformation to an object if it is not null.  If the value is null, then null is returned.
     *
     * @param value some nullable value
     * @param opFunction the operation to perform
     * @return the result as described
     * @param <T> the type of object being operated on
     * @param <R> the type of result
     */
    @Nullable
    public static <T, R> R map(@Nullable T value, Function<T, R> opFunction) {
        return value != null ? opFunction.apply(value) : null;
    }

    /**
     * Performs the given operation on the given inputs if they are both non-null.  If one input is null, the other
     * input is returned; if both are null, null is returned.
     *
     * @param a some nullable object
     * @param b another nullable object
     * @param opFunction the operation to perform
     * @return the result as described
     * @param <T> the type of objects being operated upon
     */
    @Nullable
    public static <T> T op(@Nullable T a, @Nullable T b, BinaryOperator<T> opFunction) {
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
     * @return the result as described
     * @param <T> the type of objects being operated upon
     */
    @Nullable
    public static <T, U> T apply(@Nullable T receiver, @Nullable U other, BiFunction<T, U, T> opFunction) {
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
    private static boolean allNull(@Nullable Object a, @Nullable Object b) {
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
