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
    public void saveDiary(ICase cas, IDiary diary, ILog log);
    public void saveCaseworker(ICaseworker caseworker);
    public void saveDepartment(IDepartment dep);
    public void saveMeeting(IMeeting meeting);
    public void saveIndividual(IIndividual individual, ILog log);
}
