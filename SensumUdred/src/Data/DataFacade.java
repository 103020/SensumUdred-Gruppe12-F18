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
    public void saveDiary(ICase cas, IDiary diary, ILog log) {
        SQLObjectMapper.saveLog(log);
        SQLObjectMapper.saveDiary(cas, diary);
    }

    @Override
    public void saveCaseworker(ICaseworker caseworker) {
        SQLObjectMapper.saveCaseworker(caseworker);
    }

    @Override
    public void saveDepartment(IDepartment dep) {
        SQLObjectMapper.saveDepartment(dep);
    }

    @Override
    public void saveMeeting(IMeeting meeting, ILog log) {
        SQLObjectMapper.saveLog(log);
        SQLObjectMapper.saveMeeting(meeting);
    }

    @Override
    public void saveIndividual(IIndividual individual, ILog log) {
        SQLObjectMapper.saveLog(log);
        SQLObjectMapper.saveIndividual(individual);
    }
   
}
    
