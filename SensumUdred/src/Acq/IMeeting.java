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
     *  
     * @return the meeting date 
     */
    LocalDateTime getMeetingTime();
   
    /**
     *
     * @return participants for the meeting
     */
    String getMeetingParticipants();
    
    /**
     * 
     * @return the location or the address the meeting take place at
     */
    String getLocation();
}
