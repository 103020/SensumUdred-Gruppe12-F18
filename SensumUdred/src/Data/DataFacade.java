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
    public boolean save(List list) {
        return false;
    }

    @Override
    public List load() {
        return new ArrayList();
    }

    @Override
    public List loadUser() {
        UserHandler userHandler = new UserHandler();
        return userHandler.loadUser();
    }
    
}
