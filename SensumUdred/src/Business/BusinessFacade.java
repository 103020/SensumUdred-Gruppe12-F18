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
 * @author Stefan
 */
public class BusinessFacade implements IBusiness {
    
    private Caseworker worker;
       
    static IData data = new DataFacade();

    private static BusinessFacade instance;

    public static BusinessFacade getInstance() {

        if (instance == null) {
            instance = new BusinessFacade();
        }
        data = DataFacade.getInstance();
        return instance;
        
    }
    
    @Override
    public int getCaseNumber() {
        return worker.getCase().getCaseNumber();
    }

    @Override
    public ICaseworker getCaseworker() {
        return worker.getCase().getCaseworker();
    }

    @Override
    public IIndividual getIndividual() {
        return worker.getCase().getIndividual();
    }

    @Override
    public int saveCase(ICase cas, ILog log) {
       return data.saveCase(cas, log);
    }

    @Override
    public String getCaseCreationDate() {
        return worker.getCase().getCreationDate();
    }

    @Override
    public void editCase(ICase cas, ILog log) {
        data.updateCase(cas, log);
    }

    @Override
    public void closeCase() {
        worker.closeCase();
    }

    @Override
    public ICase accessCase(int caseNumber) {
        //TODO: Make this
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return cas.accessData(this, casworker)//need more implemented
    }

    @Override
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        worker.createCase(individualName, individualAddress, individualCPR, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
        
    }
    
    @Override
    public void createMeeting(LocalDateTime time, String location){
        worker.createMeeting(time, location);
    }

    @Override
    public String getLocation(){
        try {
            return worker.getMeeting().getLocation();
        } catch(NullPointerException e) {
            return null;
        }
    }
    
    @Override
    public LocalDateTime getMeetingTime(){
        try { 
            return worker.getMeeting().getMeetingTime();
        } catch(NullPointerException e){
            System.out.println(e);
        }
        return null;
    }
    
    @Override
    public void setEmployeeName(String name) {
        worker.setName(name);
    }

    @Override
    public void setEmployeeDepartment(IDepartment department) {
        worker.setDepartment((Department)department);
    }

    @Override
    public void setEmployeeID(int employeeID) {
        worker.setEmployeeID(""+employeeID);
    }

    @Override
    public String getEmployeeName() {
        return worker.getName();
    }

    @Override
    public String getEmployeeDepartment() {
        return worker.getDepartment().toString();
    }

    @Override
    public String getEmployeeID() {
        return worker.getEmployeeID();
    }

    @Override
    public void setMeetingTime(LocalDateTime time) {
        worker.getMeeting().setMeetingTime(time);
    }

    @Override
    public String getMeetingParticipants() {
        return worker.getMeeting().getMeetingParticipants();
    }

    @Override
    public String getIndividualName() {
        return worker.getIndividual().getName();
    }

    @Override
    public String getIndividualAddress() {
        return worker.getIndividual().getAddress();
    }

    @Override
    public int getIndividualCPR() {
        return worker.getIndividual().getCPR();
    }

    @Override
    public void setIndividualName(String name) {
        worker.setIndividualName(name);
    }

    @Override
    public void setIndividualAddress(String address) {
        worker.setIndividualAddress(address);
    }

    @Override
    public void setIndividualCPR(int CPR) {
        worker.setIndividualCPR(CPR);
    }

    @Override
    public boolean login(String username, String password) {
        boolean loginSuccess = data.login(username, password);
        if (loginSuccess) {
            ICaseworker tempCaseworker = data.getCaseworker(username);
            worker = new Caseworker(tempCaseworker.getName(), new Department(tempCaseworker.getDepartment().getName()), tempCaseworker.getEmployeeID());
            return loginSuccess;
        }
        return loginSuccess;
    }

    @Override
    public void setFacadeCase(int caseNumber) {
        worker.setCase(caseNumber);
    }

    @Override
    public boolean saveMeeting(IMeeting meeting, ILog log) {
        return data.saveMeeting((Meeting)meeting, log);
    }

    @Override
    public boolean saveDiary(IDiary diary, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveIndividual(IIndividual individual, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveDepartment(IDepartment department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveCaseworker(ICaseworker caseworker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
