package Acq;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public interface IDiary {

    /**
     *  method for creating a new diary
     * @param entry the text-entry of the diary.
     */
    void IDiary(String entry, ILog log);
    
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
