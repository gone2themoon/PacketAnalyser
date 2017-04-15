package analyser.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DNSLookup{
	
	public static void returnAddress(String string) throws UnknownHostException{
	try{
	InetAddress ia = InetAddress.getByName(string);
	System.out.println("Host name: "+ ia.getHostName());
	//System.out.println("Host Name: " + ia.getCanonicalHostName());
	}
	catch (UnknownHostException e){
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("UnknownHostAddress Title");
        alert.setHeaderText("No Host Can Be resloved Header");
        alert.setContentText("No Host can be resolved");
        alert.showAndWait();
	}
	}
}
