/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.util.List;

/**
 *
 * @author stefan
 */
public interface IData {
    public boolean save(List list);
    public List load();
    public List loadUser();
    
}
