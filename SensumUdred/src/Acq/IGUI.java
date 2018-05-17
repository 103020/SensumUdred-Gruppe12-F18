/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author stefan
 */
public interface IGUI {
    public boolean saveCase();
    public void editCase(ICase ca);
    public void createMeeting();
    public void closeCase();
    public ICase accessCase();
    public void createCase();
    public void createCase(String name, int CPR, String address);
    public void setEmployeeName(String name);
    public void setEmployeeDepartment(String department);
    public void setEmployeeID(int employeeID);
    public void setMeetingTime(LocalDateTime time);
    public void setMeetingParticipants(String participants);
    public void setIndividualName(String name);
    public void setIndividualAddress(String address);
    public void setIndividualCPR(int CPR);
    public List getCaseList();
}
