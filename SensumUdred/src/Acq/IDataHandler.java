/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.util.List;

/**
 *
 * @author Tobias
 * @param <E>   The object to be used
 */
public interface IDataHandler<E>  {
    boolean save(E obj);
    E load();
    List<Object> convert(ICase chosenCase);
}
