package net.bertag.operators.example;

import net.bertag.operators.times
import java.time.LocalDate

fun main() {
	val dailyReadingLogs = listOf(
			ReadingLog(LocalDate.parse("2023-10-01"), LocalDate.parse("2023-10-01"), 50, 0.17),
			ReadingLog(LocalDate.parse("2023-10-02"), LocalDate.parse("2023-10-02"), 55, 0.18),
			ReadingLog(LocalDate.parse("2023-10-03"), LocalDate.parse("2023-10-03"), 50, 0.17),
			ReadingLog(LocalDate.parse("2023-10-04"), LocalDate.parse("2023-10-04"), 45, 0.15),
			ReadingLog(LocalDate.parse("2023-10-05"), LocalDate.parse("2023-10-05"), 60, 0.20),
			ReadingLog(LocalDate.parse("2023-10-06"), LocalDate.parse("2023-10-06"), 40, 0.13),
			ReadingLog(LocalDate.parse("2023-10-07"), LocalDate.parse("2023-10-07"), null, null))

	val weeklyReadingLog = dailyReadingLogs.stream().reduce(ReadingLog(null, null, null, null), ReadingLog::plus)
	val weeklyAverages = weeklyReadingLog.copy().scale(1.0 / 7)

	println(weeklyReadingLog);
	println("Average pages read per day: " + weeklyAverages.pagesRead)
	println("Average daily book pace: %.2f%%".format(weeklyAverages.booksRead * 100.0))
}
