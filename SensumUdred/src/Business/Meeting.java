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
    private IIndividual participant1;
    private ICaseworker participant2;
    private String participants;
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
    Meeting(int year, int month, int day, int hour, int minute, String location, IIndividual participant1, ICaseworker participant2, String participants, ILog log){
        LocalDateTime meetingDate = LocalDateTime.of(year, month, day, hour, minute);
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.participants = participants;
        dayOfMeeting = meetingDate;
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
                           "\nAddressen: " + getLocation() + "\nDe deltagende er: " +participant1.getName()+ " " + getMeetingParticipants()) + " og " + participant2.getName();
    }
    
    @Override
    public String cancelMeeting(){
        meetingActive = false;
        return ("Mødet den: " + getMeetingTime() + "\n Ved: " + getLocation() + "\nMed: " +participant1.getName()+ getMeetingParticipants() + " og " + participant2.getName() + "\nEr blevet annuleret");
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
    public String setMeetingParticipants(String participants) {
        this.participants = participants;
        return messageToMeeting();
    }

    @Override
    public LocalDateTime getMeetingTime() {
        return dayOfMeeting;
    }

    @Override
    public String getMeetingParticipants() {
        return participants;
    }   
    
    public IIndividual getIndividual(){
        return participant1;
    }
    
    public ICaseworker getCaseworker(){
        return participant2;
    }
}
