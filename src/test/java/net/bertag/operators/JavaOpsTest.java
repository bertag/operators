package net.bertag.operators;

import net.bertag.operators.test.MyData;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

/**
 * Unit tests for {@link Ops} that demonstrate compatibility with Java.
 */
public class JavaOpsTest {

    private static final double delta = 0.001;
    private static final BiPredicate<Double, Double> doubleEquals =
            (x, y) -> x == null || y == null ? x == null && y == null : (x / y) - 1.0 <= delta;

    private static final MyData data1 = new MyData("key1", 2.0);
    private static final MyData data2 = new MyData("key2", 3.0);
    private static final List<Arguments> baseArgs = Arrays.asList(
            Arguments.of(null, null, null),
            Arguments.of(data1, null, data1),
            Arguments.of(null, data2, data2));

    @Nested
    class AddableTest {

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 2", "1, 2, 3"})
        void shouldAddNullableInt(Integer a, Integer b, Integer expectedResult) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN plus(a, b) is called...
            Integer result = Ops.plus(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 2", "1, 2, 3"})
        void shouldAddNullableLong(Long a, Long b, Long expectedResult) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN plus(a, b) is called...
            Long result = Ops.plus(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 2", "1, 2, 3"})
        void shouldAddNullableShort(Short a, Short b, Short expectedResult) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN plus(a, b) is called...
            Short result = Ops.plus(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 3.3"})
        void shouldAddNullableFloat(Float a, Float b, Float expectedResult) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN plus(a, b) is called...
            Float result = Ops.plus(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within(0.001F));
            }
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 3.3"})
        void shouldAddNullableDouble(Double a, Double b, Double expectedResult) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN plus(a, b) is called...
            Double result = Ops.plus(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within(0.001));
            }
        }

