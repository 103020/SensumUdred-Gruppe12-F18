


package Business;

import Acq.*;
import java.time.LocalDateTime;

/**
 *
 * @author Nicolai
 */
public class Case implements ICase{
    
    private int caseNumber;
    private Caseworker caseworker;
    private Individual individual;
    private String creationDate;
    private Diary diary = null;
    private boolean isClosed;
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
    
    private IBusiness businessFacade;
    
    
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
    
    Case(String individualName, String individualAddress, String individualCPR, ILog log, String _inquiry,
            String _individualInvolvement, boolean individualUnderstanding,boolean consent,
            boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, 
            String _caseFromAddress, Caseworker caseworker){
        log.writeLog("Case created");
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
        this.caseworker = caseworker;
//        diary = new Diary("Oprettet", log);
//        meeting = new Meeting();
        
        
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

    public void setCaseNumber(int caseNumber){
        this.caseNumber = caseNumber;
    }

    @Override
    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public ICaseworker getCaseworker() {
        return caseworker;
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

    public int saveCase(ICase cas, ILog log) {
        return businessFacade.saveCase(this, log);
    }

    public void editCase(ICase cas, ILog log) {
        businessFacade.editCase(this, log);
    }
    
    public void closeCase(ILog log) {
        isClosed = true;
    }

//    public ICase fetchCase(int caseNumber, ILog log) {
//        ICase cas = businessFacade.accessCase(caseNumber);
//        return cas;
//    }

    public void setCaseworker(Caseworker caseworker, ILog log) {
        this.caseworker = caseworker;
    } 

    @Override
    public IDiary getDiary() {
        return diary;
    }

    @Override
    public Meeting getMeeting() {
        return meeting;
    }

    public String cancelMeeting() {
        return meeting.cancelMeeting();
    }

    public String setMeetingTime(LocalDateTime time) {
        return meeting.setMeetingTime(time);
    }

    public String setMeetingLocation(String Location) {
        return meeting.setLocation(Location);
    }

    public String createMeeting(LocalDateTime dateTime, String location, Caseworker caseworker, ILog log) {
        meeting = new Meeting(dateTime, location, this.individual, caseworker, log);
        log.writeLog(meeting);
        businessFacade.saveMeeting(meeting, this, log);
        return meeting.messageToMeeting();
    }

    public void setIndividualName(String name, ILog log) {
        individual.setName(name, log);
    }

    public void setIndividualAddress(String Address, ILog log) {
        individual.setAddress(Address, log);
    }

    public void setIndividualCPR(String CPR, ILog log) {
        individual.setCPR(CPR, log);
    }

    public void enterEntry(String note, ILog log) {
        if (diary == null) {
            diary = new Diary(note, log);
            System.out.println(""+this +" "+ diary +" "+ log);
            businessFacade.saveDiary(this, diary, log);
        } else {
            diary.enterEntry(note, log);
            businessFacade.updateDiary(diary, this, log);
        }
    }
    public void setCreationDate(String date){
        this.creationDate = date;
    }
    
    public void setDiary(IDiary diary){
        this.diary = new Diary(diary.getEntry(), new Log(caseworker));
        this.diary.setDate(diary.getDate());
    }
    
    @Override
    public String toString(){
        return "Casenumber" + this.caseNumber;
    }

    @Override
    public void setMeeting(Meeting meeting) {
        this.meeting = meeting; 
    }
}
