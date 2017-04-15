package analyser.model;

public class MiniPacket extends PacketManager{
   	private  String SrcAddr;		
   	private  String DstAddr;
   	private  String Dur;
   	
    public MiniPacket(String line){
 	   // initialize all Packet Paramaters from input "line"
 	   splitString(line);
    }
 
   	public String getDstAddr() {
		return DstAddr;
   	}

   	public void setDstAddr(String dstAddr) {
		DstAddr = dstAddr;
   	}
	
	
	public String getSrcAddr() {
		return SrcAddr;
	}

	public void setSrcAddr(String srcAddr) {
		SrcAddr = srcAddr;
	}
	
	 public String getDur() {
			return Dur;
	 }

	 public void setDur(String dur) {
			Dur = dur;
	}

   
   @Override
   public void splitString(String string){
	   //String line = "";
	   //System.out.println("in splitstring"+ string);
       String cvsSplitBy = ",";
       String[] frame = string.split(cvsSplitBy);
       
       setSrcAddr(frame[3]);
       setDstAddr(frame[6]);
       setDur(frame[1]);
      
       //System.out.println("DynamicBound Mini Packet: ");
       //System.out.println("Source IP: " + getSrcAddr());
       //System.out.println("Destination IP: " + getDstAddr());
       
       }
}