package Data;

import Acq.ICase;
import Acq.ICaseworker;
import Acq.IDiary;
import Acq.IIndividual;
import Acq.ILog;
import Acq.IMeeting;
import java.time.LocalDateTime;

/**
 *
 * @author stefan
 */
public class CaseData implements ICase{
    private int caseNumber;
    private ICaseworker caseWorker;
    private IIndividual individual;
    private final String creationDate;
    private IDiary diary;
    private boolean isClosed;
    private String caseType;
    private IMeeting meeting;
    private StringBuilder inquiry;
    private StringBuilder individualInvolvement;
    private boolean consent;
    private boolean writtenConsent;
    private boolean oralConsent;
    private String caseFrom;
    private StringBuilder caseFromAddress;
    private boolean caseClarity;
    private boolean individualUnderstanding;

    public CaseData(int caseNumber, ICaseworker caseWorker, 
            IIndividual individual, String creationDate, IDiary diary, 
            boolean isClosed, String caseType, IMeeting meeting, 
            StringBuilder inquiry, StringBuilder individualInvolvement, 
            boolean consent, boolean writtenConsent, boolean oralConsent, 
            String caseFrom, StringBuilder caseFromAddress, boolean caseClarity, 
            boolean individualUnderstanding) {
        this.caseNumber = caseNumber;
        this.caseWorker = caseWorker;
        this.individual = individual;
        this.creationDate = creationDate;
        this.diary = diary;
        this.isClosed = isClosed;
        this.caseType = caseType;
        this.meeting = meeting;
        this.inquiry = inquiry;
        this.individualInvolvement = individualInvolvement;
        this.consent = consent;
        this.writtenConsent = writtenConsent;
        this.oralConsent = oralConsent;
        this.caseFrom = caseFrom;
        this.caseFromAddress = caseFromAddress;
        this.caseClarity = caseClarity;
        this.individualUnderstanding = individualUnderstanding;
    }

    @Override
    public int getCaseNumber() {
        return caseNumber;
    }

    @Override
    public ICaseworker getCaseWorker() {
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
    public IDiary getDiary() {
        return diary;
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
    public IMeeting getMeeting() {
        return meeting;
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
    public String getInquiry() {
        return inquiry.toString();
    }

    @Override
    public String getIndividualInvolvement() {
        return individualInvolvement.toString();
    }

    @Override
    public int saveCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCaseNumber(int caseNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICase fetchCase(int caseNumber, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCaseworker(ICaseworker caseworker, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
