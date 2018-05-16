package Acq;

import java.time.LocalDateTime;

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


    public String getCaseType();
    public String getInquiry();
    public String getIndividualInvolvement();
    public String getCaseFrom();
    public String getCaseFromAdress();
    public IDiary getDiary();
    public boolean isClosed();
    public IMeeting getMeeting();
    public boolean isConsent();
    public boolean isWrittenConsent();
    public boolean isOralConsent();
    public String getCaseFromAddress();
    public boolean isCaseClarity();
    public boolean isIndividualUnderstanding();
    public ICase getCase();
    
    
}
