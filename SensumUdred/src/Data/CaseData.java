package Data;

import Acq.*;
import Business.Meeting;
import java.time.LocalDateTime;

/**
 *
 * @author Nicolai
 */
public class CaseData implements ICase{
    
    private int caseNumber;
    private ICaseworker caseworker;
    private IIndividual individual;
    private final String creationDate;
    private IDiary diary;
    private boolean isClosed;
    private IMeeting meeting;
    private String inquiry;
    private String individualInvolvement;
    private boolean consent;
    private boolean writtenConsent;
    private boolean oralConsent;
    private String caseFrom;
    private String caseFromAddress;
    private boolean caseClarity;
    private boolean individualUnderstanding;
    
    CaseData(boolean individualUnderstanding,boolean consent, boolean writtenConsent, 
            boolean oralConsent, boolean caseClarity, String caseFrom, 
            int casenumber, String inquiry, String individualInvolvement, 
            String caseFromAddress, boolean isClosed, String creationdate)
    {
        this.isClosed = isClosed;
        this.inquiry = inquiry;
        this.individualInvolvement = individualInvolvement;
        this.individualUnderstanding = individualUnderstanding;
        this.consent = consent;
        this.writtenConsent = writtenConsent;
        this.oralConsent = oralConsent;
        this.caseClarity = caseClarity;
        this.caseFromAddress = caseFromAddress;
        this.caseNumber = casenumber;
        this.creationDate = creationdate;
        this.caseFrom = caseFrom;

    }
    
    void addDiary(IDiary diary){
        this.diary = diary;
    }
    
    void addMeeting(IMeeting meeting){
        this.meeting = meeting;
    }
    
    void addIndividual(IIndividual individual){
        this.individual = individual;
    }
    
    void addCaseworker(ICaseworker caseworker){
        this.caseworker = caseworker;
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
        return inquiry;
    }

    @Override
    public String getIndividualInvolvement() {
        return individualInvolvement;
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
        return caseFromAddress;
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
    public IDiary getDiary() {
        return diary;
    }

    @Override
    public IMeeting getMeeting() {
        return meeting;
    }

    @Override
    public void setMeeting(Meeting meeting) {
        //Not supposed to do anything in here but it have to be added to ICase to work
    }
}
