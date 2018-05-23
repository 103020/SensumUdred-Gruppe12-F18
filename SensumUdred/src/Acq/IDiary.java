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
    
    /**
     *
     * @param note note to the caseworker
     * @param log log when a caseworker go into diary
     */
    void enterEntry(String note, ILog log);
    
    
}
