package Data;

import Acq.ICaseworker;
import Acq.IDiary;
import Acq.ILog;
import java.util.Date;

/**
 *
 * @author stefan
 */
public class DiaryData implements IDiary{


    @Override
    public void saveEntry(ICaseworker caseworker, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEntry(ICaseworker caseworker, ILog log) {
        return "SELECT" + caseworker + "FROM Diary";
    }

    @Override
    public Date getDate() {
        String queryForDate = "SELECT Date from Diary";
        return null;
    }
    
}
