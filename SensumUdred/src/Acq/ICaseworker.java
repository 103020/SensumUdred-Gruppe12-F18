package Acq;

import java.time.LocalDateTime;

/**
 *
 * @author stefan
 */
public interface ICaseworker {

    /**
     *
     * @param caseNumber is the number of the case
     * @param log when a case i accessed
     * @return
     */
    public boolean accessCase(int caseNumber, ILog log);  

    /**
     *
     * @param individualName The name of the individual the case is about
     * @param individualAddress The address of the individual the case is about
     * @param individualCPR The CPR of the individual the case is about
     * @param _inquiry The inquiry of the case
     * @param _individualInvolvement The text of the individual involvement
     * @param individualUnderstanding The individual's consent to the inquiry
     * @param consent The individuals consent to get relevant data
     * @param writtenConsent The individual consent as written
     * @param oralConsent The individual consent as oral
     * @param caseClarity Is it clear what the individual seeks?
     * @param inquiryFrom The source of the inquiry, who made the inquiry
     * @param caseFromAdress The Address of the source, the address of who made the inquiry
     */
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress);  

    /**
     *
     * @param year year of the meeting 
     * @param month month of the meeting 
     * @param day day of the meeting
     * @param hour hour of the meeting 
     * @param minute minute of the meeting
     * @param location address the meeting is taking place
     * @param participants all the participants
     * @return
     */
    public String createMeeting(int year, int month, int day, int hour, int minute, String location, String participants);

    /**
     *
     * @param name set the name of the caseworker
     */
    public void setName(String name);

    /**
     *
     * @param department set the department for the caseworker
     */
    public void setDepartment(IDepartment department);

    /**
     *
     * @param employeeID set the id of the caseworker
     */
    public void setEmployeeID(String employeeID);

    /**
     *
     * @return the name of the caseworker
     */
    public String getName();

    /**
     *
     * @return the department of the caseworker
     */
    public IDepartment getDepartment();

    /**
     *
     * @return the name of the caseworker
     */
    public String getEmployeeID();
    
    /**
     *
     * @return the message when a meeting is cancelled
     */
    public String cancelMeeting();

    /**
     *
     * @param time Set the time of the meeting which contains - year, month, day and minute 
     * @return a message when a new time is set
     */
    public String setMeetingTime(LocalDateTime time);

    /**
     *
     * @param Location set the location of the meeting
     * @return a message when a new location is set
     */
    public String setMeetingLocation(String Location);

    /**
     *
     * @param participants set the participants of the meeting
     * @return a message when new participants is set
     */
    public String setMeetingParticipants(String participants);

    /**
     *
     * @param name set the individuals name
     */
    public void setIndividualName(String name);

    /**
     *
     * @param Address set the individual address
     */
    public void setIndividualAddress(String Address);

    /**
     *
     * @param CPR set the personal number of the individual
     */
    public void setIndividualCPR(int CPR);

    /**
     *
     * @return the caseworker form the case
     */
    public ICaseworker getCaseworkerFormCase();

    /**
     *
     * @return the meeting
     */
    public IMeeting getMeeting();

    /**
     *
     * @return the individual
     */
    public IIndividual getIndividual();
    
}
