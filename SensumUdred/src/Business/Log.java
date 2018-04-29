package Business;

import Acq.ICaseworker;
import java.util.Date;

/**
 *
 * @author Nicolai
 * @param <E>
 */
public abstract class Log<E> {
    private Date date;
    
    
    String writeLog(E element, ICaseworker caseworker){
        date = new Date();
        String logstring = element.toString() + " saved on date: " + 
            date.toString() + " by caseworker ID: " + caseworker.getEmployeeID();
        // write to database log
        return logstring;
    }
    
    String accessData(E element, ICaseworker caseworker){
        date = new Date();
        String logstring = element.toString() + " accessed on date: " + date.toString();
        // write to database log
        return logstring;
    }
}
