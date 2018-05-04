/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.util.Date;
import java.util.List;

/**
 *
 * @author stefan
 */
public interface IBusiness {
    public int getCaseNumber();
    public ICaseworker getCaseWorker();
    public IIndividual getIndividual();
    public boolean saveCase();
    public Date getCaseCreationDate();
    public void editCase(ICase ca);
    public void createMeeting();
    public void closeCase();
    public ICase accessCase();
    public void createCase();
    public void createCase(String name, int CPR, String address);
    public void setEmployeeName(String name);
    public void setEmployeeDepartment(String department);
    public void setEmployeeID(int employeeID);
    public String getEmployeeName();
    public String getEmployeeDepartment();
    public int getEmployeeID();
    public void setMeetingTime(Date time);
    public void setMeetingParticipants(String participants);
    public Date getMeetingTime();
    public String getMeetingParticipants();
    public String getIndividualName();
    public String getIndividualAddress();
    public int getIndividualCPR();
    public void setIndividualName(String name);
    public void setIndividualAddress(String address);
    public void setIndividualCPR(int CPR);
    public List getDateSortedList();
    public List getCasenumSortedList();
}
