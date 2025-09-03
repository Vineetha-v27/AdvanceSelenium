package javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {
		
		public String getCurrentDate()//java method
		{
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
			String currentDate = sim.format(date);
			return currentDate;
		}
	
		public String togetRequired(int days) //java method
		{
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
			sim.format(date);
			Calendar cal = sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, days);
			String daterequired = sim.format(cal.getTime());
			return daterequired;
		}
	

}
