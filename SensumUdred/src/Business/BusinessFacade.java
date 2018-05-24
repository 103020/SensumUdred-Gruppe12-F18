/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import Data.DataFacade;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class BusinessFacade implements IBusiness {
    

    private Case cas;
    private Caseworker worker;
    private Meeting meeting;
    private Individual ind;
    
//test     
//ICase cas = new Case();
//Caseworker worker = new Caseworker();
//Meeting meeting = new Meeting();
//Individual ind = Individual;
    
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
    public int saveCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return data.save(list) //need a methode were we get the list from Case
        //TODO: sefan fix
    }

    @Override
    public String getCaseCreationDate() {
        return worker.getCase().getCreationDate();
    }

    @Override
    public void editCase(ICase ca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeCase() {
        worker.closeCase();
    }

    @Override
    public ICase accessCase(int caseNumber) {
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
        return worker.getMeeting().getLocation();
    }
    
    @Override
    public LocalDateTime getMeetingTime(){
        try { //TODO: getmeetingtime this is temp
            return meeting.getMeetingTime();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        worker.setDepartment(department); //check IDepartment as input?
    }

    @Override
    public void setEmployeeID(int employeeID) {
        worker.setEmployeeID(""+employeeID); //TODO: this is temp to remove an error
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
    public List getDateSortedList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ICase> getCasenumSortedList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String username, String password) {
        boolean temp = data.login(username, password);
        if (temp) {
            ICaseworker temp2 = data.getCaseWorker(username);
            worker = new Caseworker(temp2.getName(), new Department(temp2.getDepartment().getName()), temp2.getEmployeeID());
            return temp;
        }
        return temp;
    }

    @Override
    public void setFacadeCase(int caseNumber) {
        worker.setCase(caseNumber);
    }

    
}
