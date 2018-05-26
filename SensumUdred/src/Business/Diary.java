/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.ICaseworker;
import Acq.IDiary;
import Acq.ILog;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Nicolai
 */
public class Diary implements IDiary{
    private String date;
    private StringBuilder entry;

    Diary(String entry, ILog log) {
        this.entry = new StringBuilder(entry);
        date = LocalDateTime.now().toString();
    }

    @Override
    public String getDate() {
        return date;
    }

    
    @Override
    public String toString(){
        return "Diary entry date: " + date;
    }

    public void saveEntry(ILog log) {
        //TODO: fix
    }

    public void enterEntry(String note, ILog log) {
        entry.insert(entry.length(), "\n" + toString() + " " + note);
       
    }

    @Override
    public String getEntry() {
        return this.entry.toString();
    }
    
    
}