        @ParameterizedTest
        @ArgumentsSource(AddObjectArgProvider.class)
        void shouldAddNullableObject(MyData a, MyData b, MyData expectedResult) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN plus(a, b) is called...
            MyData result = Ops.plus(a, b);

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                    .withEqualsForType(doubleEquals, Double.class)
                    .isEqualTo(expectedResult);
        }
    }

    private static class AddObjectArgProvider implements ArgumentsProvider {

        @Override
        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, new MyData("key1", 5.0))));
        }
    }

    @Nested
    class SubtractableTest {

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, -2", "1, 2, -1"})
        void shouldSubtractNullableInt(Integer a, Integer b, Integer expectedResult) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN minus(a, b) is called...
            Integer result = Ops.minus(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, -2", "1, 2, -1"})
        void shouldSubtractNullableLong(Long a, Long b, Long expectedResult) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN minus(a, b) is called...
            Long result = Ops.minus(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, -2", "1, 2, -1"})
        void shouldSubtractNullableShort(Short a, Short b, Short expectedResult) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN minus(a, b) is called...
            Short result = Ops.minus(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, -2.2", "1.1, 2.2, -1.1"})
        void shouldSubtractNullableFloat(Float a, Float b, Float expectedResult) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN minus(a, b) is called...
            Float result = Ops.minus(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within(0.001F));
            }
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, -2.2", "1.1, 2.2, -1.1"})
        void shouldSubtractNullableDouble(Double a, Double b, Double expectedResult) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN minus(a, b) is called...
            Double result = Ops.minus(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within(0.001));
            }
        }

        @ParameterizedTest
        @ArgumentsSource(SubtractObjectArgProvider.class)
        void shouldSubtractNullableObject(MyData a, MyData b, MyData expectedResult) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN minus(a, b) is called...
            MyData result = Ops.minus(a, b);

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                    .withEqualsForType(doubleEquals, Double.class)
                    .isEqualTo(expectedResult);
        }
    }

    private static class SubtractObjectArgProvider implements ArgumentsProvider {

        @Override
        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, new MyData("key1", -1.0))));
        }
    }

    @Nested
    class MultipliableTest {

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 2", "3, 4, 12"})
        void shouldMultiplyNullableInt(Integer a, Integer b, Integer expectedResult) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN times(a, b) is called...
            Integer result = Ops.times(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 2", "3, 4, 12"})
        void shouldMultiplyNullableLong(Long a, Long b, Long expectedResult) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN times(a, b) is called...
            Long result = Ops.times(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 2", "3, 4, 12"})
        void shouldMultiplyNullableShort(Short a, Short b, Short expectedResult) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN times(a, b) is called...
            Short result = Ops.times(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 2.42"})
        void shouldMultiplyNullableFloat(Float a, Float b, Float expectedResult) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN times(a, b) is called...
            Float result = Ops.times(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within((float) delta));
            }
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, 2.2", "1.1, 2.2, 2.42"})
        void shouldMultiplyNullableDouble(Double a, Double b, Double expectedResult) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN times(a, b) is called...
            Double result = Ops.times(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within(delta));
            }
        }

        @ParameterizedTest
        @ArgumentsSource(MultiplyObjectArgProvider.class)
        void shouldMultiplyNullableObject(MyData a, MyData b, MyData expectedResult) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN times(a, b) is called...
            MyData result = Ops.times(a, b);

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                    .withEqualsForType(doubleEquals, Double.class)
                    .isEqualTo(expectedResult);
        }
    }

    private static class MultiplyObjectArgProvider implements ArgumentsProvider {

        @Override
        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, new MyData("key1", 6.0))));
        }
    }

    @Nested
    class DividableTest {

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1"})
        void shouldDivideNullableInt(Integer a, Integer b, Integer expectedResult) {
            // GIVEN two nullable ints `a` and `b`.
            // WHEN div(a, b) is called...
            Integer result = Ops.div(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1"})
        void shouldDivideNullableLong(Long a, Long b, Long expectedResult) {
            // GIVEN two nullable longs `a` and `b`.
            // WHEN div(a, b) is called...
            Long result = Ops.div(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2, 0", "10, 5, 2", "10, 6, 1"})
        void shouldDivideNullableShort(Short a, Short b, Short expectedResult) {
            // GIVEN two nullable shorts `a` and `b`.
            // WHEN div(a, b) is called...
            Short result = Ops.div(a, b);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, 0.4545", "1.1, 2.2, 0.5"})
        void shouldDivideNullableFloat(Float a, Float b, Float expectedResult) {
            // GIVEN two nullable floats `a` and `b`.
            // WHEN div(a, b) is called...
            Float result = Ops.div(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within((float) delta));
            }
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1.1, , 1.1", ", 2.2, 0.4545", "1.1, 2.2, 0.5"})
        void shouldDivideNullableDouble(Double a, Double b, Double expectedResult) {
            // GIVEN two nullable doubles `a` and `b`.
            // WHEN div(a, b) is called...
            Double result = Ops.div(a, b);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within(delta));
            }
        }

        @ParameterizedTest
        @ArgumentsSource(DivideObjectArgProvider.class)
        void shouldDivideNullableObject(MyData a, MyData b, MyData expectedResult) {
            // GIVEN two nullable objects `a` and `b`.
            // WHEN div(a, b) is called...
            MyData result = Ops.div(a, b);

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                    .withEqualsForType(doubleEquals, Double.class)
                    .isEqualTo(expectedResult);
        }
    }

    private static class DivideObjectArgProvider implements ArgumentsProvider {

        @Override
        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.concat(baseArgs.stream(), Stream.of(Arguments.of(data1, data2, new MyData("key1", 2.0 / 3.0))));
        }
    }

    @Nested
    class ScalableTest {

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 5"})
        void shouldScaleNullableInt(Integer obj, Double factor, Integer expectedResult) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN scale(obj, factor) is called...
            Integer result = Ops.scale(obj, factor);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 5"})
        void shouldScaleNullableLong(Long obj, Double factor, Long expectedResult) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN scale(obj, factor) is called...
            Long result = Ops.scale(obj, factor);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 5"})
        void shouldScaleNullableShort(Short obj, Double factor, Short expectedResult) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN scale(obj, factor) is called...
            Short result = Ops.scale(obj, factor);

            // THEN it should return the expected result.
            assertThat(result).isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 4.5"})
        void shouldScaleNullableFloat(Float obj, Double factor, Float expectedResult) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN scale(obj, factor) is called...
            Float result = Ops.scale(obj, factor);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within((float) delta));
            }
        }

        @ParameterizedTest
        @CsvSource({", , , ", "1, , 1", ", 2.0, ", "3, 1.5, 4.5"})
        void shouldScaleNullableDouble(Double obj, Double factor, Double expectedResult) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN scale(obj, factor) is called...
            Double result = Ops.scale(obj, factor);

            // THEN it should return the expected result.
            if (expectedResult == null) {
                assertThat(result).isNull();
            } else {
                assertThat(result).isEqualTo(expectedResult, within(delta));
            }
        }

        @ParameterizedTest
        @ArgumentsSource(ScalableObjectArgProvider.class)
        void shouldScaleNullableObject(MyData obj, Double factor, MyData expectedResult) {
            // GIVEN a nullable object `obj` and a factor.
            // WHEN scale(obj, factor) is called...
            MyData result = Ops.scale(obj, factor);

            // THEN it should return the expected result.
            assertThat(result).usingRecursiveComparison()
                    .withEqualsForType(doubleEquals, Double.class)
                    .isEqualTo(expectedResult);
        }
    }

    private static class ScalableObjectArgProvider implements ArgumentsProvider {

        public Stream<Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(null, null, null),
                    Arguments.of(data2, null, data2),
                    Arguments.of(null, 1.0, null),
                    Arguments.of(data2, 1.5, new MyData("key2", 4.5)));
        }
    }
}

