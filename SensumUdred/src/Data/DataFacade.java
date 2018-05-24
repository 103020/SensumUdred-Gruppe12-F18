package Data;

import Acq.IData;
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
    public List load() {
        return new ArrayList();
    }

    @Override
    public List loadUser() {
//        UserHandler userHandler = new UserHandler();
//        return userHandler.loadUser();
        return new ArrayList();
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

    @Override
    public int save(List list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
