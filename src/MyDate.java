import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class MyDate {

	public static void getDate() {
		try {
			String line = toCreateDate();
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
			Date date = (Date) formatter.parse(line);
			SimpleDateFormat formatter2 = new SimpleDateFormat("EEEE");
			System.out.println(formatter2.format(date));
		} catch (ParseException e) {
			System.out.println("Error");
		}

	}

	public static void nextTuesday() {
		int dayPositionNow = LocalDate.now().getDayOfWeek().getValue();
		System.out.print("Next Tuesday is on ");
		if (dayPositionNow < DaysOfWeek.TUE.getPosition()) {
			System.out.println(LocalDate.now().plusDays(2 - dayPositionNow));
		} else {
			System.out.println(LocalDate.now().plusDays(7 - Math.abs(2 - dayPositionNow)));
		}
	}

	/*
	 * This method outputs to the console a date of the next day of the week by
	 * code: 1- Monday, 2- Tuesday, 3- Wednesday, 4- Thursday, 5- Friday, 6-
	 * Saturday, 7-Sunday
	 */
	public static void nextDayOfWeek(int numberOfDay) throws NullPointerException {
		try {
			DaysOfWeek day = DaysOfWeek.toChooseDay(numberOfDay);
			int dayPositionNow = LocalDate.now().getDayOfWeek().getValue();
			System.out.print("Next " + day.getName() + " is on ");
			if (dayPositionNow < day.getPosition()) {
				System.out.println(LocalDate.now().plusDays(day.getPosition() - dayPositionNow));
			} else {
				System.out.println(LocalDate.now().plusDays(7 - Math.abs(day.getPosition() - dayPositionNow)));
			}
		} catch (NullPointerException e) {
			System.out.println("Incorrect position number of the day.");
		}
	}

	private static String toCreateDate() {
		Scanner scan = new Scanner(System.in);
		int value;
		String line = "";
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				System.out.println("Enter a day: ");
				break;
			case 1:
				System.out.println("Enter a month: ");
				break;
			case 2:
				System.out.println("Enter a year: ");
				break;
			}
			while (scan.hasNextInt()) {
				value = scan.nextInt();
				if (toCheck(i, value)) {
					line += Integer.toString(value) + ".";
					break;
				} else {
					System.out.println("Incorrect number!");
				}
			}
		}
		System.out.println(line);
		return line;
	}

	private static boolean toCheck(int i, int value) {
		switch (i) {
		case 0:
			if (value <= 31 & value >= 0) {
				return true;
			} else {
				return false;
			}
		case 1:
			if (value <= 12 & value >= 0) {
				return true;
			} else {
				return false;
			}
		case 2:
			if (value <= 3000 & value >= 1000) {
				return true;
			} else if (value == 6666) {
				System.out.println("\u001B[31m"+"The end of the world!"+"\u001B[0m");
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
