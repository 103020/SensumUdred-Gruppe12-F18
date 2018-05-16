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
// Her implementeres constructor mm. så det bliver en singleton-klasse:

    public static DataFacade getInstance() {

        if (instance == null) {
            instance = new DataFacade();
        }
        return instance;

    }
    
    @Override
    public boolean save(List list) {
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
    
}
