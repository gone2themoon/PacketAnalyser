package strategyPattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StrategyPattern {
	   public static void main(String[] args) throws ParseException {
		   colourFill();
	   }
	   public static void colourFill() throws ParseException{
		  // if current time between 07.00 to 18.00 
		  // Context Used is Daytime
		   String dateFormat = "HH:mm:ss";
		   String startTime= "06:00:00";
		   String endTime= "18:30:00";
		   String currentTime = new SimpleDateFormat(dateFormat).format(new Date());
		   
		   // Convert for Comparison.
		   Calendar cStart = setTimeToCalendar(dateFormat, startTime, false);
		   Calendar cEnd = setTimeToCalendar(dateFormat, endTime, true);
		   Calendar cNow = setTimeToCalendar(dateFormat, currentTime, true);   
		   Date curDate = cNow.getTime();
		   
		   // Determine Which Strategy to Use Based on Time.
		   // Out out Sets the Colour of the Bars in the Packets/Hour BarChart.
		   // Daytime Strategy Sets Red Bars. NightTime Set Blue.
		   if (curDate.after(cStart.getTime()) && curDate.before(cEnd.getTime())) {
		       //System.out.println("In IF Current Time is " + currentTime + " Daytime");
		       Context context = new Context(new DayTime());
		       context.executeStrategy("-fx-bar-fill: RED;");
		   } else {
			   Context context = new Context(new NightTime());	
		       //System.out.println("Current Time is " + currentTime + " NightTime");
		       context.executeStrategy("-fx-bar-fill: BLUE;");
		   }
		  
	   }
	   /*
	    * Resusable Method "setTimeToCalendar", Sets Time to a comparable type Calander.
	    */
	   private static Calendar setTimeToCalendar(String dateFormat, String date, boolean addADay) throws ParseException {
		    Date time = new SimpleDateFormat(dateFormat).parse(date);
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(time );

		    if(addADay) {
		        cal.add(Calendar.DATE, 1);
		    }
		    return cal;
		}
	}