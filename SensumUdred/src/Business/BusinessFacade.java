/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.IBusiness;
import Acq.ICase;
import Acq.ICaseworker;
import Acq.IIndividual;
import Data.DataFacade;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class BusinessFacade implements IBusiness {
    
    //temp to test
    Case cas = new Case();
    Caseworker worker = new Caseworker();
    Meeting meeting = new Meeting();
    Individual ind = new Individual();
    
    DataFacade data = new DataFacade();

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
    public Date getCaseCreationDate() {
        return cas.getCreationDate();
    }

    @Override
    public void editCase(ICase ca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMeeting() {
        cas.createMeeting();
    }

    @Override
    public void closeCase() {
        cas.closeCase();
    }

    @Override
    public ICase accessCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return cas.accessData(this, casworker)//need more implemented
    }

    @Override
    public void createCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //need the casList to be finished
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
    public int getEmployeeID() {
        return worker.getEmployeeID();
    }

    @Override
    public void setMeetingTime(Date time) {
        meeting.setMeetingTime(time);
    }

    @Override
    public void setMeetingParticipants(String participants) {
        meeting.setMeetingParticipants(participants);
    }

    @Override
    public Date getMeetingTime() {
        return meeting.getMeetingTime();
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
        ind.setName(name);
    }

    @Override
    public void setIndividualAddress(String address) {
        ind.setAddress(address);
    }

    @Override
    public void setIndividualCPR(int CPR) {
        ind.setCPR(CPR);
    }

    @Override
    public void createCase(String name, int CPR, String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getDateSortedList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCasenumSortedList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
