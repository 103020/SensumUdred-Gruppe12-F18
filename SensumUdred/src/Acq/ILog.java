/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

/**
 *
 * @author stefan
 * @param <E>
 */
public interface ILog<E> {

    /**
     *
     * @param e take a object
     */
    public void writeLog(E e);

    /**
     *
     * @return a log String
     */
    public String getLogString();
    
}
