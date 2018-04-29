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
    
    
    @Override
    public String toString(){
        return departmentName;
    }

}
