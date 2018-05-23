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
    private IDepartment department;
    private String employeeID; 
    private ICase cas;
    IBusiness businessFacade;
    
    Caseworker(String name, IDepartment department, String employeeID, String caseworkerPassword, String caseworkerUsername ){
        this.name = name;
        this.department = department;
        this.employeeID = employeeID;
    }
    
    @Override
    public boolean accessCase(int caseNumber, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TO DO: Stefan fix
    }

    @Override
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        ILog log = new Log(this, this);
        cas = new Case(individualName, individualAddress,individualCPR, log, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
        cas.setCaseNumber(cas.saveCase(log));
    }
    
    
    @Override
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants){
        ILog log = new Log(this, (ICaseworker) this);
        //TODO: change method call argument list.
        cas.createMeeting(year, month, day, hour, minute, location, this, participants, log);
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

    @Override
    public String cancelMeeting() {
        return cas.cancelMeeting();
    }

    @Override
    public String setMeetingTime(LocalDateTime time) {
        return cas.setMeetingTime(time);
    }

    @Override
    public String setMeetingLocation(String Location) {
        return cas.setMeetingLocation(Location);
    }

    @Override
    public String setMeetingParticipants(String participants) {
        return cas.setMeetingParticipants(participants);
    }

    @Override
    public void setIndividualName(String name) {
        ILog log = new Log(this, this);
        cas.setIndividualName(name, log);
    }

    @Override
    public void setIndividualAddress(String Address) {
        ILog log = new Log(this, this);
        cas.setIndividualAddress(Address, log);
    }

    @Override
    public void setIndividualCPR(int CPR) {
        ILog log = new Log(this, this);
        cas.setIndividualCPR(CPR, log);
    }

    @Override
    public ICaseworker getCaseworkerFormCase() {
        return cas.getCaseworker();
    }

    @Override
    public IMeeting getMeeting() {
        return cas.getMeeting();
    }

    @Override
    public IIndividual getIndividual() {
        return cas.getIndividual();
    }
}
