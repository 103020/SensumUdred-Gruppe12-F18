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


    public static IData getInstance() {

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
