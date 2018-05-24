/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import Data.DataFacade;
import java.time.LocalDateTime;

/**
 *
 * @author Nicolai
 */
public class Caseworker implements ICaseworker{ 

    private String name;
    private Department department;
    private String employeeID; 
    private Case cas;
    IBusiness businessFacade;
    
    Caseworker(String name, Department department, String employeeID, String caseworkerPassword, String caseworkerUsername ){
        this.name = name;
        this.department = department;
        this.employeeID = employeeID;
    }

    public boolean accessCase(int caseNumber, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TO DO: Stefan fix
    }

    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        ILog log = new Log(this, this);
        cas = new Case(individualName, individualAddress,individualCPR, log, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
        cas.setCaseNumber(cas.saveCase(log));
    }
    
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants){
        ILog log = new Log(this, (ICaseworker) this);
        //TODO: change method call argument list.
        cas.createMeeting(year, month, day, hour, minute, location, this, participants, log);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

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

    public String cancelMeeting() {
        return cas.cancelMeeting();
    }

    public String setMeetingTime(LocalDateTime time) {
        return cas.setMeetingTime(time);
    }

    public String setMeetingLocation(String Location) {
        return cas.setMeetingLocation(Location);
    }

    public String setMeetingParticipants(String participants) {
        return cas.setMeetingParticipants(participants);
    }

    public void setIndividualName(String name) {
        ILog log = new Log(this, this);
        cas.setIndividualName(name, log);
    }

    public void setIndividualAddress(String Address) {
        ILog log = new Log(this, this);
        cas.setIndividualAddress(Address, log);
    }

    public void setIndividualCPR(int CPR) {
        ILog log = new Log(this, this);
        cas.setIndividualCPR(CPR, log);
    }

    public ICaseworker getCaseworkerFormCase() {
        return cas.getCaseworker();
    }

    public IMeeting getMeeting() {
        return cas.getMeeting();
    }

    public IIndividual getIndividual() {
        return cas.getIndividual();
    }
}
