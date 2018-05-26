package Data;

import Acq.*;
import Business.Caseworker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class DataFacade implements IData{
    private static DataFacade instance;

    public static IData getInstance() {

        if (instance == null) {
            instance = new DataFacade();
        }
        return instance;

    }

    @Override
    public boolean login(String username, String password) {
        //TODO: get stuff from database login
        /*
        get data from database about user
        check through if they are the same as username and password
         */
//        System.out.println(SQLObjectMapper.getCaseworker(username).toString());
        return SQLObjectMapper.getCaseworker(username).getEmployeeID().equals(username);
    }

    @Override
    public ArrayList<ICase> getCases(ICaseworker caseworker, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int saveCase(ICase cas, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDiary(ICase cas, IDiary diary, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCaseworker(ICaseworker caseworker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDepartment(IDepartment dep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveMeeting(IMeeting meeting) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveIndividual(IIndividual individual, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


    
}
