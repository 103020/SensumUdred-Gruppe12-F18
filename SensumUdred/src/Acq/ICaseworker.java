package Acq;

import java.time.LocalDateTime;

/**
 *
 * @author stefan
 */
public interface ICaseworker {
    public String getName();

    /**
     *
     * @return the department of the caseworker
     */
    public IDepartment getDepartment();
    public String getEmployeeID();    
}
