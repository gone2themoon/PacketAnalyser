package analyser.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class OverLoading {
	   int quantity;
	   String currentTime;
	   public OverLoading() {
		  String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.mmmmmm").format(new Date());
		  //String timeStamp1 = new SimpleDateFormat("YYYY/MM/dd HH:MM:ss").format(new Timestamp(System.currentTimeMillis()));
		  currentTime=timeStamp;
		  System.out.println("Current Time     =" + timeStamp);
	      
	   }
	   public OverLoading(String i) {
	      System.out.println("Packet Timestamp =" + i);
	      
	   }
	   public void info() {
	      System.out.println("Number of Paramaters Passed to method =" + quantity);
	   }
	   public void info(int s) {
		   quantity++;
	      System.out.println("Number of Paramaters Passed to overloaded method =" + quantity);
	   }
	}
	
