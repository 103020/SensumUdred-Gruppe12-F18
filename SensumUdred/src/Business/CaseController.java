/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Acq.*;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class CaseController implements ICaseController{
    
    private List<ICase> cases;
    private List<ICaseworker> caseWorkers;
    
    @Override
    public boolean addCase(ICase newCase){
        return cases.add(newCase);
    }
    
    @Override
    public boolean addCaseWorker(ICaseworker caseWorker){
        return caseWorkers.add(caseWorker);
    }
    
    @Override
    public List<ICase> getCaseList(){
        return cases;
    }
    
    @Override
    public List<ICaseworker> getCaseWorkers(){
        return caseWorkers;
    }
    
    /** find ud af om caseNumber skal laves om til et index **/ 
    @Override
    public ICase getCase(int caseNumber){
        return cases.get(caseNumber);
    }
    
    @Override
    public ICaseworker getCaseworker(int employerID){
        return caseWorkers.get(employerID);
    }
    
}
