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

    /**
     *
     * @param newCase is a new object of case, added to list the cases
     * @return the list with the cases
     */
    public boolean addCase(ICase newCase);

    /**
     *
     * @param caseWorker is a new object of caseworker added to a caseworkerlist
     * @return the caseworker list
     */
    public boolean addCaseWorker(ICaseworker caseWorker);

    /**
     *
     * @return the case list
     */
    public List<ICase> getCaseList();

    /**
     *
     * @return the caseworker list
     */
    public List<ICaseworker> getCaseWorkers();

    /**
     *
     * @param caseNumber is the number used to get a case
     * 
     * @return the case 
     */
    public ICase getCase(int caseNumber);

    /**
     *
     * @param employerID is the id of the caseworker
     * @return the caseworker
     */
    public ICaseworker getCaseworker(int employerID);
}
