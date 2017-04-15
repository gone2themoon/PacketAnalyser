package analyser.model;

public class PacketManager {
   //
   private  String StartTime;		// 2011/08/10 09:46:59.607825
   private  String Dur;				// 1.026539	
   private  String Proto;			// tcp
   private  String SrcAddr;			// 94.44.127.113
   private  String Sport;			// 1577
   private  String Dir;				//    ->
   private  String DstAddr;			// 147.32.84.59
   private  String Dport;			// 6881
   private  String State;			// S_RA
   private  String sTos;			// 0
   private  String dTos;			// 0
   private  String TotPkts;			// 4
   private  String TotBytes;		// 276
   private  String SrcBytes;		// 156
   private  String Label;			// flow=Background-Established-cmpgw-CVUT

   /*
    * Contructor Overloading
    */
   public PacketManager(String line){
	   // initialize all Packet Paramaters from input "line"
	   splitString(line);
   }
   
   
   /*
    * Contsructor with 0 Args
    */
   public PacketManager() {
	
}



    /*
    * Getters and Setters for Private Variables
    */
   public String getStartTime() {
	return StartTime;
   }

   public void setStartTime(String startTime) {
	StartTime = startTime;
   }

   public String getDur() {
	return Dur;
   }

   public void setDur(String dur) {
	Dur = dur;
   }

   public String getProto() {
	return Proto;
   }

   public void setProto(String proto) {
	Proto = proto;
   }

   public String getSrcAddr() {
	return SrcAddr;
   }

   public void setSrcAddr(String srcAddr) {
	SrcAddr = srcAddr;
   }

   public String getSport() {
	return Sport;
   }

   public void setSport(String sport) {
	Sport = sport;
   }

   public String getDir() {
	return Dir;
   }

   public void setDir(String dir) {
	Dir = dir;
   }

   public String getDstAddr() {
	return DstAddr;
   }

   public void setDstAddr(String dstAddr) {
	DstAddr = dstAddr;
   }

   public String getDport() {
	return Dport;
   }

   public void setDport(String dport) {
	Dport = dport;
   }

   public String getState() {
	return State;
   }

   public void setState(String state) {
	State = state;
   }

   public String getsTos() {
	return sTos;
   }

   public void setsTos(String sTos) {
	this.sTos = sTos;
   }

   public String getdTos() {
	return dTos;
   }

   public void setdTos(String dTos) {
	this.dTos = dTos;
   }

   public String getTotPkts() {
	return TotPkts;
   }

   public void setTotPkts(String totPkts) {
	TotPkts = totPkts;
   }

   public String getTotBytes() {
	return TotBytes;
   }

   public void setTotBytes(String totBytes) {
	TotBytes = totBytes;
   }

   public String getSrcBytes() {
	return SrcBytes;
   }

   public void setSrcBytes(String srcBytes) {
	SrcBytes = srcBytes;
   }

   public String getLabel() {
	return Label;
   }

   public void setLabel(String label) {
	Label = label;
   }

   public void splitString(String string){
	   //String line = "";
	   //System.out.println("in splitstring"+ string);
       String cvsSplitBy = ",";
       String[] frame = string.split(cvsSplitBy);
       
       setStartTime(frame[0]);
       setDur(frame[1]);
       setProto(frame[2]);
       
       setSrcAddr(frame[3]);
       setSport(frame[4]);
       setDir(frame[5]);
       
       setDstAddr(frame[6]);
       setDport(frame[7]);
       setState(frame[8]);
       
       setsTos(frame[9]);
       setdTos(frame[10]);
       setTotPkts(frame[11]);
       
       setTotBytes(frame[12]);
       setSrcBytes(frame[13]);
       setLabel(frame[14]);
       
       //System.out.println(getStartTime());
   }

   /*
    * Sample Encapsulated Method. 
    */
   public void getSourceDest(String string){
	   
	   splitString(string);
	   System.out.println("Source = " + getSrcAddr() + " Destination = " + getDstAddr());
	   
   }
  
   
}