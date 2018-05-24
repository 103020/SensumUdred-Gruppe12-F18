/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acq.IBusiness;
import Acq.ICase;
import Acq.ICaseworker;
import Acq.IGUI;
import Acq.IIndividual;
import Acq.ILog;
import Acq.IMeeting;
import Acq.InquiryFrom;
import Business.BusinessFacade;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class GUIFacade implements IGUI{

    IBusiness b = new BusinessFacade();
    
    @Override
    public int saveCase() {
        return b.saveCase();
    }

    @Override
    public void editCase(ICase ca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createMeeting(LocalDateTime time, String location) {
        b.createMeeting(time, location);

    }

    @Override
    public void closeCase() {
        b.closeCase();
    }

    @Override
    public ICase accessCase() {
        //return b.accessCase();
        return null;
    }

//    @Override
//    public void createCase() {
//        b.createCase();
//    }
    
    @Override
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        b.createCase(individualName, individualAddress, individualCPR, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
    }

    @Override
    public void setEmployeeName(String name) {
        //b.setEmployeeDepartment(name);
    }

    @Override
    public void setEmployeeDepartment(String department) {
        //b.setEmployeeDepartment(department);
    }

    @Override
    public void setEmployeeID(int employeeID) {
        b.setEmployeeID(employeeID);
    }

    @Override
    public void setMeetingTime(LocalDateTime time) {
        b.setMeetingTime(time);
    }

    @Override
    public void setMeetingParticipants(String participants) {
        //b.setMeetingParticipants(participants);
    }

    @Override
    public void setIndividualName(String name) {
        b.setIndividualName(name);
    }

    @Override
    public void setIndividualAddress(String address) {
        b.setIndividualAddress(address);
    }

    @Override
    public void setIndividualCPR(int CPR) {
        b.setIndividualCPR(CPR);
    }

    @Override
    public List getCaseList() {
        List convert = new ArrayList();
        convert.add(new caseListAbler("58", "16/08-12"));
        convert.add(new caseListAbler("12", "30/01-03"));
        /* TODO: when a list is returnable
        for (ICase ic : b.getCasenumSortedList()) {
            convert.add(new caseListAbler(""+ic.getCaseNumber(),""+ic.getCreationDate()));
        }*/
        return convert;
    }
    
    @Override
    public LocalDateTime getMeetingTime(){
        return b.getMeetingTime();
    }

    @Override
    public boolean login(String username, String password) {
        return b.login(username, password);
    }

    @Override
    public String getIndividualName() {
        return b.getIndividualName();
    }

    @Override
    public String getIndividualAddress() {
        return b.getIndividualAddress();
    }

    @Override
    public int getIndividualCPR() {
        return b.getIndividualCPR();
    }

    @Override
    public void setFacadeCase(int caseNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
