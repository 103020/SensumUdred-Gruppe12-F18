/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Acq.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class CaseController{
    
    private static List<Case> cases = new ArrayList();
    private static List<Meeting> meeting;
    private static IBusiness business = BusinessFacade.getInstance();

    /**
     * adds a Case to the list of all Cases
     * @param newCase the Case to be added to the list
     * @return if succses full it returns a true
     */
    public static boolean addCase(Case newCase){
        return cases.add(newCase);
    }

    public static List<Case> getCaseList(){
        return cases;
    }
    
    /**
     * a way to get the List full of Cases
     * @param log
     * @return a List of Cases
     */
    public static List<Case> fetchCaseList(ILog log){
        log.writeLog("Fetched list of available cases.");
        List<ICase> ICaseList = business.getCaseList(log);
        cases.clear();
        for(ICase cas : ICaseList){
            Case temp = new Case(
                    cas.getIndividual().getName(), 
                    cas.getIndividual().getAddress(), 
                    cas.getIndividual().getCPR(), 
                    log, 
                    cas.getInquiry(), 
                    cas.getIndividualInvolvement(), 
                    cas.getIndividualUnderstanding(), 
                    cas.getConsent(), 
                    cas.getWrittenConsent(), 
                    cas.getOralConsent(), 
                    cas.getCaseClarity(), 
                    InquiryFrom.valueOf(cas.getCaseFrom().toUpperCase()), 
                    cas.getCaseFromAddress(), 
                    new Caseworker(
                            cas.getCaseworker().getName(), 
                            new Department(
                                    cas.getCaseworker().getDepartment().getName(),
                                    cas.getCaseworker().getDepartment().getAmount()
                            ), 
                            cas.getCaseworker().getEmployeeID()
                    )
            );
            temp.setCaseNumber(cas.getCaseNumber());
            temp.setCreationDate(cas.getCreationDate());
            cases.add(temp);
        }
        return cases;
    }
    /**
     *
     * @param newMeeting
     * @return
     */
    public static boolean addMeeting(Meeting newMeeting){
        return meeting.add(newMeeting);
    }

    public static List<Meeting> getMeetingList(){
        return meeting;
    }
    
    /**
     * a way to get a Case with a specific Casenumber
     * @param caseNumber the Casenumber of the case to return
     * @param log
     * @return a Case
     */
    public static Case getCase(int caseNumber, ILog log){
        log.writeLog("Access to case: " + caseNumber);
        int caseIndex = -1;
        for (int i = 0; i < cases.size(); i++) {
            if (cases.get(i).getCaseNumber() == caseNumber) {
                caseIndex = i;
            }
        }
        business.saveLog(log);
        return cases.get(caseIndex);
    }
    
    
}
