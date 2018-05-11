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
     * @param log Attach the log file created by the Caseworker when creating a case
     */
    void ICase(String caseType, String individualName, String individualAddress, int individualCPR, ILog log);

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
    void saveCase(ILog log);
    void editCase(ILog log);
    void createMeeting(ILog log);
    void closeCase(ILog log);

    /**
     * for fetching a case from the database.
     * @param caseNumber
     * @return
     */
    ICase fetchCase(int caseNumber, ILog log); 

    /**
     *
     * @param caseworker the caseworker to be assigned to the case
     */
    void setCaseworker(ICaseworker caseworker, ILog log);
}
