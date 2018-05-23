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
    
    @Override
    public boolean addCase(ICase newCase){
        return cases.add(newCase);
    }

    @Override
    public List<ICase> getCaseList(){
        return cases;
    }
    

    /** find ud af om caseNumber skal laves om til et index **/ 
    @Override
    public ICase getCase(int caseNumber){
        int caseIndex = -1;
        for (int i = 0; i < cases.size(); i++) {
            if (cases.get(i).getCaseNumber() == caseNumber) {
                caseIndex = i;
            }
        }
        return cases.get(caseIndex);
    }
    
    
}
