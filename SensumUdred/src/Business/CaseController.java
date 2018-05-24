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
public class CaseController{
    
    private List<Case> cases;
    private List<Meeting> meeting;

    public boolean addCase(Case newCase){
        return cases.add(newCase);
    }

    public List<Case> getCaseList(){
        return cases;
    }
    
    /**
     *
     * @param newMeeting
     * @return
     */
    public boolean addMeeting(Meeting newMeeting){
        return meeting.add(newMeeting);
    }

    public List<Meeting> getMeetingList(){
        return meeting;
    }
    

    /** find ud af om caseNumber skal laves om til et index **/ 
    public Case getCase(int caseNumber){
        int caseIndex = -1;
        for (int i = 0; i < cases.size(); i++) {
            if (cases.get(i).getCaseNumber() == caseNumber) {
                caseIndex = i;
            }
        }
        return cases.get(caseIndex);
    }
    
    
}
