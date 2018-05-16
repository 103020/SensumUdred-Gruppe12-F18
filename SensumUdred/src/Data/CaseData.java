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
    private final int caseNumber;
    private ICaseworker caseWorker;
    private IIndividual individual;
    private final String creationDate;
    private IDiary diary;
    private boolean isClosed;
    private String caseType;
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
    

    public CaseData(ICase cas) {
        this.caseNumber = cas.getCaseNumber();
        this.caseWorker = cas.getCaseWorker();
        this.individual = cas.getIndividual();
        this.creationDate = cas.getCreationDate();
        this.diary = cas.getDiary();
        this.isClosed = cas.isClosed();
        this.caseType = cas.getCaseType();
        this.meeting = cas.getMeeting();
        this.inquiry = cas.getInquiry();
        this.individualInvolvement = cas.getIndividualInvolvement();
        this.consent = cas.isConsent();
        this.writtenConsent = cas.isWrittenConsent();
        this.oralConsent = cas.isOralConsent();
        this.caseFrom = cas.getCaseFrom();
        this.caseFromAddress = cas.getCaseFromAddress();
        this.caseClarity = cas.isCaseClarity();
        this.individualUnderstanding = cas.isIndividualUnderstanding();
    }
    
    public int getAttributeCount(){
        return getClass().getDeclaredFields().length;
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
    public boolean isClosed() {
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
    public boolean isConsent() {
        return consent;
    }

    @Override
    public boolean isWrittenConsent() {
        return writtenConsent;
    }

    @Override
    public boolean isOralConsent() {
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
    public boolean isCaseClarity() {
        return caseClarity;
    }

    @Override
    public boolean isIndividualUnderstanding() {
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
    public String getCaseFromAdress() {
        return caseFromAddress.toString();
    }

    @Override
    public ICase getCase() {
        return this;
    }
    
    
    
}
