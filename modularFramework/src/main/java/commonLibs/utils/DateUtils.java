package commonLibs.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static String getCurrentDateAndTime() {
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy-HH:MM:SS");
		
		String dateTimeFormat = dateTime.format(format);
		
		return dateTimeFormat;
		
	}

}
