
public enum DaysOfWeek {
	MON(1, "Monday"), TUE(2, "Tuesday"), WED(3, "Wednesday"), THU(4, "Thursday"), FRI(5, "Friday"), SAT(6, "Saturday"),
	SUN(7, "Sunday");

	private int position;
	private String name;

	private DaysOfWeek(int position, String name) {
		this.setPosition(position);
		this.setName(name);
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	private void setPosition(int position) {
		this.position = position;
	}

	private void setName(String name) {
		this.name = name;
	}

	public static DaysOfWeek toChooseDay(int numberOfDay) {
		DaysOfWeek day = null;
		if (numberOfDay > 0 | numberOfDay < 8) {
			switch (numberOfDay) {
			case 1:
				day = DaysOfWeek.MON;
				return day;
			case 2:
				day = DaysOfWeek.TUE;
				return day;
			case 3:
				day = DaysOfWeek.WED;
				return day;
			case 4:
				day = DaysOfWeek.THU;
				return day;
			case 5:
				day = DaysOfWeek.FRI;
				return day;
			case 6:
				day = DaysOfWeek.SAT;
				return day;
			case 7:
				day = DaysOfWeek.SUN;
				return day;
			}
		} else {
			throw new NullPointerException();
		}
		return day;
	}
}
