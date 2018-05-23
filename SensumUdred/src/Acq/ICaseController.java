/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;
import Business.*;
import java.util.List;

/**
 *
 * @author Tobias
 */
public interface ICaseController {
    boolean addCase(ICase newCase);

    List<ICase> getCaseList();

    ICase getCase(int caseNumber);

}
