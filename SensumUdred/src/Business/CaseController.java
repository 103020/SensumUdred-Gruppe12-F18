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

    public static boolean addCase(Case newCase){
        return cases.add(newCase);
    }

    public static List<Case> getCaseList(){
        return cases;
    }
    
    public static List<Case> fetchCaseList(ILog log){
        log.writeLog("Fetched list of available cases.");
        List<ICase> ICaseList = business.getCaseList(log);
        cases.clear();
        for(ICase cas : ICaseList){
            cases.add((Case)cas);
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
    
    public static Case getCase(int caseNumber){
        int caseIndex = -1;
        for (int i = 0; i < cases.size(); i++) {
            if (cases.get(i).getCaseNumber() == caseNumber) {
                caseIndex = i;
            }
        }
        return cases.get(caseIndex);
    }
    
    
}
