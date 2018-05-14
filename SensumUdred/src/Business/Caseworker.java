/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import Data.DataFacade;

/**
 *
 * @author Nicolai
 */
public class Caseworker implements ICaseworker{ 

    private String name;
    private IDepartment department;
    private String employeeID; 
    private ICase cas;
    
    @Override
    public boolean accessCase(int caseNumber, ILog log) {
        IData dataFacade = new DataFacade();
        dataFacade.load();
        if(dataFacade.load() != null){
            return true;   
        }
        
        return false;
    }
    
    

    @Override
    public void createCase(String caseType, String individualName, String individualAddress, int individualCPR, ILog log) {
        cas = new Case(caseType, individualName, individualAddress, individualCPR, log);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDepartment(IDepartment department) {
        this.department = department;
    }

    @Override
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID; 
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IDepartment getDepartment() {
        return department;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }
}
