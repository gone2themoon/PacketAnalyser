package observerPattern;

import analyser.model.PacketManager;

public class SourceIPObserver extends Observer{

		   public SourceIPObserver(Subject subject){
		      this.subject = subject;
		      this.subject.attach(this);
		   }

		   @Override
		   public void update() {
			   PacketManager encap = new PacketManager(subject.getState1());
	    	   //String SrcAddr = encap.getSrcAddr();
	    	   
	    	   System.out.println("SourceIPObserver.update Method");
			   System.out.println("Source IP: " + encap.getSrcAddr()); 
			     
	    	   
		     
		   }
		}