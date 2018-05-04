/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Acq.*;

/**
 *
 * @author Tobias
 */
public class CaseController {
    
    ICaseworker caseworker;
    
    public void createCase(){
        caseworker.createCase();
    }
    
}
