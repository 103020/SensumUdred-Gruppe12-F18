/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acq.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Nicolai
 */
public class MeetingData implements IMeeting {

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
    MeetingData(int year, int month, int day, int hour, int minute, String location, 
            IIndividual participant1, ICaseworker participant2, String participants){
        LocalDateTime meetingDate = LocalDateTime.of(year, month, day, hour, minute);
        this.participant1 = participant1;
        this.participant2 = participant2;
        dayOfMeeting = meetingDate;
        meetingActive = true;
    }
    
    MeetingData(){
    }
    
    void setAttributes(String dateandtime, IIndividual participant1, ICaseworker participant2,
            String location, boolean meetingActive){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        dayOfMeeting = LocalDateTime.parse(dateandtime, formatter);
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.location = location;
        this.meetingActive = meetingActive;
    }

    @Override
    public String getLocation() {
        return location;
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
