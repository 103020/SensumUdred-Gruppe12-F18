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
     */
    void setMeetingTime(LocalDateTime time);
    
    /**
     *  
     * @return the meeting date 
     */
    LocalDateTime getMeetingTime();

    /**
     * Set the participants for the meeting with a String
     * @param participants are them who are in the meeting
     */
    void setMeetingParticipants(String participants);
        
    /**
     *
     * @return participants for the meeting
     */
    String getMeetingParticipants();
    
    /**
     * 
     * @return the location or the addresse the meeting take place at
     */
    String getLocation();
    
    /**
     * Set the location of the meeting
     * @param location is the addresse the meeting take place at
     */
    void setLocation(String location);
 
}
