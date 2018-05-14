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
public class CaseController {
    
    List<ICase> caseList;
    
    public void createCase(ICase newCase){
        caseList.add(newCase);
    }
    
}
