/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

/**
 *
 * @author Stefan
 */
public interface IDepartment {

    /**
     *
     * @return Return the name of the department
     */
    @Override
    String toString();

    int getAmount();
}
