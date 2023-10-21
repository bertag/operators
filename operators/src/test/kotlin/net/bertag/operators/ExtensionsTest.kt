package net.bertag.operators

import net.bertag.operators.test.MyData
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.CsvSource
import java.util.stream.Stream

/**
 * Unit tests for `Extensions.kt`.
 */
class ExtensionsTest {

    companion object {
        private const val DELTA = 0.001
        private val doubleEquals = fun(x: Double?, y: Double?): Boolean =
            if (x == null || y == null) x == null && y == null else (x / y) - 1.0 <= DELTA

        private val data1 = MyData("key1", 2.0)
        private val data2 = MyData("key2", 3.0)
        private val baseArgs = listOf(
            Arguments.of(null, null, null),
            Arguments.of(data1, null, data1),
            Arguments.of(null, data2, data2))
    }

    @Nested
    inner class AddableTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "1, 2, 3")
        fun shouldAddNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a + b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "1, 2, 3")
        fun shouldAddNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a + b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "1, 2, 3")
        fun shouldAddNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a + b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 3.3")
        fun shouldAddNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a + b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001F))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 3.3")
        fun shouldAddNullableDouble(a: Double?, b: Double?, expectedResult: Double?) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a + b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA))
            }
        }

        @ParameterizedTest
        @ArgumentsSource(AddObjectArgProvider::class)
        fun shouldAddNullableObject(a: MyData?, b: MyData?, expectedResult: MyData?) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a + b

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                .withEqualsForType(doubleEquals, Double::class.java)
                .isEqualTo(expectedResult)
        }
    }

    private class AddObjectArgProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> =
            Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, MyData("key1", 5.0))))
    }

    @Nested
    inner class SubtractableTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, -2", "1, 2, -1")
        fun shouldSubtractNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a - b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, -2", "1, 2, -1")
        fun shouldSubtractNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a - b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, -2", "1, 2, -1")
        fun shouldSubtractNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a - b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, -2.2", "1.1, 2.2, -1.1")
        fun shouldSubtractNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a - b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA.toFloat()))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, -2.2", "1.1, 2.2, -1.1")
        fun shouldSubtractNullableDouble(a: Double?, b: Double?, expectedResult: Double?) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a - b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA))
            }
        }

        @ParameterizedTest
        @ArgumentsSource(SubtractObjectArgProvider::class)
        fun shouldSubtractNullableObject(a: MyData?, b: MyData?, expectedResult: MyData?) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a - b

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                .withEqualsForType(doubleEquals, Double::class.java)
                .isEqualTo(expectedResult)
        }
    }

    private class SubtractObjectArgProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> =
            Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, MyData("key1", -1.0))))
    }

    @Nested
    inner class MultipliableTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "3, 4, 12")
        fun shouldMultiplyNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a * b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "3, 4, 12")
        fun shouldMultiplyNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a * b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "3, 4, 12")
        fun shouldMultiplyNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a * b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 2.42")
        fun shouldMultiplyNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a * b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA.toFloat()))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 2.42")
        fun shouldMultiplyNullableDouble(a: Double?, b: Double?, expectedResult: Double?) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a * b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA))
            }
        }

        @ParameterizedTest
        @ArgumentsSource(MultiplyObjectArgProvider::class)
        fun shouldMultiplyNullableObject(a: MyData?, b: MyData?, expectedResult: MyData?) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a * b

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                .withEqualsForType(doubleEquals, Double::class.java)
                .isEqualTo(expectedResult)
        }
    }

    private class MultiplyObjectArgProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> =
            Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, MyData("key1", 6.0))))
    }

    @Nested
    inner class DividableTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1")
        fun shouldDivideNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a / b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1")
        fun shouldDivideNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a / b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1")
        fun shouldDivideNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a / b

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 0.4545", "1.1, 2.2, 0.5")
        fun shouldDivideNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a / b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA.toFloat()))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 0.4545", "1.1, 2.2, 0.5")
        fun shouldDivideNullableDouble(a: Double?, b: Double?, expectedResult: Double?) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a / b

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA))
            }
        }

        @ParameterizedTest
        @ArgumentsSource(DivideObjectArgProvider::class)
        fun shouldDivideNullableObject(a: MyData?, b: MyData?, expectedResult: MyData?) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a.div(b)

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                .withEqualsForType(doubleEquals, Double::class.java)
                .isEqualTo(expectedResult)
        }
    }

    private class DivideObjectArgProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> =
            Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, MyData("key1", 2.0 / 3.0))))
    }

    @Nested
    inner class ScalableTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 5")
        fun shouldScaleNullableInt(obj: Int?, factor: Double?, expectedResult: Int?) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN obj.scale(factor) is called...
            val result = obj.scale(factor)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 5")
        fun shouldScaleNullableLong(obj: Long?, factor: Double?, expectedResult: Long?) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN obj.scale(factor) is called...
            val result = obj.scale(factor)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 5")
        fun shouldScaleNullableShort(obj: Short?, factor: Double?, expectedResult: Short?) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN obj.scale(factor) is called...
            val result = obj.scale(factor)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 4.5")
        fun shouldScaleNullableFloat(obj: Float?, factor: Double?, expectedResult: Float?) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN obj.scale(factor) is called...
            val result = obj.scale(factor)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA.toFloat()))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 4.5")
        fun shouldScaleNullableDouble(obj: Double?, factor: Double?, expectedResult: Double?) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN obj.scale(factor) is called...
            val result = obj.scale(factor)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(DELTA))
            }
        }

        @ParameterizedTest
        @ArgumentsSource(ScalableObjectArgProvider::class)
        fun shouldScaleNullableObject(obj: MyData?, factor: Double?, expectedResult: MyData?) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN obj.scale(factor) is called...
            val result = obj.scale(factor)

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                .withEqualsForType(doubleEquals, Double::class.java)
                .isEqualTo(expectedResult)
        }
    }

    private class ScalableObjectArgProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> = Stream.of(
            Arguments.of(null, null, null),
            Arguments.of(data2, null, data2),
            Arguments.of(null, 1.0, null),
            Arguments.of(data2, 1.5, MyData("key2", 4.5)))
    }

    @Nested
    inner class OpTest {

        @ParameterizedTest
        @ArgumentsSource(AddObjectArgProvider::class)
        fun shouldOpNullableObject(a: MyData?, b: MyData?, expectedResult: MyData?) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN a.op(b) is called...
            val result = a.op(b) { x, y -> x + y }

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                .withEqualsForType(doubleEquals, Double::class.java)
                .isEqualTo(expectedResult)
        }
    }

    @Nested
    inner class ApplyTest {

        @ParameterizedTest
        @ArgumentsSource(ScalableObjectArgProvider::class)
        fun shouldApplyNullableObject(a: MyData?, factor: Double?, expectedResult: MyData?) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN a.apply(b) is called...
            val result = a.apply(factor) { x, y -> x.scale(y) }

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                .withEqualsForType(doubleEquals, Double::class.java)
                .isEqualTo(expectedResult)
        }
    }
}