package strategyPattern;

import analyser.view.PacketAnalysisController;

public class NightTime implements Strategy{
		   

		@Override
		public int doOperation(String colour) {
			// TODO Auto-generated method stub
			System.out.println("doOPeration in NightTime" + colour );
			PacketAnalysisController.barColour =colour;
			return 0;
		}
		}