package analyser.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import observerPattern.SourceIPObserver;
import observerPattern.StringObserver;
import observerPattern.Subject;
import strategyPattern.StrategyPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import analyser.MainApp;
import analyser.model.PacketManager;
import analyser.model.MiniPacket;
import analyser.model.PacketCruncher;
import analyser.util.OverLoading;


import java.net.UnknownHostException;
import java.text.ParseException;

import factoryPattern.Packet;
import factoryPattern.PacketFactory;
import analyser.util.AccessDNS_Lookup;
//import analyser.util.DNS_Lookup;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

 public class PacketAnalysisController {
	
    	// Reference to the main application.
    	private MainApp mainApp;
    	
    	// Tab_3    	
        @FXML
        private TableView<PacketCruncher> packetTable;
        @FXML
        private TableColumn<PacketCruncher, String> sourceIPColumn;
        @FXML
        private TableColumn<PacketCruncher, String> sourcePortColumn;
        @FXML
        private TableColumn<PacketCruncher, String> destIpColumn;
        @FXML
        private TableColumn<PacketCruncher, String> destPortColumn;

        
        
	    @FXML
	    private BarChart<?, ?> somename;

	    @FXML
	    private CategoryAxis xaxis;

	    @FXML
	    private NumberAxis yaxis;
	   
	    @FXML 
	    private TextField tab_1_Text_field;
	    
	    @FXML
	    private TextArea textArea;
	    
	    @FXML
	    public TextArea settextArea;
	    
	    @FXML
	    private Button btnRefresh;

	    @FXML
	    private Button btnBack;
	    
	    public static String barColour;
	    
	    public static String DnsSrc;
	    public static String DnsDst;
	    
	    public static void setDnsSrc(String dnsSrc) {
	    	DnsSrc = dnsSrc;
	       }
	    public static void setDnsDst(String dnsDst) {
	    	DnsDst = dnsDst;
	       }
	   
	   
	    @FXML	    
	    /*
	     * Is called by the main application to give a reference back to itself.
	     * 
	     * @param mainApp
	     */
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;
      
	    }
	    
	    /*
	     * The constructor.
	     * The constructor is called before the initialize() method.
	     */
	    public PacketAnalysisController() {
	    	
	    }

	    /*
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     * @throws IOException 
	     */
	    @FXML
	    public void initialize() throws IOException, ParseException {
	    	System.out.println("Initialized");
	    	String path = FileSelectOverviewController.selectedFile;
	    	
	    	createObservableList(path);
	    
	    	
	  /*  	 // Listen for selection changes and show the person details when changed.
	        packetTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showPacketDetails(newValue));
	  */  
	
	    	
	    	
	/*
	    //	TableColumn colsIpinfo = new  TableColumn("Source Ip");
	    	
	    	TableColumn<PacketCruncher,String> colsIp = new TableColumn<>("sIp");
	    	colsIp.setCellValueFactory(new PropertyValueFactory<PacketCruncher, String>("sIp"));
	    	colsIp.setMinWidth(packetTable.getMaxWidth()/4);
	    	
	 //   	TableColumn colsPortinfo = new  TableColumn("Source Port");
	    	TableColumn<PacketCruncher,String> colsPort = new TableColumn<>("sPort");
	    	colsPort.setCellValueFactory(new PropertyValueFactory<PacketCruncher, String>("sPort"));
	    	colsPort.setMinWidth(packetTable.getMaxWidth()/4);
	    	
	  //  	TableColumn coldIpinfo = new  TableColumn("Dest Ip");
	    	TableColumn<PacketCruncher,String> coldIp = new TableColumn<>("dIp");
	    	coldIp.setCellValueFactory(new PropertyValueFactory<PacketCruncher, String>("dIp"));
	    	coldIp.setMinWidth(packetTable.getMaxWidth()/4);
	    	
	 //   	TableColumn coldPortinfo = new  TableColumn("Dest Port");
	    	TableColumn<PacketCruncher,String> coldPort = new TableColumn<>("dPort");
	    	coldPort.setCellValueFactory(new PropertyValueFactory<PacketCruncher, String>("dPort"));
	    	coldPort.setMinWidth(packetTable.getMaxWidth()/4);
	    	
	    	
	    	
	    //	colsIp.getColumns().addAll(colsIp);
	    //	colsPort.getColumns().addAll(colsPort);
	    //	coldIp.getColumns().addAll(coldIp);
	    //	coldPort.getColumns().addAll(coldPort);
	    	packetTable.getColumns().addAll(colsIp,colsPort,coldIp,coldPort);
	    	
	    	
	   	 // Initialize the packet table with the two columns.
	 
	  */  	
	    	
	    	
	    	
	    	/*
	    	  * Strategy Pattern 
	    	  */
	 /*   	System.out.println("Demonstrate Strategy Pattern: Colour Barchart Based on Time");
	    	StrategyPattern spd = new StrategyPattern();
	    	spd.colourFill();
	 */   	
	    	
	    	/*
	    	 * Set the Information for TAB_1 
	    	 * Barchart: Packets/Hour
	    	 */
	 //   	 calcPacketsPerHour(path);
			
	    	/*
	    	 * Read line by line and put information to TAB_2
	    	 * TextField: Formated Text
	    	 * Method uses Overloading to pass data to the PacketManager class
	    	 */
	    	// readLineInfoShort(path);
	    	
	    	 /*
	    	  * Call Method to Demonstrate an Abstract Class
	    	  */
	    	// findSrcDstHost(path);
	    	 
	    	 /*
	    	  * Call Method to Demonstrate Overloading
	    	  */
	    	// showOverLoading(path);
	    	 
	    	 
	    	 /*
	    	  *  Call Method to Demonstrate an ObserverPattern
	    	  */
	    //	 observeMe(path);
	    	 
	    	 /*
	    	  *  Call Methog to Demonstrate a FactoryPattern
	    	  */
	  //  	 packetFactory(path);
	    	 
	    	 /*
	    	  * Dynamic Binding
	    	  */
	    	 
	    	 
	    	/*
	    	 * Parce the Selected file & put to Tab_2
	    	 */
	    	//CSVREADER_MOVE(path);
        	
	    	
        	
	    	//CSVREADER_MOVE("C:\\temp\\ReadMe.txt");
	    	
	    	/*
	    	 * Pass a Txt File to PacketTime(), Builds an array & indexes packet times.
	    	 */
	  //      PacketTime(path);
	    	 System.out.println("Done");
	    }
	    
	    /**
	     * Fills all text fields to show details about the person.
	     * If the specified person is null, all text fields are cleared.
	     * 
	     * @param person the person or null
	     */
	    private void showPacketDetails(PacketCruncher packetCruncher) {
	        if (packetCruncher != null) {
	            // Fill the labels with info from the person object.
	         // Here lands the selected item from the packet Table.
	        }
	    }

	    private void createObservableList(String path) throws IOException{
	    	//	   	TableView<PacketCruncher> packetTable = new  TableView<>();
	    	ObservableList<PacketCruncher> packets = FXCollections.observableArrayList();
	    	try (BufferedReader br = new BufferedReader(new FileReader(path))){ 
	    		br.readLine();
	    		String line =null;

	    		PacketManager packetManager = new PacketManager();
	    		while ((line = br.readLine()) != null) {
	    			packetManager.splitString(line);
	    			String SourceIp = packetManager.getSrcAddr();
	    			String SourcePort = packetManager.getSport();
	    			String DestIp= packetManager.getDstAddr();
	    			String DestPort= packetManager.getDport();

	    			packets.add(new PacketCruncher(SourceIp, SourcePort, DestIp, DestPort) );
	    		}

	    		// Initialize the Packet table with the columns.
	    		sourceIPColumn.setCellValueFactory(cellData -> cellData.getValue().sIpProperty());
	    		sourcePortColumn.setCellValueFactory(cellData -> cellData.getValue().sPortProperty());
	    		destIpColumn.setCellValueFactory(cellData -> cellData.getValue().dIpProperty());
	    		destPortColumn.setCellValueFactory(cellData -> cellData.getValue().dPortProperty());
	    		
	    		// Set Items to the Table
	    		packetTable.setItems(packets);
	    		packetTable.setMaxSize(500,600);
	    		packetTable.setMinSize(250,300);
	    	}
	    	catch (FileNotFoundException e){
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.initOwner(mainApp.getPrimaryStage());
	    		alert.setTitle("No File");
	    		alert.setHeaderText("No Packet File Found");
	    		alert.setContentText("Please select another File.");
	    		alert.showAndWait();
	    	}
	    }
	    
	    /*
	     * Method to Demonstrate an ObserverPattern
	     */
	    private void observeMe(String path) throws FileNotFoundException, IOException {
	    	Subject subject = new Subject();
	    	new StringObserver(subject);
	    	new SourceIPObserver(subject);
	    	try (BufferedReader br = new BufferedReader(new FileReader(path))){ 
	             //Skip 1st line in DataFile;
				 br.readLine();
	             String line =null;
	             // Delcare packetManager
	             PacketManager packetManager = new PacketManager();
	             //while ((line = br.readLine()) != null) {
	             line = br.readLine();
	             // process the line.
	             // Initialise encap values from String "line"
	             packetManager.splitString(line);
	             // Return encapsulated StartTime
	             subject.setState1(line);
	            
	    	}

			
		}
	
	    /*
	     *  Method to Show Overloading. Outputs to Console only.
	     */
	    private void showOverLoading(String path) {
	        System.out.println("Entering showOverloading");
	        //Overloaded constructor:
		  	new OverLoading();	
		  	//Non Overloaded Constructor
	        OverLoading t = new OverLoading("2011/08/10 09:47:48.230897");
	        // Non Overloaded Method
	  	    t.info();
	  	    // Overloaded Method
	  	    t.info(1);
	  	      
	  	      
		/*
		 *  Demonstration of an Abstract Class.
		 *  Method returns the DNS Host Name of the Source/Destination IP from a Random Packet.
		 *  	
		 */
		}
	    
	    /*
	     *  Method to Demonstrate an Abstract Class
	     */
	    public void findSrcDstHost(String fileName) throws IOException, UnknownHostException {
	    	System.out.println("Entering findSrcDstHost");
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
	             // Dynamic Binding. MiniPacket Extends Packet.
	             PacketManager encap = new MiniPacket(line);
	    	     String SrcAddr = encap.getSrcAddr();
	    	     String DstAddr = encap.getDstAddr();
	    	     // 
	    	     AccessDNS_Lookup a = new AccessDNS_Lookup();
	    	     AccessDNS_Lookup.init(SrcAddr, DstAddr);
	    	     setTab_2_Text("####### PacketAnalysisController.findSrcDstHost ########");
	    	     setTab_2_Text("Here I've used an Abstract Class \"DNS_Lookup\" to Return");
	    	     setTab_2_Text("the Source and Destination HostNames" );
	    	     setTab_2_Text("from a line chosen at Random from the data supplied.");
	    	     setTab_2_Text("Source Hostname : " + DnsSrc);
	    	     setTab_2_Text("Destination Hosname : " + DnsDst);
	    	     setTab_2_Text("####### PacketAnalysisController.findSrcDstHost ########");   	     
	    	     setTab_2_Text("");
	    	    
	    	 }
	    	 catch (FileNotFoundException e){
	    		 e.printStackTrace();
	    	 }
	    	 }
	    
		/*
	     * Packet data File is Passed, A count of Packets Per Hour is Performed.
	     */
	    @FXML
		public void calcPacketsPerHour(String file) throws  IOException {
	    	System.out.println("Entering calcPacketsPerHour");
            int hoursValue=99;
            int currentHour=99;
            int newHour=99;
            int packetsPerHourCounter[] = new int[24];
            for(int i=0;i<packetsPerHourCounter.length;i++)
           	 packetsPerHourCounter[i] = 0;
            
	    	try (BufferedReader br = new BufferedReader(new FileReader(file))){ 
	             //Skip 1st line in DataFile;
				 br.readLine();
	             String line =null;
	             // Delcare packetManager
	             PacketManager packetManager = new PacketManager();
	             while ((line = br.readLine()) != null) {
	             // process the line.
	             // Initialise encap values from String "line"
	             packetManager.splitString(line);
	             // Return encapsulated StartTime
	             packetManager.getStartTime();
	             // get hoursValue from starttime
	             hoursValue = Integer.valueOf((packetManager.getStartTime()).substring(11, 13));
	             // set currentHour = hoursValue
	             newHour = hoursValue;
	             // Comparison
	             if (currentHour == newHour){
	            	 // Increment Counter Array.
	            	 packetsPerHourCounter[hoursValue]++;
	             }
	             currentHour = newHour;
	             }
			 }
	    		catch (FileNotFoundException e){
	            	 Alert alert = new Alert(AlertType.WARNING);
		             alert.initOwner(mainApp.getPrimaryStage());
		             alert.setTitle("No File");
		             alert.setHeaderText("No Packet File Found");
		             alert.setContentText("Please select another File.");
		             alert.showAndWait();
	            }
	    	 //Set Values to Tab_1: Barchart
	    	 XYChart.Series set1 = new XYChart.Series<>();
	    	 for(int i=0;i<packetsPerHourCounter.length;i++){
	    	   if(packetsPerHourCounter[i]>0){
	    	 set1.getData().add(new XYChart.Data("Time " + i + " Hrs", packetsPerHourCounter[i]));
			 //System.out.println("Time " + i + " Hrs" + "Packets : " + packetsPerHourCounter[i]);
	    		 }else{
	    			 
	    		 }
	    	 }
	    	 
	   
			 somename.getData().addAll(set1);
			 //String green = "-fx-bar-fill: GREEN;";
			 //String blue = "-fx-bar-fill: BLUE;";
			 //String red = "-fx-bar-fill: RED;";
			 
			 somename.lookupAll(".default-color0.chart-bar")
			 .forEach(n -> n.setStyle(barColour));
			 			 
	    }
		
	    public void packetFactory(String fileName) throws IOException{
	    	
	    	  PacketFactory packetFactory = new PacketFactory();
		      
		      //get an object of SENT and call its display method.
		      Packet packet1 = packetFactory.getPacket("SENT");

		      //call draw method of SENT
		      packet1.display();
		      packet1.sentInfo(fileName);

		      //get an object of RECEIVED and call its display method.
		      Packet packet2 = packetFactory.getPacket("RECEIVED");

		      //call draw method of RECEIVED
		      packet2.display();
		      packet2.recInfo(fileName);
	    }
	    
	     /*
	      * Reads a Random line of Text information from a file and passes to the setTab_2_text method for display
	      * 
	      */
	    public void readLineInfoShort(String fileName) throws FileNotFoundException, IOException{
	    	System.out.println("Entering readLineInfoShort");
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
	             //System.out.println(line);
	             PacketManager encap = new PacketManager(line);
	             setTab_2_Text("####### PacketAnalysisController.readLineInfoShort ########");
	    	     setTab_2_Text("Here I've used an Overloaded Constructor \"PacketManager(line)\"");
	    	     setTab_2_Text("to Return some basic Packet information" );
	    	     setTab_2_Text("from a line chosen at Random from the data supplied.");
	    	     setTab_2_Text("{ Source IP: " +encap.getSrcAddr() + " } = { Destination IP: " + encap.getDstAddr() + " }");
	    	     setTab_2_Text("{ Duration: " + encap.getDur() + " Sec } = { Ports Used: " + encap.getSport() + " & " + encap.getDport() + " }");
		         setTab_2_Text("####### PacketAnalysisController.readLineInfoShort ########");   	     
	    	     setTab_2_Text("");
	    	     }
	    	 
	    	 catch (FileNotFoundException e){
	    		 e.printStackTrace();
	    	 }
	    	}
	    
	    /*
	      * Reads all lines of Text information from a file and passes to the setTab_2_text method for display 
	      */
	    public void readLineInfo(String fileName) throws FileNotFoundException, IOException{
	    	 try (BufferedReader br = new BufferedReader(new FileReader(fileName))){ 
	             String line;
	             br.readLine();
	             line = null;
	             while ((line = br.readLine()) != null) {
	              // process the line.
	             //System.out.println(line);
	             PacketManager encap = new PacketManager(line);
	    	     setTab_2_Text("{ Source IP: " +encap.getSrcAddr() + " } = { Destination IP: " + encap.getDstAddr() + " }");
	             setTab_2_Text("{ Duration: " + encap.getDur() + " Sec } = { Ports Used: " + encap.getSport() + " & " + encap.getDport() + " }");
	             }
	    	 }
	    	 catch (FileNotFoundException e){
	    		 e.printStackTrace();
	    	 }
	    	 }
	    
	    /*
	      * Append text to the Tab_2 Window.
	      */
	    public void setTab_2_Text(String text) {
	    	//System.out.println("In SetTab_2" + text);
	        textArea.appendText(text + "\n");
	     } 
	    
	  
	    
	    
	    @FXML
	    private void handleRefresh() {
	    	System.out.println("Refresh Pressed");
	    	//  FileChooser fileChooser = new FileChooser();

		        // Set extension filter
		    //    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
		     //           "Txt files (*.txt)", "*.txt");
		     //   fileChooser.getExtensionFilters().add(extFilter);

		        // Show open file dialog
		   //     File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		        // Pass file to loadPacketDataFromFile if not Null
		  //      if (file != null) {
		 //       	mainApp.loadDataFromFile(file);
		 //       }
	    }
	    
	    @FXML
	    private void handleBack() {
	    	System.out.println("Back Pressed");
	    	//mainApp.showFileSelectOverview();
	    }
	    
	     /*
	      * Reads the File and Constructs the 2-D Array.
	      */
	    public void PacketTime(String string) throws IOException {
	    	 
	    	 int packetsLessThan1Sec = 0;
             int packetsLessThan2Sec = 0;
             int packetsGreaterThan2Sec = 0;
             System.out.println("Entering PacketTime");
	    	 BufferedReader dataBR = new BufferedReader(new FileReader(new File(string)));
	         String line = "";
	         line = dataBR.readLine();
	        		 line = null;
	         // An ArrayList is used because I don't know how many records are in the file.
	         ArrayList<String[]> dataArr = new ArrayList<String[]>(); 
	         // Read a single line from the file until there are no more lines to read
	         while ((line = dataBR.readLine()) != null) { 
	        	 PacketManager packetManager = new MiniPacket(line);
	         	
	               
	             if (isNumeric(packetManager.getDur())){
	            	if (Float.valueOf(packetManager.getDur()) <=1) {
	                 packetsLessThan1Sec++;
	            	} else if (Float.valueOf(packetManager.getDur()) <=2) {
	                 packetsLessThan2Sec++;
	            	} else if (Float.valueOf(packetManager.getDur()) >2) {
	            	 packetsGreaterThan2Sec++;
	            	} 
	             }
	             
	           
	          
	           // dataArr.add(packet); // Add the "Packet" info to the list of Packets.
	         }

	         for (int i = 0; i < dataArr.size(); i++) {
	             for (int x = 0; x < dataArr.get(i).length; x++) {
	                 //System.out.printf("dataArr[%d][%d]: ", i, x);
	                 //System.out.println(dataArr.get(i)[x]);
	             }
	         
	         }
	         System.out.println("Packet Duration Times: ");
	         System.out.println("<1Sec " + packetsLessThan1Sec );
	         System.out.println("<2Sec " + packetsLessThan2Sec);
	         System.out.println(">2Sec " + packetsGreaterThan2Sec);
	         	/*
		    	 * Initialize a Chart and add some values.
		    	 */
		    	XYChart.Series set1 = new XYChart.Series<>();
		    	set1.getData().add(new XYChart.Data("Packet Dur < 1 Sec ", packetsLessThan1Sec));
		    	set1.getData().add(new XYChart.Data("Packet Dur < 2 Sec ", packetsLessThan2Sec));
		    	set1.getData().add(new XYChart.Data("Packet Dur > 2 Sec ", packetsGreaterThan2Sec));
		    	somename.getData().addAll(set1);
	         }
	    
	     
	
	     
	    public boolean isNumeric(String str)  
         {  
           try  
           {  
             double d = Double.parseDouble(str);  
           }  
           catch(NumberFormatException nfe)  
           {  
             return false;  
           }  
           return true;  
         }
}





