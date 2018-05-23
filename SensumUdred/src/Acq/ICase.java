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
    public int getCaseNumber();

    /**
     *
     * @return Returns the caseworker assigned to the case
     */
    ICaseworker getCaseworker();

    /**
     *
     * @return  Returns the individual the case is about
     */
    public IIndividual getIndividual();

    /**
     *
     * @return Returns the creation date of the case
     */
    public String getCreationDate();

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
    
    /**
     * saves the case to the database
     * @param log is used to log that the case has been saved
     * @return 
     */
    public int saveCase(ILog log);

    /**
     *
     * @param caseNumber is the number that is set to the case
     */
    public void setCaseNumber(int caseNumber);

    /**
     *
     * @param log
     */
    public void editCase(ILog log);

    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param location
     * @param participants
     */
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants);

    /**
     *
     * @param log
     */
    public void closeCase(ILog log);

    /**
     *
     * @param caseNumber
     * @param log
     * @return
     */
    public ICase fetchCase(int caseNumber, ILog log);

    /**
     *
     * @param caseworker
     * @param log
     */
    public void setCaseworker(ICaseworker caseworker, ILog log);
    public String cancelMeeting();
    public String setMeetingTime(LocalDateTime time);
    public String setMeetingLocation(String Location);
    public String setMeetingParticipants(String participants);
    public void setIndividualName(String name, ILog log);

    /**
     *
     * @param Address
     * @param log
     */
    public void setIndividualAddress(String Address, ILog log);

    /**
     *
     * @param CPR
     * @param log
     */
    public void setIndividualCPR(int CPR, ILog log);
    public void enterEntry(String note, ILog log);
    
    
}
