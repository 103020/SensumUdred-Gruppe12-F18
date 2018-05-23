package Acq;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public interface IDiary {

    /**
     *
     * @return  Returns the entry in string format.
     */
    String getEntry(ILog log);

    /**
     *
     * @return  returns the date of the entry
     */
    String getDate();

    
    
}
