/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.*;
import Acq.IDepartment;

/**
 *
 * @author Nicolai
 */
public class DepartmentData implements IDepartment{
    private String departmentName;
    private int amountOfEmployees;
    
    DepartmentData(){
    }
    
    @Override
    public String toString(){
        return departmentName;
    }

    void addEmployee(){
        amountOfEmployees++;
    }
    
    void addAttributes(int amountOFEmployees, String name){
        this.amountOfEmployees = amountOFEmployees;
        this.departmentName = name;
    }
    
    @Override
    public int getAmount() {
        return amountOfEmployees;
    }

    @Override
    public String getName() {
        return departmentName;
    }

}
