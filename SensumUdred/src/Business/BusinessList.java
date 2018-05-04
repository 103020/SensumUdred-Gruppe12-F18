/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Acq.*;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Tobias
 */
public class BusinessList extends ArrayList implements IBusinessList {
    
    private List<Case> cases;
    private List<Caseworker> caseWorkers;
    
    BusinessList(){
        
    }
    
    @Override
    public boolean addCase(Case newCase){
        return cases.add(newCase);
    }
    
    @Override
    public boolean addCaseWorker(Caseworker caseWorker){
        return caseWorkers.add(caseWorker);
    }
    
    @Override
    public List<Case> getCaseList(){
        return cases;
    }
    
    @Override
    public List<Caseworker> getCaseWorkers(){
        return caseWorkers;
    }
    
    /** find ud af om caseNumber skal laves om til et index **/ 
    @Override
    public Case getCase(int caseNumber){
        return cases.get(caseNumber);
    }
    
    @Override
    public Caseworker getCaseworker(int employerID){
        return caseWorkers.get(employerID);
    }
    
}
