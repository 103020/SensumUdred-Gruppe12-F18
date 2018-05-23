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
    private StringBuilder entry;

    Diary(String entry, ILog log) {
        this.entry = new StringBuilder(entry);
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
    public void saveEntry(ILog log) {
        //TODO: fix
    }

    @Override
    public String getEntry(ILog log) {
        return entry.toString();
    }

    @Override
    public void enterEntry(String note, ILog log) {
        entry.insert(entry.length(), "\n" + toString() + " " + note);
       
    }
    
    
}
