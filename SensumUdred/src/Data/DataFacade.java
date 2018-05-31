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

    /**
     * sends login info to so it can be checked aginst the info in the database
     * @param username
     * @param password
     * @return 
     */
    @Override
    public boolean login(String username, String password) {
        return SQLObjectMapper.getCaseworker(username).getEmployeeID().equals(username);
    }

    /**
     * gets all Cases saved in the database that a specific Caseworker made
     * @param caseworker the Caseworker that made the Cases 
     * @param log
     * @return a List of Cases
     */
    @Override
    public ArrayList<ICase> getCases(ICaseworker caseworker, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.getCases(caseworker);
    }

    /**
     * saves a Case in the database
     * @param cas
     * @param log
     * @return the Casenumber that the case was assigned
     */
    @Override
    public int saveCase(ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveCase(cas);
    }

    /**
     * saves a Diary for a specific Case in the database
     * @param cas
     * @param diary
     * @param log
     * @return true if succsesful
     */
    @Override
    public boolean saveDiary(ICase cas, IDiary diary, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveDiary(cas, diary);
    }

    /**
     * saves a Caseworker in the database
     * @param caseworker
     * @return true if succsesful
     */
    @Override
    public boolean saveCaseworker(ICaseworker caseworker) {
        return SQLObjectMapper.saveCaseworker(caseworker);
    }

    /**saves a Department in the database
     * 
     * @param dep
     * @return true if succsesful
     */
    @Override
    public boolean saveDepartment(IDepartment dep) {
        return SQLObjectMapper.saveDepartment(dep);
    }

    /**
     * saves a Meeting for a specific Case in the database
     * @param meeting
     * @param cas
     * @param log
     * @return true if succsesful
     */
    @Override
    public boolean saveMeeting(IMeeting meeting, ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveMeeting(meeting, cas);
    }

    /**
     * saves an Individual in the database
     * @param individual
     * @param log
     * @return true if succsesful
     */
    @Override
    public boolean saveIndividual(IIndividual individual, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.saveIndividual(individual);
    }
    
    @Override
    public ICaseworker getCaseworker(String username){
        return SQLObjectMapper.getCaseworker(username);
    }  
    
    /**
     * updates the info in the database
     * @param cas
     * @param log
     * @return true if succsesful
     */
    @Override
    public boolean updateCase(ICase cas, ILog log){
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateCase(cas);
    }

    @Override
    public void saveLog(ILog log) {
        SQLObjectMapper.saveLog(log);
    }

    /**
     * updates the info in the database
     * @param diary
     * @param cas
     * @param log
     * @return true if succsesful
     */
    @Override
    public boolean updateDiary(IDiary diary, ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateDiary(diary, cas);
    }

    /**
     * updates the info in the database
     * @param meeting
     * @param cas
     * @param log
     * @return true if succsesful
     */
    @Override
    public boolean updateMeeting(IMeeting meeting, ICase cas, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateMeeting(meeting, cas);
    }

    /**
     * updates the info in the database
     * @param individual
     * @param log
     * @return true if succsesful
     */
    @Override
    public boolean updateIndividual(IIndividual individual, ILog log) {
        SQLObjectMapper.saveLog(log);
        return SQLObjectMapper.updateIndividual(individual);
    }

    /**
     * updates the info in the database
     * @param caseworker
     * @return true if succsesful
     */
    @Override
    public boolean updateCaseWorker(ICaseworker caseworker) {
        return SQLObjectMapper.updateCaseWorker(caseworker);
    }

    /**
     * updates the info in the database
     * @param department
     * @return true if succsesful
     */
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
    
