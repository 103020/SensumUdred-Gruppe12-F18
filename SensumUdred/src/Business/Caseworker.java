/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import Data.DataFacade;

/**
 *
 * @author Nicolai
 */
public class Caseworker implements ICaseworker{ 

    private String name;
    private IDepartment department;
    private String employeeID; 
    private ICase cas;
    private Meeting meeting;
    IBusiness businessFacade;
    
    @Override
    public boolean accessCase(int caseNumber, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        ILog log = new Log(this, this);
        cas = new Case(individualName, individualAddress,individualCPR, log, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
        cas.setCaseNumber(cas.saveCase(log));
    }
    
    
    @Override
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants){
        meeting.messageToMeeting();
        ILog log = new Log(this, (ICaseworker) this);
        meeting = new Meeting(year, month, day, hour, minute, location, participants, log);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDepartment(IDepartment department) {
        this.department = department;
    }

    @Override
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID; 
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IDepartment getDepartment() {
        return department;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }
}
