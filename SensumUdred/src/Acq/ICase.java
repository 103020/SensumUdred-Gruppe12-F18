package Acq;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public interface ICase {

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
    String getCreationDate();
    void saveCase(ILog log);
    void editCase(ILog log);
    void createMeeting(int year, int month, int date, ILog log);
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
