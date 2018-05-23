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
     * @param individualName
     * @param individualAddress
     * @param individualCPR
     * @param _inquiry
     * @param _individualInvolvement
     * @param individualUnderstanding
     * @param consent
     * @param writtenConsent
     * @param oralConsent
     * @param caseClarity
     * @param inquiryFrom
     * @param caseFromAdress
     */
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress);  

    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param location
     * @param participants
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
     * @param department
     */
    public void setDepartment(IDepartment department);

    /**
     *
     * @param employeeID
     */
    public void setEmployeeID(String employeeID);

    /**
     *
     * @return
     */
    public String getName();

    /**
     *
     * @return
     */
    public IDepartment getDepartment();

    /**
     *
     * @return
     */
    public String getEmployeeID();
    
    /**
     *
     * @return
     */
    public String cancelMeeting();

    /**
     *
     * @param time
     * @return
     */
    public String setMeetingTime(LocalDateTime time);

    /**
     *
     * @param Location
     * @return
     */
    public String setMeetingLocation(String Location);

    /**
     *
     * @param participants
     * @return
     */
    public String setMeetingParticipants(String participants);

    /**
     *
     * @param name
     */
    public void setIndividualName(String name);

    /**
     *
     * @param Address
     */
    public void setIndividualAddress(String Address);

    /**
     *
     * @param CPR
     */
    public void setIndividualCPR(int CPR);

    /**
     *
     * @return
     */
    public ICaseworker getCaseworkerFormCase();

    /**
     *
     * @return
     */
    public IMeeting getMeeting();

    /**
     *
     * @return
     */
    public IIndividual getIndividual();
    
}
