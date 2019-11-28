package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date obterDataDiferecaDias(int dia) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dia);
		return cal.getTime();
	}
	
}
