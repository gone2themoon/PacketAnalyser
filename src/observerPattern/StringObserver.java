package observerPattern;

//import analyser.model.PacketManager;
//import analyser.view.PacketAnalysisController;

public class StringObserver extends Observer{

		   public StringObserver(Subject subject){
		      this.subject = subject;
		      this.subject.attach(this);
		   }

		   @Override
		   public void update() {
		      System.out.println("StringObserver.update Method");
		      System.out.println("Total Packet String: " + subject.getState1()); 
		      //PacketAnalysisController PAC = new PacketAnalysisController();
		      //PAC.settextArea.appendText("StringObserver.update: Packet Duration: " + subject.getState1());
		      
		      //PacketManager packetManager = new PacketManager();
		      //packetManager.splitString(subject.getState1());
		     
		   }
		}