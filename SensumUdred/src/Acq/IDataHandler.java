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
 */
public interface IDataHandler  {
    boolean save(List<Object> givenList);
    List<Object> load();
    List<Object> convert(ICase chosenCase);
}