package factoryPattern;

import java.io.IOException;

public interface Packet {

	void display();

	void sentInfo(String filename) throws IOException;
	
	void recInfo(String filename) throws IOException;
	}