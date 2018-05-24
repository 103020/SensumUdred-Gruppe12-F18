/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.*;
import Acq.ICaseworker;
import Acq.IDiary;
import Acq.ILog;
import java.util.Date;

/**
 *
 * @author Nicolai
 */
public class DiaryData implements IDiary{
    private String date;
    private StringBuilder entry;
    
    DiaryData(){
        
    }

    DiaryData(String entry, String date) {
        this.entry = new StringBuilder(entry);
        this.date = date;
    }
    
    void setEntry(String entry){
        this.entry = new StringBuilder(entry);
    }
    
    void setDate(String date){
        this.date = date;
    }

    @Override
    public String getDate() {
        return date;
    }

    
    @Override
    public String toString(){
        return "Diary entry date: " + date;
    }


    @Override
    public String getEntry() {
        return entry.toString();
    }

}
