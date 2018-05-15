/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import Data.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nicolai
 */
public class Case implements ICase{
    
    private static int totalCases;
    private final int caseNumber;
    private ICaseworker caseWorker;
    private IIndividual individual;
    private final String creationDate;
    private IDiary diary;
    private boolean isClosed;
    private String caseType;
    private Meeting meeting;
    
    private IData dataFacade = new DataFacade();
    
    Case(String caseType, String individualName, String individualAddress, int individualCPR, ILog log){
        caseNumber = totalCases;
        totalCases++;
        creationDate = LocalDateTime.now().toString();
        isClosed = false;
        this.caseType = caseType;
        this.individual.setName(individualName, log);
        this.individual.setAddress(individualAddress, log);
        this.individual.setCPR(individualCPR, log);
    }
    
    Case(){
        caseNumber = totalCases;
        totalCases++;
        creationDate = LocalDateTime.now().toString();
        isClosed = false;
    }

    @Override
    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public ICaseworker getCaseWorker() {
        return caseWorker;
    }

    @Override
    public IIndividual getIndividual() {
        return individual;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public void saveCase(ILog log) {
//      dataFacade.save(list);
    }

    @Override
    public void editCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMeeting(int year, int month, int date, ILog log) {
        Date meetingDate = new Date(year, month, date);
        meeting.setMeetingTime(meetingDate);
    }

    @Override
    public void closeCase(ILog log) {
        isClosed = true;
    }

    @Override
    public ICase fetchCase(int caseNumber, ILog log) {
        List<ICase> tempList;
        tempList = dataFacade.load();
        return tempList.get(caseNumber);
    }

    @Override
    public void setCaseworker(ICaseworker caseworker, ILog log) {
        this.caseWorker = caseworker;
    }
}
