/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.LocalDateTime;

/**
 *
 * @author Nicolai
 */
public class Meeting {

    private LocalDateTime dayOfMeeting;
    private String participants;
    
    void setMeetingTime(LocalDateTime time) {
        dayOfMeeting = time;
    }

    void setMeetingParticipants(String participants) {
        this.participants = participants;
    }

    LocalDateTime getMeetingTime() {
        return dayOfMeeting;
    }

    String getMeetingParticipants() {
        return participants;
    }
    
}
