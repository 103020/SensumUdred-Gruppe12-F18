package Business;

import Acq.ICaseworker;
import Acq.ILog;
import java.time.LocalDateTime;



/**
 *
 * @author Stefan
 * @param <E> use 'this' and make sure the object logged has a describing toString()
 */
public class Log<E> implements ILog{

    private String logString = "";
    
    Log(E e, ICaseworker cs){
        logString += "\n" + LocalDateTime.now().toString();
        logString += " access to " + e.toString();
        logString += " by " + cs.toString();
    }

    @Override
    public void writeLog(Object e) {
        logString += "\n\t" + LocalDateTime.now().toString();
        logString += " access to " + e.toString();
    }

    @Override
    public String getLogString() {
        return logString;
    }
}
