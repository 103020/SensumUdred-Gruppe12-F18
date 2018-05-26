/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import Business.Caseworker;
import java.util.List;

/**
 *
 * @author stefan
 */
public interface IData {

    /**
     *
     * @return a new arraylist
     */
    public List load();

    /**
     *
     * @return a user
     */
    public List loadUser();

    /**
     *
     * @param username the username of the login
     * @param password the password of the login
     * @return the login
     */
    public boolean login(String username, String password);

    /**
     *
     * @return the highest case number
     */
    public int loadHighestCaseNumber();

    public ICaseworker getCaseWorker(String username);
}
