package strategyPattern;

import analyser.view.PacketAnalysisController;

public class DayTime implements Strategy{
		  

		@Override
		public int doOperation(String colour) {
			// TODO Auto-generated method stub
			System.out.println("doOPeration Method in Daytime.java. Passed State:  " + colour );
			PacketAnalysisController.barColour =colour;
			return 0;
		}
		}