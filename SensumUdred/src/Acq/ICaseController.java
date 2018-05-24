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
     * @param newCase the new case is a object of ICase
     * @return and add the new case to a caselist
     */
    public boolean addCase(ICase newCase);

    /**
     *
     * @return the case list is returned 
     */
    public List<ICase> getCaseList();
    
    /**
     *
     * @return the meeting list
     */
    public List<IMeeting> getMeetingList();
    
    /**
     *
     * @param newMeeting A new meeting is added to the meeting list
     * @return return the new meeting 
     */
    public boolean addMeeting(IMeeting newMeeting);

    /**
     *
     * @param caseNumber the number that is assigned to the case
     * @return the case
     */
    public ICase getCase(int caseNumber);

}
