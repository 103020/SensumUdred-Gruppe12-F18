/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.IDepartment;

/**
 *
 * @author Nicolai
 */
public class Department implements IDepartment{
    private String departmentName;
    private int amountOfEmployees;
    
    Department(String name, int amount){
        this.departmentName = name;
        this.amountOfEmployees = amount;
    }
    
    public void setAmountOfEmployees(int amount){
        this.amountOfEmployees = amount;
    }
    
    @Override
    public String toString(){
        return departmentName;
    }

    void addEmployee(){
        amountOfEmployees++;
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
