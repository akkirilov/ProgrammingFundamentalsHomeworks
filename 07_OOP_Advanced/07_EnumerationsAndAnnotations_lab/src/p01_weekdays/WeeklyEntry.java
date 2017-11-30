package p01_weekdays;

public class WeeklyEntry implements Comparable<WeeklyEntry> {

	private Weekday weekday;
	private String notes;
	
	public WeeklyEntry(String weekday, String notes) {
		this.weekday = Weekday.valueOf(weekday.toUpperCase());
		this.notes = notes;
	}

	public Weekday getWeekday() {
		return weekday;
	}

	@Override
	public String toString() {
		return weekday + " - " + notes;
	}

	@Override
	public int compareTo(WeeklyEntry we) {
		return this.weekday.compareTo(we.getWeekday());
	}
		
}
