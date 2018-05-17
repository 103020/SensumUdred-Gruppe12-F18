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

    /**
     * 
     * @return returns the type of the case
     */
    public String getCaseType();
    
    /**
     * 
     * @return returns the inquiry
     */
    public String getInquiry();
    
    /**
     * 
     * @return returns the text of the individual involvement
     */
    public String getIndividualInvolvement();
    
    /**
     * 
     * @return returns the source of the inquiry, who made the inquiry
     */
    public String getCaseFrom();
    
    /**
     * 
     * @return returns the Address of the source, the address of who made the inquiry
     */
    public String getCaseFromAddress();
    
    /**
     * 
     * @return returns the diary of the case
     */
    public IDiary getDiary();
    
    /**
     * 
     * @return returns whether the case is closed
     */
    public boolean getClosed();
    
    /**
     * 
     * @return returns the meeting
     */
    public IMeeting getMeeting();
    
    /**
     * 
     * @return returns whether The individuals consent to get relevant data
     */
    public boolean getConsent();
    
    /**
     * 
     * @return returns whether the consent is written
     */
    public boolean getWrittenConsent();
    
    /**
     * 
     * @return return whether the consent is oral
     */
    public boolean getOralConsent();
   
    
    /**
     * 
     * @return returns whether it is clear what the individual seek
     */
    public boolean getCaseClarity();
    
    /**
     * 
     * @return returns whether the individual is consent to the inquiry
     */
    public boolean getIndividualUnderstanding();
    
    
}
