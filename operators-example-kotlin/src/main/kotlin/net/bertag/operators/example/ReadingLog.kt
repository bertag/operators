package net.bertag.operators.example;

import net.bertag.operators.api.Addable
import net.bertag.operators.api.Scalable
import net.bertag.operators.plus
import net.bertag.operators.scale
import java.time.LocalDate
import java.util.function.BinaryOperator

data class ReadingLog(
    var startDate: LocalDate?,
    var endDate: LocalDate?,
    var pagesRead: Int?,
    var booksRead: Double?
) : Addable<ReadingLog>, Scalable<ReadingLog> {

    private val minDate: BinaryOperator<LocalDate?> = BinaryOperator.minBy(Comparator.nullsLast(Comparator.naturalOrder()))
    private val maxDate: BinaryOperator<LocalDate?> = BinaryOperator.maxBy(Comparator.nullsFirst(Comparator.naturalOrder()))

    override fun plus(other: ReadingLog): ReadingLog {
        startDate = minDate.apply(startDate, other.startDate)
        endDate = maxDate.apply(endDate, other.endDate)
        pagesRead += other.pagesRead
        booksRead += other.booksRead
        return this;
    }

    override fun scale(factor: Double): ReadingLog {
        pagesRead = pagesRead.scale(factor)
        booksRead = booksRead.scale(factor)
        return this;
    }
}
