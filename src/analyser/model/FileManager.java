package analyser.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


public class FileManager {
	
	//Why store values, only needed during runtime.
	
	/*
	 * Encapsulated properties
	 */
	private final StringProperty FileName;		// 2011/08/10 09:46:59.607825
    private final LongProperty FileSize;			// 1.026539	
    private final StringProperty FilePath;			// 1.026539	
    
    /*
     * Getters
     */
    public String getFileName() {
        return  FileName.get();
    }
    
    public String getFilePath() {
        return  FilePath.get();
    }
    
    public long getFileSize() {
        return  FileSize.get();
    }
    
    /*
     * Setters
     */
    public void setFileName(String  fileNames) {
        this.FileName.set(fileNames);
    }
    
    public void setFilePath(String  filePath) {
        this.FilePath.set(filePath);
    }
    
    public void setFileSize(Long  fileSize) {
        this.FileSize.set(fileSize);
    }
    
    /*
     * 
     */
    public StringProperty FileNameProperty() {
        return FileName;
    }
    
    public LongProperty FileSizeProperty() {
        return FileSize;
    }
    
    public StringProperty FilePathProperty() {
        return FilePath;
    }
    
    
    
    /**
     * Default constructor.
     */
    public FileManager() {
        this(null,0,null);
    }
    
     /**
     * Constructor with some initial data.
     * 
     * @param FileManager
     * @param Size
     * @param Path
     */
    public FileManager(String FileName, long FileSize, String FilePath) {
    	this.FileName = new SimpleStringProperty(FileName);
        this.FileSize = new SimpleLongProperty(FileSize);
        this.FilePath = new SimpleStringProperty(FilePath);
        
        
    }
	
}



