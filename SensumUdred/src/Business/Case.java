package Business;

import Acq.*;
import java.time.LocalDateTime;

/**
 *
 * @author Nicolai
 */
public class Case implements ICase{
    
    private int caseNumber;
    private ICaseworker caseWorker;
    private IIndividual individual;
    private final String creationDate;
    private IDiary diary;
    private boolean isClosed;
    private String caseType;
    private Meeting meeting;
    private StringBuilder inquiry;
    private StringBuilder individualInvolvement;
    private boolean consent;
    private boolean writtenConsent;
    private boolean oralConsent;
    private String caseFrom;
    private StringBuilder caseFromAddress;
    private boolean caseClarity;
    private boolean individualUnderstanding;
    private IMeeting createNewMeeting;
    
    private IBusiness businessFacade;
    
    Case(String individualName, String individualAddress, int individualCPR, ILog log, String _inquiry,
            String _individualInvolvement, boolean individualUnderstanding,boolean consent,
            boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String _caseFromAddress){
        creationDate = LocalDateTime.now().toString();
        isClosed = false;
        this.individual = new Individual(individualName, individualAddress, individualCPR, log);
        this.inquiry = new StringBuilder(_inquiry);
        this.individualInvolvement = new StringBuilder(_individualInvolvement);
        this.individualUnderstanding = individualUnderstanding;
        this.consent = consent;
        this.writtenConsent = writtenConsent;
        this.oralConsent = oralConsent;
        this.caseClarity = caseClarity;
        this.caseFromAddress = new StringBuilder(_caseFromAddress);
        caseNumber = 0;

        switch(inquiryFrom){
            case INDIVIDUAL:
                caseFrom = inquiryFrom.INDIVIDUAL.toString();
                break;
            case RELATIVES:
                caseFrom = inquiryFrom.RELATIVES.toString();
                break;
            case DOCTOR:
                caseFrom = inquiryFrom.DOCTOR.toString();
                break;
            case OTHER:
                caseFrom = inquiryFrom.OTHER.toString();
                break;
            default:
                break;
        }
        
        businessFacade = BusinessFacade.getInstance();
    }

    
    Case(){
        caseNumber = 0;
        creationDate = LocalDateTime.now().toString();
        isClosed = false;
        inquiry = new StringBuilder();
        individualInvolvement = new StringBuilder();
    }
    
    @Override
    public void setCaseNumber(int caseNumber){
        this.caseNumber = caseNumber;
    }

    @Override
    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public ICaseworker getCaseworker() {
        return caseWorker;
    }

    @Override
    public IIndividual getIndividual() {
        return individual;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean getClosed() {
        return isClosed;
    }

    @Override
    public String getCaseType() {
        return caseType;
    }

    @Override
    public String getInquiry() {
        return inquiry.toString();
    }

    @Override
    public String getIndividualInvolvement() {
        return individualInvolvement.toString();
    }

    @Override
    public boolean getConsent() {
        return consent;
    }

    @Override
    public boolean getWrittenConsent() {
        return writtenConsent;
    }

    @Override
    public boolean getOralConsent() {
        return oralConsent;
    }

    @Override
    public String getCaseFrom() {
        return caseFrom;
    }

    @Override
    public String getCaseFromAddress() {
        return caseFromAddress.toString();
    }

    @Override
    public boolean getCaseClarity() {
        return caseClarity;
    }

    @Override
    public boolean getIndividualUnderstanding() {
        return individualUnderstanding;
    }

    @Override
    public int saveCase(ILog log) {
        return businessFacade.saveCase();
    }

    @Override
    public void editCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO: fix
    }

    @Override
    public void closeCase(ILog log) {
        isClosed = true;
    }

    @Override
    public ICase fetchCase(int caseNumber, ILog log) {
        ICase cas = businessFacade.accessCase(caseNumber);
        return cas;
    }

    @Override
    public void setCaseworker(ICaseworker caseworker, ILog log) {
        this.caseWorker = caseworker;
    } 

    @Override
    public IDiary getDiary() {
        return diary;
    }

    @Override
    public IMeeting getMeeting() {
        return meeting;
    }

    @Override
    public String cancelMeeting() {
        return meeting.cancelMeeting();
    }

    @Override
    public String setMeetingTime(LocalDateTime time) {
        return meeting.setMeetingTime(time);
    }

    @Override
    public String setMeetingLocation(String Location) {
        return meeting.setLocation(Location);
    }

    @Override
    public String setMeetingParticipants(String participants) {
        return meeting.setMeetingParticipants(participants);
    }

    @Override
    public String createMeeting(int year, int month, int day, int hour, int minute, String location, ICaseworker participant2, String participants, ILog log) {
        meeting = new Meeting(year, month, day, hour, minute, location, this.individual, participant2, participants, log);
        return meeting.messageToMeeting();
    }

    @Override
    public void setIndividualName(String name, ILog log) {
        individual.setName(name, log);
    }

    @Override
    public void setIndividualAddress(String Address, ILog log) {
        individual.setAddress(Address, log);
    }

    @Override
    public void setIndividualCPR(int CPR, ILog log) {
        individual.setCPR(CPR, log);
    }

    @Override
    public void enterEntry(String note, ILog log) {
        diary.enterEntry(note, log);
    }
    


}
