/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acq.*;
import Business.BusinessFacade;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;

/**
 *
 * @author Stefan
 */
public class GUIFacade implements IGUI{

    IBusiness b = BusinessFacade.getInstance();
    
    @Override
    public void editCase(ICase ca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
    
    @Override
    public ICase accessCase(int caseNumber) {
        return b.accessCase(caseNumber);
    }

    
    @Override
    public void createCase(String individualName, String individualAddress, String individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
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
    public void setIndividualCPR(String CPR) {
        b.setIndividualCPR(CPR);
    }

    /**
     * gets a list of Cases and format them for a ListView
     * @return 
     */
    @Override
    public List getCaseList() {
        List convert = new ArrayList();
        for (ICase ic : b.getCaseList()) {
            System.out.println(""+ic.getCaseNumber() + " : " +ic.getCreationDate());
            convert.add(new caseListAbler(""+ic.getCaseNumber(),""+ic.getCreationDate()));
        }
        return convert;
    }
    
    /**
     * the formater for the Meeting ListView
     * @return 
     */
    @Override
    public List<meetingListAbler> getMeetingList(){
        List convert = new ArrayList();
        convert.add(new meetingListAbler(b.getMeetingTime(),""+b.getLocation()));
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
    public String getIndividualCPR() {
        return b.getIndividualCPR();
    }

    @Override
    public void setFacadeCase(int caseNumber) {
        b.setFacadeCase(caseNumber);
    }

    @Override
    public void setDiary(String text) {
        b.setDiary(text);
    }

    @Override
    public IMeeting getAMeeting(ICase temp) {
        return b.getMeeting(temp);
    }
}
