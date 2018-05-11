package Business;

import java.time.LocalDateTime;



/**
 *
 * @author Stefan
 * @param <E> use 'this' and make sure the object logged has a describing toString()
 */
public class Log<E> {

    private String logString = "";
    
    Log(E e){
        logString += LocalDateTime.now().toString();
        logString += e.toString();
    }
    
    void writeLog(E e){
        logString += LocalDateTime.now().toString();
        logString += e.toString();
    }
    
    
//    String writeLog(E element, ICaseworker caseworker){
//        date = new Date();
//        String logstring = element.toString() + " saved on date: " + 
//            date.toString() + " by caseworker ID: " + caseworker.getEmployeeID();
//        // write to database log
//        return logstring;
//    }
//    
//    String accessData(E element, ICaseworker caseworker){
//        date = new Date();
//        String logstring = element.toString() + " accessed on date: " + date.toString();
//        // write to database log
//        return logstring;
//    }
}
