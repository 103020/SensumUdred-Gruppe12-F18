/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

/**
 *
 * @author stefan
 */
public interface ICaseWorker {
    public boolean accessCase(int caseNumber); //Accesses case from data
    public void createCase();
    public void setName(String name);
    public void setDepartment(String department);
    public void setEmployerID(String employerID);
    public String getName();
    public String getDepartment();
    public int getEmployerID();
}
