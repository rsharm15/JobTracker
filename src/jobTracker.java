/*
 *  Rahul Sharma
    2/25/15
    IT 206-001
    Assignment 4-IMPLEMENTATION CLASS
 * DESCRIPTION: This class will be ask whether if the user wants to add a job, display all jobs, find the 
 * highest paying offer or exit the program. If the user decides to add a job, he/she will be prompted for 
 * the company name, recruiter name, miles from home and the job status. It job status entered by the user 
 * is 4, the user is also asked for the offer amount. Picking the second option (display all jobs) will 
 * list the company name, recruiter name, miles from home, job status and if the job status is 4, the offer 
 * amount will be display for all the jobs. Option 3, find highest paying salary will find the job that 
 * pays the most and display the company name, recruiter name and the offer amount that correlates with that 
 * job. The 4th option will simply end the program. After doing any of the first there actions (add a job, 
 * display all jobs, and find highest paying), the user is prompted for one of the choices add a job, display 
 * all jobs, find highest paying until the user chooses to exit the program.  
 */
import javax.swing.JOptionPane;
public class jobTracker {
public static void main(String[] args) {
        final int MAX_JOBS = 50;
        final int EXIT_MENU_CHOICE =4;
        //allocating space for 50 objects
        job[] allJobs = new job[MAX_JOBS];
        //getting the menuChoice between the value of 1 and 4
        int menuChoice = getMenuChoice();   
        /*
         * A while loop that keep asking the user for the option 1 to 4, 1 = add jobs, 2 = display all jobs 
         * 3 = findHighestPayingJobs and 4 to exit the program. After doing each of those tasks, the user will
         * be prompted for those options till the user decides to exit the program. 
         */
        while(menuChoice!= EXIT_MENU_CHOICE){
            switch(menuChoice){
            //if menuChoice is 1, a job is added at a time
            case 1:
                addAJob(allJobs);
                break;
              /*
               * if menuChoice is 2, for all the jobs that have been added, compName, recName, milesFromHome, 
               * jobStatus and offerReceived if the jobStatus is 4
               */
            case 2:
                displayAllJobs(allJobs);
                break;
                /*
                   * if menuChoice is 3, the job(s) that has the highest offer amount will be displayed with the compName and the recName
                   */
            case 3:
                findHighestPayingJob(allJobs);
                break;
            default:
                 JOptionPane.showMessageDialog(null, "unknown error");
            }
             
        //the user is prompted once again for the 1-4 options
        menuChoice = getMenuChoice();
        }
 
/*
    Method Name:    getMenuChoice
    Purpose:        This method asks for a menuChoice. 1 = addJobs, 2 = displayAllJobs, 3 = findHighestPayingJob, 4 = exit program
    Return Value:   (int) menuChoice
    Parameters:     none
*/     
}
private static int getMenuChoice(){
    int menuChoice = 0;
    final int LOWEST_MENU_CHOICE =1;
    final int HIGHEST_MENU_CHOICE =4;
     
    do{
        try{
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(null,"-----------------------------------MAIN MENU-------------------------------\n"+
            "\n1 - Add a Job"+
            "\n2 - Display all jobs"+
            "\n3 - Find Highest Paying Job"+
            "\n4 - Exit Program"+
            "\nPlease enter the number of the operation you want to perform"));
            if(menuChoice<1 || menuChoice > 4){
                JOptionPane.showMessageDialog(null, " THE INPUT MUST BE BETWEEN 1 AND 4");
            }
            
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"ERROR!!!!The menu choice must be numeric. PLEASE RE-ENTER");
        }
    }while(menuChoice < LOWEST_MENU_CHOICE || menuChoice > HIGHEST_MENU_CHOICE);
    return menuChoice;
}
 
/*
Method Name:    addAJob
Purpose:        This method asks for the compName, recName, milesFromHome, jobStatus and the offerAmt if the 
                jobStatus is 4.Then an job object is created with those values and stored in an array 
Return Value:   void
Parameters:     job[] allJobs
*/ 
private static void addAJob(job[] allJobs) {
    int pos = job.getNumOfJobs();
    String compName ="";
    String recName ="";
    double milesFromHome = 0;
    int jobStatus=0;
    final int JOB_STATUS_FOUR =4;
    double offerAmt =0;
    if(allJobs.length > pos){
        compName = getCompName();
        recName = getRecName();
        milesFromHome = getMilesFromHome();
        jobStatus = getJobStatus();
        if(jobStatus == JOB_STATUS_FOUR){
            offerAmt = getOfferAmt();
            allJobs[pos] = new job(compName, recName, milesFromHome, jobStatus, offerAmt);
        }
        else{
            allJobs[pos] = new job(compName, recName, milesFromHome, jobStatus);
        }
    }
    else{
        JOptionPane.showMessageDialog(null,"The number of jobs is full. It has reached it's limit of 50");
    }
}
 
/*
Method Name:    displayAllJobs
Purpose:        This method runs through all the job objects in the array and displays their compName, recName,
                milesFromHome, jobStatus and offerReceived if the jobStatus is 4. 
Return Value:   void
Parameters:     job[] allJobs
*/ 
private static void displayAllJobs(job[] allJobs) {
    String output;
    final int NO_JOBS =0;
    if(job.getNumOfJobs()==NO_JOBS){
        output = "There aren't any jobs";
    }
    else{
     output = "                                                                                                          ALL JOBS                                                                                                                 \n" +
                     "COMPANY NAME--------------RECRUITER NAME--------------MILES FROM HOME-----------------------JOB STATUS-----------------------OFFER RECEIVED\n";
    for(int pos =0; pos<job.getNumOfJobs(); pos++){
        output+=allJobs[pos].toString() + "\n";
    }
    }
    JOptionPane.showMessageDialog(null, output);
}
 
