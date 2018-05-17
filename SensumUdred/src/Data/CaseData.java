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
        return caseFromAddress.toString();
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
    
    
}
