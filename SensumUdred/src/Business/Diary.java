/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Nicolai
 */
public class Diary implements IDiary {

    private String date;
    private StringBuilder entry;
    private IBusiness businessFacade;

    /**
     * creates a Diary, also uses to load a Diary so there are checks so a standard massage is not put every time
     * @param entry
     * @param log 
     */
    Diary(String entry, ILog log) {
        if (entry.length() > 15) {
            if (entry.substring(0, 16).equals("Dagbog oprettet.")) {
                this.entry = new StringBuilder(entry);
            } else {
                this.entry = new StringBuilder("Dagbog oprettet. " + entry); //should not be used
            }
        } else {
            this.entry = new StringBuilder("Dagbog oprettet. " + entry);
        }
        date = LocalDateTime.now().toString();
        businessFacade = BusinessFacade.getInstance();
        log.writeLog("Diary created date: " + date);
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Diary entry date: " + date;
    }

    public void saveEntry(ILog log) {
        log.writeLog(this);
        businessFacade.saveDiary(businessFacade.getCaseworker().getCase(), this, log);
    }

    /**
     * puts a new entry into the Diary
     * @param note
     * @param log 
     */
    public void enterEntry(String note, ILog log) {
        log.writeLog(this);
        entry.insert(entry.length(), "\n" + toString() + " " + note);

    }

    @Override
    public String getEntry() {
        return this.entry.toString();
    }

    public void setDate(String date) {
        this.date = date;
    }

}
