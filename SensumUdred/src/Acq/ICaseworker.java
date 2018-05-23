package Acq;

import java.time.LocalDateTime;

/**
 *
 * @author stefan
 */
public interface ICaseworker {

    public boolean accessCase(int caseNumber, ILog log);  
    public void createCase(String individualName, String individualAddress, int individualCPR, String _inquiry, String _individualInvolvement, boolean individualUnderstanding,boolean consent, boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String caseFromAdress);  
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants);
    public void setName(String name);
    public void setDepartment(IDepartment department);
    public void setEmployeeID(String employeeID);
    public String getName();
    public IDepartment getDepartment();
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
