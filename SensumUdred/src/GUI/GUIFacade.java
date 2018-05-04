/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acq.ICase;
import Acq.IGUI;
import java.util.Date;
import Business.BusinessFacade;

/**
 *
 * @author Stefan
 */
public class GUIFacade implements IGUI{

    BusinessFacade b = new BusinessFacade();
    
    @Override
    public boolean saveCase() {
        return b.saveCase();
    }

    @Override
    public void editCase(ICase ca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMeeting() {
        b.createMeeting();
    }

    @Override
    public void closeCase() {
        b.closeCase();
    }

    @Override
    public ICase accessCase() {
        return b.accessCase();
    }

    @Override
    public void createCase() {
        b.createCase();
    }
    
    @Override
    public void createCase(String name, int CPR, String address) {
        b.createCase(name,CPR,address);
    }

    @Override
    public void setEmployeeName(String name) {
        b.setEmployeeDepartment(name);
    }

    @Override
    public void setEmployeeDepartment(String department) {
        b.setEmployeeDepartment(department);
    }

    @Override
    public void setEmployeeID(int employeeID) {
        b.setEmployeeID(employeeID);
    }

    @Override
    public void setMeetingTime(Date time) {
        b.setMeetingTime(time);
    }

    @Override
    public void setMeetingParticipants(String participants) {
        b.setMeetingParticipants(participants);
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
}
