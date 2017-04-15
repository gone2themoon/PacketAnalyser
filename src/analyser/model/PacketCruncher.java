package analyser.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PacketCruncher {

	private StringProperty sIp;

	public void setSIp(String value) { 
		sIpProperty().set(value); 
	}

	public String getSIp() {
		return sIpProperty().get(); 
	}

	public StringProperty sIpProperty() {
		if (sIp == null) sIp = new SimpleStringProperty(this, "sIp");
		return sIp;
	}


	//***********
	private StringProperty sPort;

	public void setSPort(String value) { 
		sPortProperty().set(value); 
	}

	public String getSPort() {
		return sPortProperty().get(); 
	}

	public StringProperty sPortProperty() {
		if (sPort == null) sPort = new SimpleStringProperty(this, "sPort");
		return sPort;
	}

	//************

	private StringProperty dIp;

	public void setDIp(String value) { 
		dIpProperty().set(value); 
	}

	public String getdIp() {
		return dIpProperty().get(); 
	}

	public StringProperty dIpProperty() {
		if (dIp == null) dIp = new SimpleStringProperty(this, "dIp");
		return dIp;
	}

	//***********
	private StringProperty dPort;

	public void setDPort(String value) { 
		dPortProperty().set(value); 
	}

	public String getDPort() {
		return dPortProperty().get(); 
	}

	public StringProperty dPortProperty() {
		if (dPort == null) dPort = new SimpleStringProperty(this, "dPort");
		return dPort;
	}



         
         
	
	
	public PacketCruncher(String strsIp, String strsPort, String strdIp, String strdPort){
		this.sIp = new SimpleStringProperty(strsIp);
		this.sPort = new SimpleStringProperty(strsPort);
		this.dIp = new SimpleStringProperty(strdIp);
		this.dPort = new SimpleStringProperty(strdPort);
		
	

	}
}
