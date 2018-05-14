package Data;

import Acq.ICase;
import Acq.ICaseworker;
import Acq.IDiary;
import Acq.IIndividual;
import Acq.ILog;
import java.time.LocalDateTime;

/**
 *
 * @author stefan
 */
public class CaseData implements ICase{
    private int caseNumber;
    private ICaseworker caseworker;
    private IIndividual individual;
    private LocalDateTime creationDate;
    private IDiary diary;
    private boolean isClosed;
    
    CaseData(int caseNumber, ICaseworker casew, IIndividual ind, LocalDateTime creationDate, IDiary diary, boolean isClosed) {
        this.caseNumber = caseNumber;
        this.caseworker = casew;
        this.individual = ind;
        this.creationDate = creationDate;
        this.diary = diary;
        this.isClosed = isClosed;
    }    

    @Override
    public int getCaseNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICaseworker getCaseWorker() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IIndividual getIndividual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDateTime getCreationDate() {
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
