package net.bertag.operators;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for {@link Ops}.
 *
 * @implNote Since all methods except {@link Ops#map(Object, Function)} are tested in {@link ExtensionsTest}, we only
 * test that one method here.
 */
public class OpsTest {

    @Nested
    class MapTest {

        @Test
        void shouldMapNullToNull() {
            // GIVEN a nullable object and a mapping function.
            // WHEN map is called...
            // THEN it should return the expected result.
            assertNull(Ops.map((String) null, LocalDate::parse));
        }

        @Test
        void shouldMapNonNull() {
            // GIVEN a nullable object and a mapping function.
            // WHEN map is called...
            LocalDate result = Ops.map("2023-01-01", LocalDate::parse);

            // THEN it should return the expected result.
            LocalDate expectedResult = LocalDate.parse("2023-01-01");
            assertThat(result).isEqualTo(expectedResult);
        }
    }
}
