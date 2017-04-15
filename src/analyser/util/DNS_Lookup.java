package analyser.util;


import java.net.InetAddress;
import java.net.UnknownHostException;

import analyser.view.PacketAnalysisController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

abstract class DNS_Lookup{    

abstract String getIPDomain(String line) throws UnknownHostException;
}    
// SOURCE Inherits from DNS_Lookup
class SOURCE extends DNS_Lookup{
	
	String getIPDomain(String line) throws UnknownHostException{
	InetAddress ia = InetAddress.getByName(line);
	System.out.println("Host name: "+ ia.getHostName());
	PacketAnalysisController.setDnsSrc(ia.getHostName());
	return line;}
}

//DESTINATION Inherits from DNS_Lookup
class DESTINATION extends DNS_Lookup{    
	
	String getIPDomain(String line1) throws UnknownHostException{
	InetAddress ia = InetAddress.getByName(line1);
	System.out.println("Host name: "+ ia.getHostName());
	PacketAnalysisController.setDnsDst(ia.getHostName());
	return line1;}
}  