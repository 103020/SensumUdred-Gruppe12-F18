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
    String getName();

    /**
     *
     * @return returns the address of the individual
     */
    String getAddress();

    /**
     *
     * @return returns the CPR number of the individual
     */
    int getCPR();

    /**
     *  method to change the name of the individual
     * @param name  the name of the individual
     */
    void setName(String name, ILog log);

    /**
     *  method to change the address of the individual
     * @param address the address of the individual.
     */
    void setAddress(String address, ILog log);

    /**
     *  method to change the CPR number of the individual
     * @param CPR the CPR number of the individual.
     */
    void setCPR(int CPR, ILog log);
    
}
