/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import Data.DataFacade;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Nicolai
 */
public class Caseworker implements ICaseworker{ 

    private String name;
    private Department department;
    private String employeeID; 
    private Case cas;
    private IBusiness businessFacade;
    private CaseController caseControl;
    
    Caseworker(String name, Department department, String employeeID){
        this.name = name;
        this.department = department;
        this.employeeID = employeeID;
        caseControl = new CaseController();
        cas = new Case();
    }

    public boolean accessCase(int caseNumber, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TODO: Stefan fix
    }

    public void createCase(String individualName, String individualAddress, 
            int individualCPR, String _inquiry, String _individualInvolvement, 
            boolean individualUnderstanding,boolean consent, 
            boolean writtenConsent, boolean oralConsent, boolean caseClarity, 
            InquiryFrom inquiryFrom, String caseFromAdress) {
        ILog log = new Log(this);
        cas = new Case(individualName, individualAddress,individualCPR, log, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
        cas.setCaseNumber(cas.saveCase(cas, log));
        caseControl.addCase(cas);
    }
    
    public String createMeeting(LocalDateTime time, String location){
        ILog log = new Log(this);
        //TODO: change method call argument list.
        return cas.createMeeting(time, location, this, log);
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

    public void setIndividualName(String name) {
        ILog log = new Log(this);
        cas.setIndividualName(name, log);
    }

    public void setIndividualAddress(String Address) {
        ILog log = new Log(this);
        cas.setIndividualAddress(Address, log);
    }

    public void setIndividualCPR(int CPR) {
        ILog log = new Log(this);
        cas.setIndividualCPR(CPR, log);
    }

    public ICaseworker getCaseworkerFormCase() {
        return cas.getCaseworker();
    }

    public Meeting getMeeting() {
        return cas.getMeeting();
    }

    public IIndividual getIndividual() {
        return cas.getIndividual();
    }
    
    public void setCase(int caseNumber){
        this.cas = caseControl.getCase(caseNumber);
    }
    
    public void enterEntry(String note){
        ILog log = new Log(this);
        cas.enterEntry(note, log);
    }
    
    public ICase getCase(){
        return cas;
    }
    
    public void closeCase(){
        ILog log = new Log(this);
        cas.closeCase(log);
    }
    
    public List<Case> getCaseList(){
        return caseControl.getCaseList();
    }
    
    @Override
    public String toString(){
        return "Caseworker: " + this.employeeID + ", name: " + this.name;
    }
}
