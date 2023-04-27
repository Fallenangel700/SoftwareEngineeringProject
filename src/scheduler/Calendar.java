package scheduler;

import java.time.DateTimeException;
import java.time.Year;
import java.time.YearMonth;

public class Calendar {

	public Day[][] calendar;

	public Calendar() {
		this.calendar = new Day[12][];

		// Determine the number of days in each month
		for (int i = 0; i < 12; ++i)
			this.calendar[i] = new Day[lengthOfMonth(i + 1)];
	}

	public void display() {
		for (Day[] month : calendar)
			for (Day day : month)
				day.display();
	}

	/**
	 * Returns the length of the month, taking account of the year.
	 * 
	 * @param month the month-of-year to represent, from 1 (January) to 12
	 *              (December)
	 * @return the length of the month in days, from 28 to 31
	 * @throws DateTimeException if {@code month} is invalid
	 */
	private static int lengthOfMonth(int month) {
		return YearMonth.of(Year.now().getValue(), month).lengthOfMonth();
	}

}
