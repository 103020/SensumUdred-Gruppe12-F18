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
public interface IBusinessList {
    boolean addCase(Case newCase);
    boolean addCaseWorker(Caseworker caseWorker);
    List<Case> getCaseList();
    List<Caseworker> getCaseWorkers();
    Case getCase(int caseNumber);
    Caseworker getCaseworker(int employerID);
}
