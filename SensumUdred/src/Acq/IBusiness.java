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
     * @return 
     */
    public int getCaseNumber();
    /**
     * 
     * @return 
     */
    public ICaseworker getCaseWorker();
    /**
     * 
     * @return 
     */
    public IIndividual getIndividual();
    /**
     * 
     * @return 
     */
    public boolean saveCase();
    /**
     * 
     * @return 
     */
    public String getCaseCreationDate();
    /**
     * 
     * @param ca 
     */
    public void editCase(ICase ca);
    public void createMeeting();
    public void closeCase();
    /**
     * 
     * @return 
     */
    public ICase accessCase();
    /**
     * 
     * @param caseType The type of case
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
     * @param inquiryFrom The source of the inquiry
     * @param caseFromAdress The Address of the source
     */
    public void createCase(String caseType, String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress);
    /**
     * 
     * @param name 
     */
    public void setEmployeeName(String name);
    /**
     * 
     * @param department 
     */
    public void setEmployeeDepartment(String department);
    /**
     * 
     * @param employeeID 
     */
    public void setEmployeeID(int employeeID);
    /**
     * 
     * @return 
     */
    public String getEmployeeName();
    /**
     * 
     * @return 
     */
    public String getEmployeeDepartment();
    /**
     * 
     * @return 
     */
    public String getEmployeeID();
    /**
     * 
     * @param time 
     */
    public void setMeetingTime(LocalDateTime time);
    /**
     * 
     * @param participants 
     */
    public void setMeetingParticipants(String participants);
    /**
     * 
     * @return 
     */
    public LocalDateTime getMeetingTime();
    /**
     * 
     * @return 
     */
    public String getMeetingParticipants();
    /**
     * 
     * @return 
     */
    public String getIndividualName();
    /**
     * 
     * @return 
     */
    public String getIndividualAddress();
    /**
     * 
     * @return 
     */
    public int getIndividualCPR();
    /**
     * 
     * @param name 
     */
    public void setIndividualName(String name);
    /**
     * 
     * @param address 
     */
    public void setIndividualAddress(String address);
    /**
     * 
     * @param CPR 
     */
    public void setIndividualCPR(int CPR);
    /**
     * 
     * @return 
     */
    public List getDateSortedList();
    /**
     * 
     * @return 
     */
    public List getCasenumSortedList();
    public void createCase();
}
