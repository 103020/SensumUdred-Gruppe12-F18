package Acq;

/**
 *
 * @author Stefan
 */
public interface IIndividual {

    /**
     *
     * @return  Returns the name of the individual
     */
    public String getName();

    /**
     *
     * @return returns the address of the individual
     */
    public String getAddress();

    /**
     *
     * @return returns the CPR number of the individual
     */
    public int getCPR();

    /**
     *  method to change the name of the individual
     * @param name  the name of the individual
     * @param log log when a name is set
     */
    public void setName(String name, ILog log);

    /**
     *  method to change the address of the individual
     * @param address the address of the individual.
     * @param log log when a address is set
     */
    public void setAddress(String address, ILog log);

    /**
     *  method to change the CPR number of the individual
     * @param CPR the CPR number of the individual.
     * @param log log when a CPR is set
     */
    public void setCPR(int CPR, ILog log);
    
}
