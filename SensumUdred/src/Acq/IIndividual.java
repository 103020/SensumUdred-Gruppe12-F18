package Acq;

import java.math.BigInteger;

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
    long getCPR();    
}
