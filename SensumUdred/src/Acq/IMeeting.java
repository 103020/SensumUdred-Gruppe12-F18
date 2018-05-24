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
    public LocalDateTime getMeetingTime();
        
    /**
     *
     * @return participants for the meeting
     */
    public String getMeetingParticipants();
    public ICaseworker getCaseworker();
    public IIndividual getIndividual();
            
    public boolean getActive();
    
    /**
     * 
     * @return the location or the address the meeting take place at
     */
    public String getLocation();
 
}
