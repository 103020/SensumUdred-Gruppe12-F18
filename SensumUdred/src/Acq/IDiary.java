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
    void IDiary(String entry);
    
    void saveEntry(ICaseworker caseworker);

    /**
     *
     * @return  Returns the entry in string format.
     */
    String getEntry(ICaseworker caseworker);

    /**
     *
     * @return  returns the date of the entry
     */
    Date getDate();
    
    
}
