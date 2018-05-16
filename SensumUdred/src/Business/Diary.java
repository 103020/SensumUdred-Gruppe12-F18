/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.ICaseworker;
import Acq.IDiary;
import Acq.ILog;
import java.util.Date;

/**
 *
 * @author Nicolai
 */
public class Diary implements IDiary{
    private Date date;
    private String entry;

    public void Diary(String entry, ILog log) {
        this.entry = entry;
        date = new Date();
    }

    @Override
    public Date getDate() {
        return date;
    }

    
    @Override
    public String toString(){
        return "Diary entry date: " + date.toString();
    }

    @Override
    public void saveEntry(ICaseworker caseworker, ILog log) {
        
    }

    @Override
    public String getEntry(ICaseworker caseworker, ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
