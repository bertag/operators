package net.bertag.operators.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bertag.operators.Ops;
import net.bertag.operators.api.Addable;
import net.bertag.operators.api.Scalable;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.BinaryOperator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadingLog implements Addable<ReadingLog>, Scalable<ReadingLog> {

    private static final BinaryOperator<LocalDate> minDate = BinaryOperator.minBy(Comparator.nullsLast(Comparator.naturalOrder()));
    private static final BinaryOperator<LocalDate> maxDate = BinaryOperator.maxBy(Comparator.nullsFirst(Comparator.naturalOrder()));

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer pagesRead;
    private Double booksRead;

    public ReadingLog copy() {
        return new ReadingLog(startDate, endDate, pagesRead, booksRead);
    }

    @Override
    public ReadingLog plus(ReadingLog other) {
        startDate = minDate.apply(startDate, other.startDate);
        endDate = maxDate.apply(endDate, other.endDate);
        pagesRead = Ops.plus(pagesRead, other.pagesRead);
        booksRead = Ops.plus(booksRead, other.booksRead);
        return this;
    }

    @Override
    public ReadingLog scale(double factor) {
        pagesRead = Ops.scale(pagesRead, factor);
        booksRead = Ops.scale(booksRead, factor);
        return this;
    }
}
