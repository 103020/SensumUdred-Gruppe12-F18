/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author stefan
 */
public interface IBusiness {
    
    /**
     * 
     * @return returns the number of the case
     */
    public int getCaseNumber();
    
    /**
     * 
     * @return returns the caseworker
     */
    public ICaseworker getCaseworker();
    
    /**
     * 
     * @return returns the individual
     */
    public IIndividual getIndividual();
    
    /**
     * 
     * @return returns the caseNumber
     */
    public int saveCase();
    
    /**
     * 
     * @return returns the creation date of the case
     */
    public String getCaseCreationDate();
    
    /**
     * 
     * @param ca take a case to be edited
     */
    public void editCase(ICase ca);
    
    public void closeCase();
    
    /**
     * 
     * @param caseNumber the number of the case
     * @return returns a case
     */
    public ICase accessCase(int caseNumber);
    
    /**
     * 
     * @param individualName The name of the individual the case is about
     * @param individualAddress The address of the individual the case is about
     * @param individualCPR The CPR of the individual the case is about
     * @param _inquiry The inquiry of the case
     * @param _individualInvolvement The text of the individual involvement
     * @param individualUnderstanding The individual's consent to the inquiry
     * @param consent The individuals consent to get relevant data
     * @param writtenConsent The individual consent as written
     * @param oralConsent The individual consent as oral
     * @param caseClarity Is it clear what the individual seeks?
     * @param inquiryFrom The source of the inquiry, who made the inquiry
     * @param caseFromAdress The Address of the source, the address of who made the inquiry
     */
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress);
    
    /**
     *
     * @param year of the meeting 
     * @param month of the meeting 
     * @param day of the meeting
     * @param hour of the meeting 
     * @param minute of the meeting 
     * @param location the addresse the meeting is taking place at
     * @param participants the names of the participants
     */
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants);
    /**
     * 
     * @param name sets the name of the employee
     */
    public void setEmployeeName(String name);
    
    /**
     * 
     * @param department sets the department of the employee
     */
    public void setEmployeeDepartment(IDepartment department);
    
    /**
     * 
     * @param employeeID  sets the ID of the employee
     */
    public void setEmployeeID(int employeeID);
    
    /**
     * 
     * @return returns the name of the employee
     */
    public String getEmployeeName();
   
    /**
     * 
     * @return returns the department of the employee
     */
    public String getEmployeeDepartment();
    
    /**
     * 
     * @return returns the ID of the employee
     */
    public String getEmployeeID();
    
    /**
     * 
     * @param time sets the time and date of the meeting
     */
    public void setMeetingTime(LocalDateTime time);
    
    /**
     * 
     * @param participants sets the participants of the meeting
     */
    public void setMeetingParticipants(String participants);
    
    /**
     * 
     * @return returns the time of the meeting
     */
    public LocalDateTime getMeetingTime();
    
    /**
     * 
     * @return returns the participants of the meeting
     */
    public String getMeetingParticipants();
    
    /**
     * 
     * @return returns the name of the individual
     */
    public String getIndividualName();
    
    /**
     * 
     * @return returns the address of the individual
     */
    public String getIndividualAddress();
    
    /**
     * 
     * @return returns the CPR of the individual
     */
    public int getIndividualCPR();
    
    /**
     * 
     * @param name sets the name of the individual
     */
    public void setIndividualName(String name);
    
    /**
     * 
     * @param address sets the address of the individual
     */
    public void setIndividualAddress(String address);
    
    /**
     * 
     * @param CPR sets the CPR of the individual
     */
    public void setIndividualCPR(int CPR);
    
    /**
     * 
     * @return returns a list of cases sorted after date
     */
    public List getDateSortedList();
    
    /**
     * 
     * @return returns a list of cases sorted after case number
     */
    public List getCasenumSortedList();
    
    
    /**
     *
     * @return the location of the meeting
     */
    public String getLocation();
    
    /**
     *
     * @param username the name of the user logging in
     * @param password of the user
     * @return
     */
    public boolean login(String username, String password);
    
    /**
     *
     * @param caseNum is the casenumber the meeting is on
     * @param message is what is send when a meeting is created
     */
    public void messageToMeeting(int caseNum, String message);
    
    public void setFacadeCase(int caseNumber);

    public void createMeeting();
}
