/* Rahul Sharma
	2/25/15
	IT 206-001
	Assignment 4-DATA DEFENITION CLASS
 * This class will store the name of the company, the name of the recruiter, how many miles the job is 
 * from home, and the job status. It the job status is 4, the offer amount for the job is stored also. 
 */

public class job {
	private String compName;
	private String recName;
	private double milesFromHome;
	private int jobStatus;
	private double offerReceived;
	private static int numOfJobs;
	
	/*
	 * The default constructor which passes the value null, null, 0 , 0 , 0 to the constructor that accepts
	 * String, String, double, int and double. 
	 */
	public job(){
		this(null,null,0,0,0);
	}
	
	/*
	 * The specific constructor that accepts compName, recName, milesFromHome and jobStatus and sets the 
	 * instance variable to those values. Afterwards, the numOfJobs is incremented by 1.
	 */
	public job(String compName, String recName, double milesFromHome, int jobStatus){
		this.compName = compName;
		this.recName = recName;
		this.milesFromHome = milesFromHome;
		this.jobStatus = jobStatus;
		numOfJobs++;
	}
	
	/*
	 * The specific constructor that accepts compName, recName, milesFromHome ,jobStatus and offerReceived 
	 * and sets the instance variable to those values. Afterwards, the numOfJobs is incremented by 1.
	 */
	public job(String compName, String recName, double milesFromHome, int jobStatus, double offerReceived){
		this.compName = compName;
		this.recName = recName;
		this.milesFromHome = milesFromHome;
		this.jobStatus = jobStatus;
		this.offerReceived = offerReceived;
		numOfJobs++;
	}
	/*
	Method Name:	setCompName
	Purpose:		This method sets the instance compName to userCompName(the value sent in from the implementation class)
	Return Value:	void
	Parameters:		(String) userCompName
	*/
	public void setCompName(String userCompName){	this.compName = userCompName;}
	
	/*
	Method Name:	setRecName
	Purpose:		This method sets the instance recName to userRecName(the value sent in from the implementation class)
	Return Value:	void
	Parameters:		(String) userRecName
	*/
	public void setRecName(String userRecName){this.recName = userRecName;}
	
	/*
	Method Name:	setMilesFromHome
	Purpose:		This method sets the instance milesFromHome to userMiles(the value sent in from the implementation class)
	Return Value:	(boolean) 
	Parameters:		(double) userMiles
	*/
	public boolean setMilesFromHome(double userMiles){
	
		if(userMiles<=0){
			return false;
		}
		else{
			this.milesFromHome = userMiles;
			return true;
		}
		
	}
	
	/*
	Method Name:	setJobStatus
	Purpose:		This method sets the instance jobStatus to userJobStatus(the value sent in from the implementation class)
	Return Value:	boolean
	Parameters:		(String) userJobStatus
	*/
	public boolean setJobStatus(int userJobStatus){ 
		
		if(userJobStatus< 1 || userJobStatus > 4){
			return false;
		}
		else{
			this.jobStatus = userJobStatus;
			return true;
		}
	}
	
	/*
	Method Name:	setOfferReceived
	Purpose:		This method sets the instance offerReceived to userOffer(the value sent in from the implementation class)
	Return Value:	boolean
	Parameters:		(String) userOffer
	*/
	public boolean setOfferReceived(double userOffer){
		
		if(userOffer<=0){
			return false;
		}
		else{
			this.offerReceived = userOffer;
			return true;
		}
	}
	
	/*
	Method Name:	getNumOfJobs
	Purpose:		This method returns the static variable numOfJobs 
	Return Value:	(int) numOfJobs
	Parameters:		none
	*/
	public static int getNumOfJobs() {return numOfJobs;}
	
	/*
	Method Name:	getCompName
	Purpose:		This method returns the compName 
	Return Value:	(String) compName
	Parameters:		none
	*/
	public String getCompName(){return this.compName;}
	
	/*
	Method Name:	getRecName
	Purpose:		This method returns the recName 
	Return Value:	(String) recName
	Parameters:		none
	*/
	public String getRecName(){return this.recName;}
	
	/*
	Method Name:	getMilesFromHome
	Purpose:		This method returns the milesFromHome
	Return Value:	(double) milesFromHome
	Parameters:		none
	*/
	public double getMilesFromHome(){return this.milesFromHome;}
	
	/*
	Method Name:	getJobStatus
	Purpose:		This method returns the jobStatus
	Return Value:	(int) jobStatus
	Parameters:		none
	*/
	public int getJobStatus(){return this.jobStatus;}
	
	/*
	Method Name:	getOfferReceived
	Purpose:		This method returns the offerReceived
	Return Value:	(double) offerReceived
	Parameters:		none
	*/
	public double getOfferReceived(){return this.offerReceived;}
	
	/*
	Method Name:	toString
	Purpose:		This method returns a message consisting of compName, recName, milesFromHome, jobStatus 
	and the offerAmt only if the jobStatus is 4. 
	Return Value:	(String) message
	Parameters:		none
	*/
	public String toString(){
		String message = compName+"                                            "+ recName+ "                                            "+ milesFromHome+ "                                     ";
                
                if(this.jobStatus == 1){
                	message+= "Waiting for phone interview"; 	
                }
                else if(this.jobStatus ==2){
                	message+="Waiting for in-person interview";
                }
                else if(this.jobStatus == 3){
                	message += "Waiting for offer";
                }
                else{
                	message += "Offer Received                                 "+ offerReceived;
                } 
                               
		return message;
	}
}
