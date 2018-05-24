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
    public ICaseworker getCaseworker();

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
     * @param log is the log that is set when a case is edited
     */
    public void editCase(ILog log);

    /**
     *
     * @param time the time of the meeting
     * @param location location/address the meeting is taking place
     * @param participant2 is the caseworker
     * @param participants is the individuals 
     * @param log log when a meeting is created
     * @return 
     */
    public String createMeeting(LocalDateTime time, String location, ILog log);

    /**
     *
     * @param log
     */
    public void closeCase(ILog log);
    
    /**
     *
     * @param caseNumber here is the casenumber the number it fetch to get the right case
     * @param log is the log that is set when a case is fetched 
     * @return a case object
     */
    public ICase fetchCase(int caseNumber, ILog log);

    /**
     *
     * @param caseworker set the caseworker
     * @param log when a new caseworker is set 
     */
    public void setCaseworker(ICaseworker caseworker, ILog log);

    /**
     *
     * @return a message when a meeting is cancelled
     */
    public String cancelMeeting();

    /**
     *
     * @param time is the date, day and time of the day the meeting is taking place at
     * @return a message that gives all the information about the meeting
     */
    public String setMeetingTime(LocalDateTime time);

    /**
     *
     * @param Location is the location the meeting is taking place at
     * @return a message that gives all the information about the meeting
     */
    public String setMeetingLocation(String Location);

    /**
     *
     * @param name that is set to the individual, that is connected to the meeting
     * @param log when a new name is set for the individual
     */
    public void setIndividualName(String name, ILog log);

    /**
     *
     * @param Address is address set to the individual, that is connected to the meeting
     * @param log when a new address set for the individual
     */
    public void setIndividualAddress(String Address, ILog log);

    /**
     *
     * @param CPR is the individual personalnumber
     * @param log when a new personal number is set for the individual
     */
    public void setIndividualCPR(int CPR, ILog log);

    /**
     *
     * @param note is a note set to the caseworker
     * @param log when a caseworker enter a diary on a case
     */
    public void enterEntry(String note, ILog log);   
}
