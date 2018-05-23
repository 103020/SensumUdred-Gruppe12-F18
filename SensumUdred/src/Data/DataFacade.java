/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acq.IData;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class DataFacade implements IData{

    private DataHandler dataHandler;
    private static DataFacade instance;


    public static DataFacade getInstance() {

        if (instance == null) {
            instance = new DataFacade();
        }
        return instance;

    }
    
    @Override
    public int save(List list) {
        return dataHandler.save(list);
    }

    @Override
    public List load() {
        dataHandler = new DataHandler();
        return dataHandler.load();
    }

    @Override
    public List loadUser() {
        UserHandler userHandler = new UserHandler();
        return userHandler.loadUser();
    }

    @Override
    public boolean login(String username, String password) {
        //TODO: get stuff from database login
        /*
        get data from database about user
        check through if they are the same as username and password
        */
        return true; //debug
    }

    @Override
    public int loadHighestCaseNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
