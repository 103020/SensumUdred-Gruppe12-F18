/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.IIndividual;
import Acq.ILog;

/**
 *
 * @author Nicolai
 */
public class Individual implements IIndividual{

    private String name;
    private String address;
    private int CPR;
    
    
    @Override
    public void IIndividual(String name, String address, int CPR, ILog log) {
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
    public int getCPR() {
        return CPR;
    }

    @Override
    public void setName(String name, ILog log) {
        this.name = name;
    }

    @Override
    public void setAddress(String address, ILog log) {
        this.address = address;
    }

    @Override
    public void setCPR(int CPR, ILog log) {
        this.CPR = CPR;
    }
    
}
