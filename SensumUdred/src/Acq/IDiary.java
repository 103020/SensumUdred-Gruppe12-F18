package Acq;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public interface IDiary {

    
    void saveEntry(ICaseworker caseworker, ILog log);

    /**
     *
     * @return  Returns the entry in string format.
     */
    String getEntry(ICaseworker caseworker, ILog log);

    /**
     *
     * @return  returns the date of the entry
     */
    Date getDate();
    
    
}
