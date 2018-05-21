package Business;

import Acq.*;
import java.time.LocalDateTime;

/**
 *
 * @author Nicolai
 */
public class Case implements ICase{
    
    private static int totalCases;
    private final int caseNumber;
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
    
    Case(String caseType, String individualName, String individualAddress, int individualCPR, ILog log, String _inquiry,
            String _individualInvolvement, boolean individualUnderstanding,boolean consent,
            boolean writtenConsent, boolean oralConsent, boolean caseClarity, InquiryFrom inquiryFrom, String _caseFromAddress){
        caseNumber = totalCases;
        totalCases++;
        creationDate = LocalDateTime.now().toString();
        isClosed = false;
        this.caseType = caseType;
        this.individual.setName(individualName, log);
        this.individual.setAddress(individualAddress, log);
        this.individual.setCPR(individualCPR, log);
        this.inquiry = new StringBuilder(_inquiry);
        this.individualInvolvement = new StringBuilder(_individualInvolvement);
        this.individualUnderstanding = individualUnderstanding;
        this.consent = consent;
        this.writtenConsent = writtenConsent;
        this.oralConsent = oralConsent;
        this.caseClarity = caseClarity;
        this.caseFromAddress = new StringBuilder(_caseFromAddress);

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
        caseNumber = totalCases;
        totalCases++;
        creationDate = LocalDateTime.now().toString();
        isClosed = false;
        inquiry = new StringBuilder();
        individualInvolvement = new StringBuilder();
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

    public void saveCase(ILog log) {
//      dataFacade.save(list);
    }

    public void editCase(ILog log) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createMeeting(int year, int month, int day, int hour, int minute, String location, String participants) {
//        meeting.messageToMeeting();
//        ILog log = new Log(this, (ICaseworker) this);
//        createNewMeeting = new Meeting(year, month, day, hour, minute, location, participants, log);
    }

    public void closeCase(ILog log) {
        isClosed = true;
    }

    public ICase fetchCase(int caseNumber, ILog log) {
        ICase cas = businessFacade.accessCase(caseNumber);
        return cas;
    }

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

}