/*
Method Name:    findHighestPayingJob
Purpose:        This method runs through all the job objects in the array and displays and checks which job has
                the highest offerReceived. Then it displays the compName, recName and offerReceived for all the 
                jobs with that highest value. 
Return Value:   void
Parameters:     job[] allJobs
*/ 
private static void findHighestPayingJob(job[] allJobs) {
        int jobsWithoutOffer =0;
        final int JOB_STATUS_FOUR =4;
        double highestPayingValue =0;
        String message = "-------------------------------HIGHEST PAYING JOB(s)-------------------------------\n"
                +"COMPANY NAME                     RECRUITER'S NAME                          OFFER AMOUNT\n";
        for(int index = 0; index<job.getNumOfJobs(); index++){
            if(allJobs[index].getJobStatus() != JOB_STATUS_FOUR){
                jobsWithoutOffer++;
            }   
            else{
                if(allJobs[index].getOfferReceived() > highestPayingValue){
                   highestPayingValue = allJobs[index].getOfferReceived();
                }
            }
        }
         
        if(jobsWithoutOffer == job.getNumOfJobs()){
            message = "None of the jobs have an offer amount";
        }
        else{
            for(int count =0; count < job.getNumOfJobs(); count++){
                if(highestPayingValue==allJobs[count].getOfferReceived()){
                    message += String.format("%15s%52s%52s", allJobs[count].getCompName(),allJobs[count].getRecName(),highestPayingValue+"\n" );
                }
            }
        }
        JOptionPane.showMessageDialog(null, message);
}
 
/*
Method Name:    getCompName
Purpose:        This method asks for the name of the company
Return Value:   (String) compName
Parameters:     none
*/
private static String getCompName(){
    String compName;
    do{
        compName = JOptionPane.showInputDialog(null, "Enter COMPANY'S NAME?");
        if(compName.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter a valid comp name");
        }
    }while(compName.equals(""));
    return compName;
}
 
/*
Method Name:    getRecName
Purpose:        This method asks for the name of the recruiter
Return Value:   (String) recName
Parameters:     none
*/
private static String getRecName(){
    String recName;
    do{
        recName= JOptionPane.showInputDialog(null, "Enter RECRUITER'S NAME?");
        if(recName.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter a valid comp name");
        }
    }while(recName.equals(""));
    return recName;
}
 
/*
Method Name:    getMilesFromHome
Purpose:        This method asks for the number of miles from home
Return Value:   (double) milesFromHome
Parameters:     none
*/
private static double getMilesFromHome(){
    double milesFromHome= 0;
    final int LOWEST_VAL = 0;
    do{
    try{
        milesFromHome = Double.parseDouble(JOptionPane.showInputDialog("Enter miles from home"));
        if(milesFromHome<= LOWEST_VAL){
            JOptionPane.showMessageDialog(null, "THE MILES MUST BE MORE THAN 0");
        }
    }
    catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"ERROR!!!!Miles from home must be numeric. PLEASE RE-ENTER");
    }
    }while(milesFromHome <= LOWEST_VAL);
    return milesFromHome;
}
 
/*
Method Name:    getJobStatus
Purpose:        This method asks for the status of the job
Return Value:   (int) jobStatus
Parameters:     none
*/
private static int getJobStatus(){
    int jobStatus=0;
    final int LOWEST_MENU_CHOICE =1;
    final int HIGHEST_MENU_CHOICE =4;
    do{
    try{
        jobStatus  = Integer.parseInt(JOptionPane.showInputDialog(null,"-----------------------------------JOB STATUS-------------------------------\n"+
                "\n1 - Waiting for phone interview"+
                "\n2 - Waiting for in-person interview"+
                "\n3 - Waiting for offer"+
                "\n4 - Offer received"));
        if(jobStatus< LOWEST_MENU_CHOICE || jobStatus > HIGHEST_MENU_CHOICE){
            JOptionPane.showMessageDialog(null, " THE INPUT MUST BE BETWEEN 1 AND 4");
        }
    }
    catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"ERROR!!!!Job status must be numeric. PLEASE RE-ENTER");
    }
    }while(jobStatus < LOWEST_MENU_CHOICE || jobStatus >HIGHEST_MENU_CHOICE);
    return jobStatus;
}
 
/*
Method Name:    getOfferAmt
Purpose:        This method asks for the offer amount 
Return Value:   (double) offerAmt
Parameters:     none
*/
private static double getOfferAmt(){
    double offerAmt =0;
    final int LOWEST_OFFER_VAL = 0;
    do{
    try{
        offerAmt = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the offer amount"));
        if(offerAmt<=0){
            JOptionPane.showMessageDialog(null, " THE INPUT MUST BE MORE THAN 0");
        }
    }
    catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"ERROR!!!!Job offer amount must be numeric. PLEASE RE-ENTER");
    }
    }while(offerAmt<=LOWEST_OFFER_VAL);
    return offerAmt;
}
}