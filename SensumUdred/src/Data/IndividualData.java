/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.*;
import Acq.IIndividual;
import Acq.ILog;

/**
 *
 * @author Nicolai
 */
public class IndividualData implements IIndividual{

    private String name;
    private String address;
    private String CPR;
    
    IndividualData(){
        
    }

    IndividualData(String name, String address, String CPR) {
        this.name = name;
        this.address = address;
        this.CPR = CPR;
    }

    void setAttributes(String name, String address, String CPR){
        this.name = name;
        this.address = address;
        this.CPR = CPR;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCPR() {
        return CPR;
    }

}
