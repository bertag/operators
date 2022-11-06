package net.bertag.operators

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OpsTest {

    @Nested
    inner class AddTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "1, 2, 3")
        fun shouldAddNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a.plus(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "1, 2, 3")
        fun shouldAddNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a.plus(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "1, 2, 3")
        fun shouldAddNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a.plus(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 3.3")
        fun shouldAddNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.plus(b) is called...
            val result = a.plus(b)

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
            val result = a.plus(b)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001))
            }
        }
    }

    @Nested
    inner class SubtractTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, -2", "1, 2, -1")
        fun shouldSubtractNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a.minus(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, -2", "1, 2, -1")
        fun shouldSubtractNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a.minus(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, -2", "1, 2, -1")
        fun shouldSubtractNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a.minus(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, -2.2", "1.1, 2.2, -1.1")
        fun shouldSubtractNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a.minus(b)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001F))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, -2.2", "1.1, 2.2, -1.1")
        fun shouldSubtractNullableDouble(a: Double?, b: Double?, expectedResult: Double?) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN a.minus(b) is called...
            val result = a.minus(b)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001))
            }
        }
    }

    @Nested
    inner class MultiplyTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "3, 4, 12")
        fun shouldMultiplyNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a.times(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "3, 4, 12")
        fun shouldMultiplyNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a.times(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 2", "3, 4, 12")
        fun shouldMultiplyNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a.times(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 2.42")
        fun shouldMultiplyNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a.times(b)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001F))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 2.42")
        fun shouldMultiplyNullableDouble(a: Double?, b: Double?, expectedResult: Double?) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN a.times(b) is called...
            val result = a.times(b)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001))
            }
        }
    }

    @Nested
    inner class DivideTest {

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1")
        fun shouldDivideNullableInt(a: Int?, b: Int?, expectedResult: Int?) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a.div(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1")
        fun shouldDivideNullableLong(a: Long?, b: Long?, expectedResult: Long?) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a.div(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1")
        fun shouldDivideNullableShort(a: Short?, b: Short?, expectedResult: Short?) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a.div(b)

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult)
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 0.4545", "1.1, 2.2, 0.5")
        fun shouldDivideNullableFloat(a: Float?, b: Float?, expectedResult: Float?) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a.div(b)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001F))
            }
        }

        @ParameterizedTest
        @CsvSource(", , , ", "1.1, , 1.1", ", 2.2, 0.4545", "1.1, 2.2, 0.5")
        fun shouldDivideNullableDouble(a: Double?, b: Double?, expectedResult: Double?) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN a.div(b) is called...
            val result = a.div(b)

            // THEN it should return the expected result.
            when (expectedResult) {
                null -> assertThat(result).isNull()
                else -> assertThat(result).isEqualTo(expectedResult, within(0.001))
            }
        }
    }
}