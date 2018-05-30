/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import Data.DataFacade;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class BusinessFacade implements IBusiness {
    
    private Caseworker worker;
       
    static IData data = new DataFacade();

    private static BusinessFacade instance;

    public static BusinessFacade getInstance() {

        if (instance == null) {
            instance = new BusinessFacade();
        }
        data = DataFacade.getInstance();
        return instance;
        
    }
    
    @Override
    public int getCaseNumber() {
        return worker.getCase().getCaseNumber();
    }

    @Override
    public ICaseworker getCaseworker() {
        return worker.getCase().getCaseworker();
    }

    @Override
    public IIndividual getIndividual() {
        return worker.getCase().getIndividual();
    }

    @Override
    public int saveCase(ICase cas, ILog log) {
        data.saveIndividual(getIndividual(), log);
        return data.saveCase(cas, log);
    }

    @Override
    public String getCaseCreationDate() {
        return worker.getCase().getCreationDate();
    }

    @Override
    public void editCase(ICase cas, ILog log) {
        data.updateCase(cas, log);
    }

    @Override
    public void closeCase() {
        worker.closeCase();
    }

    @Override
    public ICase accessCase(int caseNumber) {
        return worker.accessCase(caseNumber); //TODO: log
    }

    @Override
    public void createCase(String individualName, String individualAddress, String individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress) {
        worker.createCase(individualName, individualAddress, individualCPR, _inquiry, _individualInvolvement, individualUnderstanding, consent, writtenConsent, oralConsent, caseClarity, inquiryFrom, caseFromAdress);
        saveMeeting(worker.getMeeting(), worker.getCase(), new Log(worker));
    }
    
    @Override
    public void createMeeting(LocalDateTime time, String location){
        Log tLog = new Log(worker);
        worker.getCase().setMeeting(new Meeting(time, location, worker.getCase().getIndividual(), worker, tLog));
        if (worker.getCase().getMeeting().getIndividual() != null) {
            System.out.println("updateMeeting");
            data.updateMeeting(worker.getMeeting(), worker.getCase(), tLog);
        } else {
            System.out.println("createMeeting");
            worker.createMeeting(time, location);
        }
    }

    @Override
    public String getLocation(){
        try {
            return worker.getMeeting().getLocation();
        } catch(NullPointerException e) {
            return null;
        }
    }
    
    @Override
    public LocalDateTime getMeetingTime(){
        try { 
            return worker.getMeeting().getMeetingTime();
        } catch(NullPointerException e){
            System.out.println(e);
        }
        return null;
    }
    
    @Override
    public void setEmployeeName(String name) {
        worker.setName(name);
    }

    @Override
    public void setEmployeeDepartment(IDepartment department) {
        worker.setDepartment((Department)department);
    }

    @Override
    public void setEmployeeID(int employeeID) {
        worker.setEmployeeID(""+employeeID);
    }

    @Override
    public String getEmployeeName() {
        return worker.getName();
    }

    @Override
    public String getEmployeeDepartment() {
        return worker.getDepartment().toString();
    }

    @Override
    public String getEmployeeID() {
        return worker.getEmployeeID();
    }

    @Override
    public void setMeetingTime(LocalDateTime time) {
        worker.getMeeting().setMeetingTime(time);
    }

    @Override
    public String getMeetingParticipants() {
        return worker.getMeeting().getMeetingParticipants();
    }

    @Override
    public String getIndividualName() {
        return worker.getIndividual().getName();
    }

    @Override
    public String getIndividualAddress() {
        return worker.getIndividual().getAddress();
    }

    @Override
    public String getIndividualCPR() {
        return worker.getIndividual().getCPR();
    }

    @Override
    public void setIndividualName(String name) {
        worker.setIndividualName(name);
    }

    @Override
    public void setIndividualAddress(String address) {
        worker.setIndividualAddress(address);
    }

    @Override
    public void setIndividualCPR(String CPR) {
        worker.setIndividualCPR(CPR);
    }

    @Override
    public boolean login(String username, String password) {
        boolean loginSuccess = data.login(username, password);
        if (loginSuccess) {
            ICaseworker tempCaseworker = data.getCaseworker(username);
            worker = new Caseworker(tempCaseworker.getName(), new Department(tempCaseworker.getDepartment().getName(), tempCaseworker.getDepartment().getAmount()), tempCaseworker.getEmployeeID());
            return loginSuccess;
        }
        return loginSuccess;
    }

    @Override
    public void setFacadeCase(int caseNumber) {
        worker.setCase(caseNumber);
    }

    @Override
    public boolean saveMeeting(IMeeting meeting, ICase cas, ILog log) {
        return data.saveMeeting((Meeting)meeting, cas, log);
    }

    @Override
    public boolean saveDiary(ICase cas, IDiary diary, ILog log) {
        return data.saveDiary(cas, diary, log);
    }

    @Override
    public boolean saveIndividual(IIndividual individual, ILog log) {
        return data.saveIndividual(individual, log);
    }

    @Override
    public boolean saveDepartment(IDepartment department) {
        return data.saveDepartment(department);
    }

    @Override
    public boolean saveCaseworker(ICaseworker caseworker) {
        return data.saveCaseworker(caseworker);
    }

    @Override
    public void setDiary(String text) {
        worker.enterEntry(text);
    }

    /**
     * need to call the datalayer for a list of all the cases for a specific caseworker
     * @return 
     */
    @Override
    public List<ICase> getCaseList(ILog log) {
        return data.getCases(worker, log);
    }

    @Override
    public List<ICase> getCaseList() {
        List<Case> cases = worker.getCases();
        List<ICase> ICases = new ArrayList<>();
        for(Case cas : cases){
            ICases.add((ICase)cas);
        }
        return ICases;
    }
    
    @Override
    public void saveLog(ILog log){
        data.saveLog(log);
    }

    @Override
    public boolean updateCase(ICase cas, ILog log) {
        return data.updateCase(cas, log);
    }

    @Override
    public boolean updateDiary(IDiary diary, ICase cas, ILog log) {
        return data.updateDiary(diary, cas, log);
    }

    @Override
    public boolean updateMeeting(IMeeting meeting, ICase cas, ILog log) {
        return data.updateMeeting(meeting, cas, log);
    }

    @Override
    public boolean updateIndividual(IIndividual individual, ILog log) {
        return data.updateIndividual(individual, log);
    }

    @Override
    public boolean updateCaseWorker(ICaseworker caseworker) {
        return data.updateCaseWorker(caseworker);
    }

    @Override
    public boolean updateDepartment(IDepartment department) {
        return data.updateDepartment(department);
    }

    @Override
    public IDiary getDiary(ICase cas) {
        return data.getDiary(cas);
    }

    @Override
    public ArrayList<IDepartment> getDepartments() {
        return data.getDepartments();
    }

    @Override
    public IMeeting getMeeting(ICase cas) {
        IMeeting temp = data.getMeeting(cas);
        worker.setMeeting(temp); //TODO: set meeting in business
        return temp;
    }
 
}
