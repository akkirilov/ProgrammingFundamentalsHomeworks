package p01_weekdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {
	
	private List<WeeklyEntry> weeklySchedule;

	public WeeklyCalendar() {
		this.weeklySchedule = new ArrayList<>();
	}

	public Iterable<WeeklyEntry> getWeeklySchedule()  {
		Collections.sort(weeklySchedule);
		return weeklySchedule;
	}

	public void addEntry(String weekday, String notes) {
		weeklySchedule.add(new WeeklyEntry(weekday, notes));
	}

}
