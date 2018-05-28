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
    public boolean saveMeeting(IMeeting meeting, ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveMeeting(meeting, cas);
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
    public boolean updateCase(ICase cas, ILog log){
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateCase(cas);
    }

    @Override
    public void saveLog(ILog log) {
        SQLObjectMapper.saveLog(log);
    }

    @Override
    public boolean updateDiary(IDiary diary, ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateDiary(diary, cas);
    }

    @Override
    public boolean updateMeeting(IMeeting meeting, ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateMeeting(meeting, cas);
    }

    @Override
    public boolean updateIndividual(IIndividual individual, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateIndividual(individual);
    }

    @Override
    public boolean updateCaseWorker(ICaseworker caseworker) {
        return SQLObjectMapper.updateCaseWorker(caseworker);
    }

    @Override
    public boolean updateDepartment(IDepartment department) {
        return SQLObjectMapper.updateDepartment(department);
    }

    @Override
    public IDiary getDiary(ICase cas) {
        return SQLObjectMapper.getDiary(cas);
    }

    @Override
    public ArrayList<IDepartment> getDepartments() {
        return SQLObjectMapper.getDepartments();
    }

    @Override
    public IMeeting getMeeting(ICase cas) {
        return SQLObjectMapper.getMeeting(cas);
    }
}
    
