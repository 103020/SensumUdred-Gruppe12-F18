package Acq;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public interface ICase {

    /**
     *  
     * @param caseType  A text string for describing what type of case this is. can be used for what the department prefers.
     * @param individualName    The name of the individual the case is about.
     * @param individualAddress The address of the individual the case is about.
     * @param individualCPR     The CPR number of the individual the case is about.
     */
    void ICase(String caseType, String individualName, String individualAddress, int individualCPR);

    /**
     *
     * @return  Returns the case number of the case
     */
    int getCaseNumber();

    /**
     *
     * @return Returns the caseworker assigned to the case
     */
    ICaseworker getCaseWorker();

    /**
     *
     * @return  Returns the individual the case is about
     */
    IIndividual getIndividual();

    /**
     *
     * @return Returns the creation date of the case
     */
    Date getCreationDate();
    void saveCase();
    void editCase();
    void createMeeting();
    void closeCase();

    /**
     *
     * @param caseNumber
     * @return
     */
    ICase fetchCase(int caseNumber); //for fetching a case from the database.

    /**
     *
     * @param caseworker the caseworker to be assigned to the case
     */
    void setCaseworker(ICaseworker caseworker);
}
