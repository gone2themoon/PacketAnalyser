package factoryPattern;

public class PacketFactory {
	
	   //use getShape method to get object of type shape 
	   public Packet getPacket(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("RECEIVED")){
	         return new ReceivedPacket();
	         
	      } else if(shapeType.equalsIgnoreCase("SENT")){
	         return new SentPacket();
	      }   
	      
	      
	      return null;
	   }
	}