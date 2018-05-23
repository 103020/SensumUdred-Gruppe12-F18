/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acq;

import java.time.LocalDateTime;


/**
 *
 * @author stefan
 */
public interface IMeeting {
    
    /**
     * Set the date of the meeting
     * @param time is the date of the meeting
     * @return 
     */
    public String setMeetingTime(LocalDateTime time);
    
    /**
     *  
     * @return the meeting date 
     */
    public LocalDateTime getMeetingTime();

    /**
     * Set the participants for the meeting with a String
     * @param participants are them who are in the meeting
     * @return a message when new participants are set
     */
    public String setMeetingParticipants(String participants);
        
    /**
     *
     * @return participants for the meeting
     */
    public String getMeetingParticipants();
    
    /**
     * 
     * @return the location or the addresse the meeting take place at
     */
    public String getLocation();
    
    /**
     * Set the location of the meeting
     * @param location is the addresse the meeting take place at
     * @return a message when a new location is set
     */
    public String setLocation(String location);
    
    /**
     *
     * @return a message that shows time of meeting, location and participants
     */
    public String messageToMeeting();

    /**
     *
     * @return a message that tells that the meeting has been cancelled
     */
    public String cancelMeeting();
 
}
