/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acq.*;


/**
 *
 * @author Nicolai
 */
public class CaseworkerData implements ICaseworker{ 

    private String name;
    private IDepartment department;
    private String employeeID; 
    private ICase cas;

    
    CaseworkerData(String name, IDepartment department, String employeeID, ICase cas){
        this.name = name;
        this.department = department;
        this.employeeID = employeeID;
        this.cas = cas;
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
