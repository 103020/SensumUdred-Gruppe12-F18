package Acq;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public interface IDiary {

    
    void saveEntry(ILog log);

    /**
     *
     * @return  Returns the entry in string format.
     */
    String getEntry(ILog log);

    /**
     *
     * @return  returns the date of the entry
     */
    Date getDate();
    
    void enterEntry(String note, ILog log);
    
    
}
