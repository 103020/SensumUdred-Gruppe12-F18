/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.LocalDateTime;
import Acq.IMeeting;
import Acq.ILog;

/**
 *
 * @author Nicolai
 */
public class Meeting implements IMeeting {

    private LocalDateTime dayOfMeeting;
    private String participants;
    private String timeOfMeeting;
    private String location;
    private boolean meetingActive = true;
        
    /**
     * This is how a meeting the created with the following attributes
     * @param time the date of the meeting
     * @param timeOfMeeting the time of the meeting
     * @param location the addresse the meeting is taking place at
     * @param active when meetings are created it is set as active == true, but when the meeting
     * end or the meeting is cancelled in any shape and form the meeting active is set to false 
     * @param log is what track who made the meeting
     */
    public void createMeeting(LocalDateTime time, String timeOfMeeting, String location, boolean active, ILog log){  
        this.location = location;
        this.timeOfMeeting = timeOfMeeting;
        this.dayOfMeeting = time;
        this.meetingActive = active;
    }
    
    public void saveMeeting(){       
    }
    
    /**
     * There is created a log after a meeting is created, and that need to be saved in the datebase, and this method does that
     * @param log is what track who made the meeting
     */
    public void saveLog(ILog log){
        
    }
    
    public void messageToMeeting(){
        System.out.println("We would like if you could come to a meeting: "+ getMeetingTime() + 
                           " " + getTimeOfMeeting() + "at: " + getLocation());
   
    }
    
    public void cancelMeeting(){
        if(meetingActive == false){
           System.out.println("The meeting has been cancelled");
        }
    }
        
    @Override
    public String getTimeOfMeeting() {
        return timeOfMeeting;
    }

    @Override
    public void setTimeOfMeeting(String timeOfMeeting) {
        this.timeOfMeeting = timeOfMeeting;
    }
    
    @Override
    public void setMeetingTime(LocalDateTime time) {
        dayOfMeeting = time;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setMeetingParticipants(String participants) {
        this.participants = participants;
    }

    @Override
    public LocalDateTime getMeetingTime() {
        return dayOfMeeting;
    }

    @Override
    public String getMeetingParticipants() {
        return participants;
    }
    
}
