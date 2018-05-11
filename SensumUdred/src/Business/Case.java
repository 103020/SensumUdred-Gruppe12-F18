/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.ICase;
import Acq.ICaseworker;
import Acq.IIndividual;
import Acq.ILog;
import java.util.Date;

/**
 *
 * @author Nicolai
 */
public class Case implements ICase{
    
    private static int totalCases;
    private int caseNumber;
//    private CaseWorker caseWorker;
//    private Individual individual;
    private Date creationDate;
//    private Diary diary;
    private boolean closed;
    
    Case(){
        caseNumber = totalCases;
        totalCases++;
        creationDate = new Date();
        closed = false;
    }   

    @Override
    public void ICase(String caseType, String individualName, String individualAddress, int individualCPR, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCaseNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICaseworker getCaseWorker() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IIndividual getIndividual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getCreationDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMeeting(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICase fetchCase(int caseNumber, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCaseworker(ICaseworker caseworker, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
