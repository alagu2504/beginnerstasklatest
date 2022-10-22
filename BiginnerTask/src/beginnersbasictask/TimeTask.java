package beginnersbasictask;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

public class TimeTask {

	
	public LocalDateTime localDateTime() {
		return LocalDateTime.now();
	}
	
	public long timeInMillis() {
		return System.currentTimeMillis();
	}
	public long milliSeconds() {
		return Instant.now().toEpochMilli();
	}
	
	public LocalDateTime localDateTimeWithZone(String zoneName ) {
        ZoneId zone = ZoneId.of(zoneName);
		return LocalDateTime.now(zone);
	}
	
	public DayOfWeek getDayOfWeek(long time) {
		Instant instant=Instant.ofEpochMilli(time);
		LocalDate localDate=instant.atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getDayOfWeek();
	}
	
	public Month getMonthOfGivenTime(long time) {
		Instant instant=Instant.ofEpochMilli(time);
		LocalDate localDate=instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getMonth();
	}
	
	public int getYearOfGivenTime(long time) {
		Instant instant=Instant.ofEpochMilli(time);
		LocalDate localDate=instant.atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate.getYear();
	}
	
	}
