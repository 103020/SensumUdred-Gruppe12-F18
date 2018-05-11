/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.ICaseworker;
import Acq.IDiary;
import java.util.Date;

/**
 *
 * @author Nicolai
 */
public class Diary implements IDiary{
    private Date date;
    private String entry;

    @Override
    public void IDiary(String entry) {
        this.entry = entry;
        date = new Date();
    }

    @Override
    public String getEntry(ICaseworker caseworker) {
        
        return entry;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void saveEntry(ICaseworker caseworker) {
        
        
        
    }
    
    @Override
    public String toString(){
        return "Diary entry date: " + date.toString();
    }
}
