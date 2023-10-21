package net.bertag.operators.example;

import net.bertag.operators.Ops;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<ReadingLog> dailyReadingLogs = List.of(
				new ReadingLog(LocalDate.parse("2023-10-01"), LocalDate.parse("2023-10-01"), 50, 0.17),
				new ReadingLog(LocalDate.parse("2023-10-02"), LocalDate.parse("2023-10-02"), 55, 0.18),
				new ReadingLog(LocalDate.parse("2023-10-03"), LocalDate.parse("2023-10-03"), 50, 0.17),
				new ReadingLog(LocalDate.parse("2023-10-04"), LocalDate.parse("2023-10-04"), 45, 0.15),
				new ReadingLog(LocalDate.parse("2023-10-05"), LocalDate.parse("2023-10-05"), 60, 0.20),
				new ReadingLog(LocalDate.parse("2023-10-06"), LocalDate.parse("2023-10-06"), 40, 0.13),
				new ReadingLog(LocalDate.parse("2023-10-07"), LocalDate.parse("2023-10-07"), null, null));

		ReadingLog weeklyReadingLog = dailyReadingLogs.stream().reduce(new ReadingLog(), ReadingLog::plus);
		ReadingLog weeklyAverages = weeklyReadingLog.copy().scale(1d / 7);

		System.out.println(weeklyReadingLog);
        System.out.println("Average pages read per day: " + weeklyAverages.getPagesRead());
		System.out.printf("Average daily book pace: %.2f%%%n", Ops.times(weeklyAverages.getBooksRead(), 100d));
	}
}
