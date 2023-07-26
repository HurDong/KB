package day_0725;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int dt = c.get(Calendar.DAY_OF_MONTH);
		System.out.println((year + 1) + " " + (month + 1) + " " + dt);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일");
		String today = dateFormat.format(new Date());
		System.out.println(today);
	}
}
