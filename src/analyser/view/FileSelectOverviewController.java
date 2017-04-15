package analyser.view;

	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Label;
	import javafx.scene.control.Labeled;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableColumnBase;
	import javafx.scene.control.TableView;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.control.Button;
	import javafx.scene.layout.AnchorPane;
	import javafx.stage.FileChooser;

	import java.io.File;
	import java.io.IOException;
	import java.util.prefs.Preferences;

	import analyser.MainApp;
	import analyser.model.FileManager;
	import analyser.model.PacketManager;



	public class FileSelectOverviewController {
	
		/*
		 * Data Handling of File Name for TableView.
		 */
		@FXML
	    private TableView<FileManager> fileNamesTable;
	   
	    @FXML
	    private TableColumn<FileManager, String> fileNameColumn;
	    
	    @FXML
	    private Label fileSize;
	
	    @FXML
	    private Label filePath;
	    
	    @FXML
	    private Label fileName;
	    
	    public static String selectedFile;
	     
	    /*
	     * Opens a FileChooser to let the user select a Packet File to load.
	     */
	    @FXML
	    private void handleOpen() {
	        FileChooser fileChooser = new FileChooser();

	        // Set extension filters
	         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                 "Txt files (*.txt)", "*.txt");
	         fileChooser.getExtensionFilters().add(extFilter);
	         FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter(
	    	                "Binetflow files (*.binetflow)", "*.binetflow");
	         fileChooser.getExtensionFilters().add(extFilter1);
	        

	        // Show open file dialog
	        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

	        // Pass file to loadPacketDataFromFile if not Null
	        if (file != null) {
	        	mainApp.loadDataFromFile(file);
	        }
	    }
	    
	    /*
	     * Called when the user clicks on the Analyze button.
	     * @throws IOException 
	     */
	    @FXML
	    private void handleAnalyse() throws IOException {
	   	 int selectedIndex = fileNamesTable.getSelectionModel().getSelectedIndex();
	         if (selectedIndex >= 0) {
	        		        	 
	        	mainApp.showPacketAnalysis();
	        		        	
	        	
	        	// String getFilename = filemanager.getFilePath();  
	        	 
	        	 //System.out.println("Send Selected file to be analysed: " + getFilename);
	        	 
	        	 //FileRead fileRead = new FileRead();
	        	
	        	 //fileRead.display(getFilename);
	        	 //System.out.println(fileNamesTable.getSelectionModel());
	        	 
	        	 
	        	
	        	 
	        	 
	        	 
	         } else {
	             // Nothing selected.
	             Alert alert = new Alert(AlertType.WARNING);
	             alert.initOwner(mainApp.getPrimaryStage());
	             alert.setTitle("No Selection");
	             alert.setHeaderText("No Packet File Selected");
	             alert.setContentText("Please select a Packet File in the table.");
	             alert.showAndWait();
	        }
	         
	    }
	    	
		/*
	     * Called when the user clicks on the delete button.
	     */
	    @FXML
	    private void handleDelete() {
	        int selectedIndex = fileNamesTable.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            fileNamesTable.getItems().remove(selectedIndex);
	        } else {
	            // Nothing selected.
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Packet File Selected");
	            alert.setContentText("Please select a Packet File in the table.");

	            alert.showAndWait();
	        }
	    }
	    
	    /*
	     *  Reference to the main application.
	     */
	    private MainApp mainApp;

	    /*
	     * The constructor.
	     * The constructor is called before the initialize() method.
	     */
	    public FileSelectOverviewController() {
	    }
	    
	    /*
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML
	    private void initialize() {
	        // Initialize the FileName table with single Column.
	        fileNameColumn.setCellValueFactory(cellData -> cellData.getValue().FileNameProperty());
	        
	        // Clear File details.
	        showFileDetails(null);
	        
	        // Listen for selection changes and show the File details when changed.
	        fileNamesTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showFileDetails(newValue));
	    }

	    /*
	     * Is called by the main application to give a reference back to itself.
	     * 
	     * @param mainApp
	     */
	    public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;
	        /*
	         *  Add observable list data to the table
	         */
	        fileNamesTable.setItems(mainApp.getFileNamesData());
	    }

	    public void showFileDetails(FileManager fileNames) {
	        if (fileNames != null) {
	            // Fill the labels with info from the FileName object.
	        	fileSize.setText(MainApp.humanReadableByteCount(fileNames.getFileSize(), true));
	        	filePath.setText(fileNames.getFilePath());
	        	selectedFile = fileNames.getFilePath();
	        	fileName.setText(fileNames.getFileName());
	      
	        } else {
	            // FileName is null, remove all the text.
	        	fileSize.setText("");
	        	filePath.setText("");
	            fileName.setText("");
	           
	        }
	    }
	    
	}
