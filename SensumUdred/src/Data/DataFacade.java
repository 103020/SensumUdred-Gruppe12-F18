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
        return SQLObjectMapper.getCaseworker(username).getEmployeeID().equals(username);
    }

    @Override
    public ArrayList<ICase> getCases(ICaseworker caseworker, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.getCases(caseworker);
    }

    @Override
    public int saveCase(ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveCase(cas);
    }

    @Override
    public boolean saveDiary(ICase cas, IDiary diary, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveDiary(cas, diary);
    }

    @Override
    public boolean saveCaseworker(ICaseworker caseworker) {
        return SQLObjectMapper.saveCaseworker(caseworker);
    }

    @Override
    public boolean saveDepartment(IDepartment dep) {
        return SQLObjectMapper.saveDepartment(dep);
    }

    @Override
    public boolean saveMeeting(IMeeting meeting, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveMeeting(meeting);
    }

    @Override
    public boolean saveIndividual(IIndividual individual, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveIndividual(individual);
    }
    
    @Override
    public ICaseworker getCaseworker(String username){
        return SQLObjectMapper.getCaseworker(username);
    }  
    
    @Override
    public void updateCase(ICase cas, ILog log){
        SQLObjectMapper.saveLog(log);
        SQLObjectMapper.updateCase(cas);
    }
}
    
