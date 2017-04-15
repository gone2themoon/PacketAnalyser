package factoryPattern;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import analyser.model.PacketManager;

public class SentPacket implements Packet {

	   @Override
	   public void display() {
	      System.out.println("Inside Sent Packet::display() method.");
	   }
	   @Override
	   public void sentInfo(String fileName) throws IOException{
		   try (BufferedReader br = new BufferedReader(new FileReader(fileName))){ 
	             String line;
	             br.readLine();
	             line = null;
	             // pick random line string from file
	             Random random = new Random();
	             int randomInt = random.nextInt(500000);
	             //while ((line = br.readLine()) != null) {
	             for (int i = 0; i < randomInt + 1; i++) {
	            	 line = br.readLine();
	             }
	             // process the line.
	             PacketManager encap = new PacketManager(line);
	    	     // 
	    	     System.out.println("PacketFactory Returns SOURCE IP: " + encap.getSrcAddr());
	    	     System.out.println("PacketFactory Returns SOURCE Port: " + encap.getSport());
	    	     //DNS_Lookup b = new DNS_Lookup();
	    	     //b=new SOURCE(); 
	    	     //AccessDNS_Lookup.DNS_Lookup b;
	    	     //System.out.println("Sent IP was: "+b.getIPDomain(SrcAddr));    
	    	     //b=new DESTINATION();  
	    	     //System.out.println("Sent IP was: "+b.getIPDomain(DstAddr));  
	             //} 
	    	 }
	    	 catch (FileNotFoundException e){
	    		 e.printStackTrace();
	    	 }
	    	 }
		   
	   
	   @Override
	   public void recInfo(String filename) {
		// TODO Auto-generated method stub
	   }
	
		
	   
	  
	}