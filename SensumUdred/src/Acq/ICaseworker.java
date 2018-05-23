package Acq;

import java.time.LocalDateTime;

/**
 *
 * @author stefan
 */
public interface ICaseworker {
    
    /**
     *  Accesses case from data
     * @return
     * @param caseNumber the case number of the case to be accessed
     */
    public boolean accessCase(int caseNumber, ILog log); 
    
 
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress); 
    
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants);
    
    /**
     *
     * @param name  The name of the caseworker to be set
     */
    public void setName(String name);
    
    /**
     *
     * @param department the department to assign the caseworker to
     */
    public void setDepartment(IDepartment department);
    
    /**
     *
     * @param employeeID The ID of the employee that wishes to be set
     */
    public void setEmployeeID(String employeeID);
    
    /**
     *
     * @return returns the name of the caseworker
     */
    public String getName();
    
    /**
     *
     * @return  returns the department of the caseworker
     */
    public IDepartment getDepartment();

    /**
     *
     * @return returns the employee ID of the caseworker
     */
    public String getEmployeeID();
    
    public String cancelMeeting();
    public String setMeetingTime(LocalDateTime time);
    public String setMeetingLocation(String Location);
    public String setMeetingParticipants(String participants);
    public void setIndividualName(String name);
    public void setIndividualAddress(String Address);
    public void setIndividualCPR(int CPR);
    public ICaseworker getCaseworkerFormCase();
    public IMeeting getMeeting();
    public IIndividual getIndividual();
}
