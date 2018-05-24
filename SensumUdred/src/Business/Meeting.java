/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.IBusiness;
import Acq.ICaseworker;
import Acq.IIndividual;
import java.time.LocalDateTime;
import Acq.IMeeting;
import Acq.ILog;

/**
 *
 * @author Nicolai
 */
public class Meeting implements IMeeting {

    private LocalDateTime dayOfMeeting;
    private IIndividual individual;
    private ICaseworker caseworker;
    private String location;
    private boolean meetingActive;
        
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
        this.individual = individual;
        this.caseworker = caseworker;
        meetingActive = true;
    }
    
    Meeting(){
    }
    
    public void saveMeeting(){   
        //TODO: fix
    }
    
    /**
     * There is created a log after a meeting is created, and that need to be saved in the datebase, and this method does that
     * @param log is what track who made the meeting
     */
    public void saveLog(ILog log){
        //TODO: fix
    }
    
    public String messageToMeeting(){
        return ("Vi indkalder dig til møde den: "+ getMeetingTime() + 
                           "\nAddressen: " + getLocation() + "\nDe deltagende er: " + getMeetingParticipants());
    }
    
    @Override
    public String cancelMeeting(){
        meetingActive = false;
        return ("Mødet den: " + getMeetingTime() + "\n Ved: " + getLocation() + "\nDeltagere: " + getMeetingParticipants() + "\nEr blevet annuleret");
    }

    @Override
    public String setMeetingTime(LocalDateTime time) {
        dayOfMeeting = time;
        return messageToMeeting();
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
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
    
    public IIndividual getIndividual(){
        return individual;
    }
    
    public ICaseworker getCaseworker(){
        return caseworker;
    }
}
