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
    
    //temp to test
    ICase cas = new Case();
    Caseworker worker = new Caseworker();
    Meeting meeting = new Meeting();
    Individual ind = new Individual();
    
    static DataFacade data;

    
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
        return cas.getCaseNumber();
    }

    @Override
    public ICaseworker getCaseWorker() {
        return cas.getCaseWorker();
    }

    @Override
    public IIndividual getIndividual() {
        return cas.getIndividual();
    }

    @Override
    public boolean saveCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return data.save(list) //need a methode were we get the list from Case
    }

    @Override
    public String getCaseCreationDate() {
        return cas.getCreationDate();
    }

    @Override
    public void editCase(ICase ca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMeeting() {
        //cas.createMeeting();
    }

    @Override
    public void closeCase() {
        //cas.closeCase();
    }

    @Override
    public ICase accessCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return cas.accessData(this, casworker)//need more implemented
    }

    @Override
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        worker.createCase(individualName, individualAddress, individualCPR, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
    }
    
    @Override
    public void createMeeting(int year, int month, int date, int hour, int minute, String location, String participants){
        worker.createMeeting(year, month, date, hour, minute, location, participants);
    }

    public String getLocation(){
        return meeting.getLocation();
    }
    
    @Override
    public LocalDateTime getMeetingTime(){
        return meeting.getMeetingTime();
    }
    
    @Override
    public void setEmployeeName(String name) {
        worker.setName(name);
    }

    @Override
    public void setEmployeeDepartment(String department) {
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
        meeting.setMeetingTime(time);
    }

    @Override
    public void setMeetingParticipants(String participants) {
        meeting.setMeetingParticipants(participants);
    }


    @Override
    public String getMeetingParticipants() {
        return meeting.getMeetingParticipants();
    }

    @Override
    public String getIndividualName() {
        return ind.getName();
    }

    @Override
    public String getIndividualAddress() {
        return ind.getAddress();
    }

    @Override
    public int getIndividualCPR() {
        return ind.getCPR();
    }

    @Override
    public void setIndividualName(String name) {
        //ind.setName(name);
    }

    @Override
    public void setIndividualAddress(String address) {
        //ind.setAddress(address);
    }

    @Override
    public void setIndividualCPR(int CPR) {
        //ind.setCPR(CPR);
    }

    @Override
    public List getDateSortedList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ICase> getCasenumSortedList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    //test
//    @Override
//    public void createCase() {
//        worker.createCase("Pizza", "Morten", "Anstalten 17", 0, "jeg vil gerne have pizza", "jeg vil gerne have pizza", true, true, true, true, true, InquiryFrom.INDIVIDUAL, "anstalten 17");
//    }
    
}
