package Acq;

/**
 *
 * @author stefan
 */
public interface ICaseworker {
    
    /**
     *  Accesses case from data
     * @return
     * @param caseNumber the case number of the case to be accessed
     */
    public boolean accessCase(int caseNumber); 
    
    /**
     *
     * @return
     */
    public void createCase(); 
    
    /**
     *
     * @param name  The name of the caseworker to be set
     */
    public void setName(String name);
    
    /**
     *
     * @param department the department to assign the caseworker to
     */
    public void setDepartment(IDepartment department);
    
    /**
     *
     * @param employeeID The ID of the employee that wishes to be set
     */
    public void setEmployeeID(String employeeID);
    
    /**
     *
     * @return returns the name of the caseworker
     */
    public String getName();
    
    /**
     *
     * @return  returns the department of the caseworker
     */
    public IDepartment getDepartment();

    /**
     *
     * @return returns the employee ID of the caseworker
     */
    public int getEmployeeID();
}
