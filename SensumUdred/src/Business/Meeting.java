/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.*;
import java.time.LocalDateTime;

/**
 *
 * @author Nicolai
 */
public class Meeting implements IMeeting {

    private LocalDateTime dayOfMeeting;
    private IIndividual individual;
    private ICaseworker caseworker;
    private ICase cas;
    private String location;
    private boolean meetingActive;
    private IBusiness businessFacade;
        
    /**
     * This is how a meeting the created with the following attributes
     * @param time the date of the meeting
     * @param timeOfMeeting the time of the meeting
     * @param location the address the meeting is taking place at
     * @param active when meetings are created it is set as active == true, but when the meeting
     * end or the meeting is cancelled in any shape and form the meeting active is set to false 
     * @param log is what track who made the meeting
     */
    Meeting(LocalDateTime time, String location, IIndividual individual, ICaseworker caseworker, ILog log){
        this.dayOfMeeting = time;
        this.location = location;
        this.individual = individual;
        this.caseworker = caseworker;
        meetingActive = true;
        businessFacade = BusinessFacade.getInstance();
        log.writeLog("Meeting with individual: "+ individual.getCPR() + " Created on"
                + " date: " + time.toString());
    }

    public String messageToMeeting(){
        return ("Vi indkalder dig til møde den: "+ getMeetingTime() + 
                           "\nAddressen: " + getLocation() + "\nDe deltagende er: " + getMeetingParticipants());
    }
    
    public String cancelMeeting(){
        meetingActive = false;
        return ("Mødet den: " + getMeetingTime() + "\n Ved: " + getLocation() + "\nDeltagere: " + getMeetingParticipants() + "\nEr blevet annuleret");
    }

    public String setMeetingTime(LocalDateTime time) {
        dayOfMeeting = time;
        return messageToMeeting();
    }

    @Override
    public String getLocation() {
        return location;
    }

    public String setLocation(String location) {
        this.location = location;
        return messageToMeeting();
    }

    @Override
    public LocalDateTime getMeetingTime() {
        return dayOfMeeting;
    }

    @Override
    public String getMeetingParticipants() {
        return individual.getName() + " og " + caseworker.getName();
    }   
    
    @Override
    public IIndividual getIndividual(){
        return individual;
    }
    
    @Override
    public ICaseworker getCaseworker(){
        return caseworker;
    }
    
    @Override
    public boolean getActive() {
        return meetingActive;
    }
    
    @Override
    public String toString(){
        return "Meeting with individual: " + this.individual.getCPR() + ", on date: "
                + this.dayOfMeeting.toString();
    }

    void setIndividual(IIndividual temp) {
        this.individual = temp;
    }
    
    void saveMeeting(ICase cas, ILog log){
        log.writeLog(this);
        businessFacade.saveMeeting(this, cas, log);
    }

}
