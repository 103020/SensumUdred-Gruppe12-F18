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
        IData dataFacade = DataFacade.getInstance();
        dataFacade.load();
        return dataFacade.load() != null;
    }

    @Override
    public void createCase(String caseType, String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        ILog log = new Log(this, this);
        cas = new Case(caseType, individualName, individualAddress,individualCPR, log, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
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
