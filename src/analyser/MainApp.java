package analyser;

	import javafx.application.Application;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.stage.Stage;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Scene;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.BorderPane;
	
	import java.io.*;
	import java.io.File;
	import java.util.prefs.Preferences;

//import analyser.model.FileNames;
	import analyser.model.FileManager;
	import analyser.model.PacketManager;
	import analyser.view.FileSelectOverviewController;
	import analyser.view.PacketAnalysisController;

	public class MainApp extends Application{
		
		 /*
	     * Constructor
	     */
	    public MainApp() {
	    // Open app and await user input
	    }
		
	    private Stage primaryStage;
	   
		private BorderPane rootLayout;
	
		/*
         * The data as an observable list of Packets.
	     */
	    //private ObservableList<PacketManager> packetData = FXCollections.observableArrayList();
	    
	    /*
	     * The data as an observable list of FileNames.
	     */
	    private ObservableList<FileManager> fileNameData = FXCollections.observableArrayList();
	   
	    /*
	     * Set the primary stage for the Application
	     * Sets the Title of the Application
	     */	     
	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("Analyser");
	        //Initialize RootLayout and return here for further steps.	  
	        initRootLayout();
	        //Set the FileSelect within the RootLayout	  
	        showFileSelectOverview();
	        
	    }

	    public static void main(String[] args) {
			launch(args);	
		}
		    
	    /*
	     * Sets the RootLayout Within the Stage
	     */
	    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            // Try to load last opened Packet file.
            File file = getLastFilePath();
            if (file != null) {
                loadDataFromFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		    
	    /*
	     *  Populate the FileSelectionOveriew Menu
	     */
	    public void showFileSelectOverview() {
        try {
            // Load FileSelection Overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/FileSelectOverview.fxml"));
            AnchorPane fileSelectOverview = (AnchorPane) loader.load();

            // Set FileSelectOverview into the center of RootLayout.
            rootLayout.setCenter(fileSelectOverview);
            
            // Give the controller access to the main app.
            FileSelectOverviewController controller = loader.getController();
            controller.setMainApp(this);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	   
	    /*
	     * Loads the Deeper Analysis of the Files
	     */
	    public void showPacketAnalysis() {
	        try {
	            // Load Packet overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PacketAnalysis.fxml"));
	            AnchorPane packetAnalysis = (AnchorPane) loader.load();

	            // Set Packet Overview into the center of root layout.
	            rootLayout.setCenter(packetAnalysis);
	            
	            // Give the controller access to the main app.
	            PacketAnalysisController controller = loader.getController();
	            controller.setMainApp(this);

	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /*
	     *  Sets the primary View.
	     */
	    public Stage getPrimaryStage() {
        return primaryStage;
	    }
 	    
	    /*
         * Loads System Data from the Selected file. The current File data will
         * be replaced.
         * 
         * @param file
         */
        public void loadDataFromFile(File file) {
            try {   
                //Persist the newly selected file path to the registry.
                setLastFilePath(file);  
                // Add File Data to the List - fileNameData
                fileNameData.add(new FileManager(file.getName(),file.length(),file.getPath()));
                //System.out.println(file.getName());
                //System.out.println(file.length());
                //System.out.println(file.getPath());
                
            	} catch (Exception e) { // catches ANY exception
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Could not load data");
                alert.setContentText("Could not load data from file:\n" + file.getPath());
                alert.showAndWait();
            }
        }
        
        // Returns the data as an observable list of FileNames.      
	    public ObservableList<FileManager> getFileNamesData() {
		        return fileNameData;
	    }
        
	    /*
         * Returns the Packet file preference, i.e. the file that was last opened.
         * The preference is read from the OS specific registry. If no such
         * preference can be found, null is returned.
         * 
         * @return
         */
        public File getLastFilePath() {
        	Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
            String filePath = prefs.get("filePath", null);
            if (filePath != null) {
                return new File(filePath);
            } else {
                return null;
            }
        }
             
        /*
         * Sets the file path of the currently loaded file. The path is persisted in
         * the OS specific registry.
         * 
         * @param file the file or null to remove the path
         */
        public void setLastFilePath(File file) {

	        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
	        if (file != null) {
	            prefs.put("filePath", file.getPath());

	            // Update the stage title.
	            primaryStage.setTitle("Analyse - " + file.getName());
	        } else {
	            prefs.remove("filePath");

	            // Update the stage title.
	            primaryStage.setTitle("AddressApp");
	        }
	    }

        /* 
         *  Returns the b/Kb/Mb Value from the Total byte count for the File  
	     */
        public static String humanReadableByteCount(long bytes, boolean si) {
		    int unit = si ? 1000 : 1024;
		    if (bytes < unit) return bytes + " B";
		    int exp = (int) (Math.log(bytes) / Math.log(unit));
		    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
		    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
		}

}
