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
public interface IGUI {

    /**
     *
     * @return
     */
    public int saveCase();

    /**
     *
     * @param ca
     */
    public void editCase(ICase ca);


    public void closeCase();

    /**
     *
     * @return
     */
    public ICase accessCase();

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
     * @param time
     * @param location
     */
    public void createMeeting(LocalDateTime time, String location);
    
    /**
     *
     * @param name set the name of the employee
     */
    public void setEmployeeName(String name);

    /**
     *
     * @param department set the employeedepartment
     */
    public void setEmployeeDepartment(String department);

    /**
     *
     * @param employeeID set the employeeID 
     */
    public void setEmployeeID(int employeeID);

    /**
     *
     * @param time set the time of the meeting
     */
    public void setMeetingTime(LocalDateTime time);

    /**
     *
     * @param participants set the participants of the meeting
     */
    public void setMeetingParticipants(String participants);

    /**
     *
     * @param name set the individual name 
     */
    public void setIndividualName(String name);

    /**
     *
     * @param address set the individual name
     */
    public void setIndividualAddress(String address);

    /**
     *
     * @param CPR set the CPR/personal number for the individual
     */
    public void setIndividualCPR(int CPR);

    /**
     *
     * @return the individual name
     */
    public String getIndividualName();

    /**
     *
     * @return the individual address
     */
    public String getIndividualAddress();

    /**
     *
     * @return the individual CPR
     */
    public int getIndividualCPR();

    /**
     *
     * @return the caselist
     */
    public List getCaseList();

    /**
     *
     * @return the meeting time
     */
    public LocalDateTime getMeetingTime();

    /**
     *
     * @param username the username of the login
     * @param password the password of the login
     * @return the login
     */
    public boolean login(String username, String password);

    /**
     *
     * @param caseNumber set the facade case with the casenumber
     */
    public void setFacadeCase(int caseNumber);
}
