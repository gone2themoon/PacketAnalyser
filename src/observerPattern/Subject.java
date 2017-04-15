package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
   private List<Observer> observers = new ArrayList<Observer>();
   private int state;
   private String state1;

   public int getState() {
      return state;
   }
   
   public String getState1() {
	      return state1;
	   }
   
   public void setState1(String state1) {
	      this.state1 = state1;
	      notifyAllObservers();
	   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   } 	
}