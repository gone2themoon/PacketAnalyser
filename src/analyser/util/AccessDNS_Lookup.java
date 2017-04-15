package analyser.util;

import java.net.UnknownHostException;

import analyser.view.PacketAnalysisController;

public class AccessDNS_Lookup{    
 
public static void init(String line,String line1) throws UnknownHostException{
// abstract class DNS_Lookup
DNS_Lookup b;  
b=new SOURCE();  
System.out.println("Sent IP was: "+b.getIPDomain(line));    
b=new DESTINATION();  
System.out.println("Sent IP was: "+b.getIPDomain(line1));  

}

}  