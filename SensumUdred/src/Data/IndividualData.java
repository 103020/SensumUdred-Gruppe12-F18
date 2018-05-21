package Data;

import Acq.IIndividual;
import Acq.ILog;

/**
 *
 * @author stefan
 */
public class IndividualData implements IIndividual{


    @Override
    public String getName() {
        return "SELECT Name FROM Individual";
    }

    @Override
    public String getAddress() {
        return "SELECT Address FROM Individual";
    }

    @Override
    public int getCPR() {
        String queryForCPR = "Select CPR FROM Individual";
        return 0;
    }

    @Override
    public void setName(String name, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAddress(String address, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCPR(int CPR, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}