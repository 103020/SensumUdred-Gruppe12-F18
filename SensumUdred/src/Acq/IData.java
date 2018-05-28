/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import Business.Caseworker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stefan
 */
public interface IData {

    /**
     *
     * @param username the username of the login
     * @param password the password of the login
     * @return the login
     */
    public boolean login(String username, String password);
    public ArrayList<ICase> getCases(ICaseworker caseworker, ILog log);
    public int saveCase(ICase cas, ILog log);
    public boolean saveDiary(ICase cas, IDiary diary, ILog log);
    public boolean saveCaseworker(ICaseworker caseworker);
    public boolean saveDepartment(IDepartment dep);
    public boolean saveMeeting(IMeeting meeting, ICase cas, ILog log);
    public boolean saveIndividual(IIndividual individual, ILog log);
    public ICaseworker getCaseworker(String username);
    public IDiary getDiary(ICase cas);
    public ArrayList<IDepartment> getDepartments();
    public IMeeting getMeeting(ICase cas);
    
    public boolean updateCase(ICase cas, ILog log);
    public boolean updateDiary(IDiary diary, ICase cas, ILog log);
    public boolean updateMeeting(IMeeting meeting, ICase cas, ILog log);
    public boolean updateIndividual(IIndividual individual, ILog log);
    public boolean updateCaseWorker(ICaseworker caseworker);
    public boolean updateDepartment(IDepartment department);
    public void saveLog(ILog log);
}
