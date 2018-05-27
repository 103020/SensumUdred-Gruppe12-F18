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
    
    

    Individual(String name, String address, int CPR, ILog log) {
        this.name = name;
        this.address = address;
        this.CPR = CPR;
        log.writeLog("Individual with CPR: " + CPR + " created");
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

    public void setName(String name, ILog log) {
        log.writeLog(this);
        this.name = name;
    }

    public void setAddress(String address, ILog log) {
        log.writeLog(this);
        this.address = address;
    }

    public void setCPR(int CPR, ILog log) {
        log.writeLog(this);
        this.CPR = CPR;
    }
    
    @Override
    public String toString(){
        return "Individual CPR: " + this.CPR;
    }
    
}
