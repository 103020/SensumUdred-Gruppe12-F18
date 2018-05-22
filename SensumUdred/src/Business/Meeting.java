/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acq.IBusiness;
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
    private boolean meetingActive;
    private IBusiness businessFacade;
    private int caseNum;
        
    /**
     * This is how a meeting the created with the following attributes
     * @param time the date of the meeting
     * @param timeOfMeeting the time of the meeting
     * @param location the addresse the meeting is taking place at
     * @param active when meetings are created it is set as active == true, but when the meeting
     * end or the meeting is cancelled in any shape and form the meeting active is set to false 
     * @param log is what track who made the meeting
     */
    Meeting(int year, int month, int day, int hour, int minute, String location, String participants, ILog log, int caseNum){
        LocalDateTime meetingDate = LocalDateTime.of(year, month, day, hour, minute);
        this.caseNum = caseNum;
        businessFacade = BusinessFacade.getInstance();
        setMeetingTime(meetingDate);
        meetingActive = true;
    }
    
    Meeting(){
    }
    
    public void saveMeeting(){   
        //TO DO: fix
    }
    
    /**
     * There is created a log after a meeting is created, and that need to be saved in the datebase, and this method does that
     * @param log is what track who made the meeting
     */
    public void saveLog(ILog log){
        //TO DO: fix
    }
    
    public void messageToMeeting(){
        String message = ("Vi indkalder dig til møde den: "+ getMeetingTime() + 
                           "\nAddressen: " + getLocation() + "\nDe deltagende er: " + getMeetingParticipants());
        businessFacade.messageToMeeting(caseNum, message);
   
    }
    
    public void cancelMeeting(){
        meetingActive = false;
        String message = "Mødet er blevet annulleret";
        businessFacade.messageToMeeting(caseNum, message);
    }

    @Override
    public void setMeetingTime(LocalDateTime time) {
        dayOfMeeting = time;
        messageToMeeting();
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
        messageToMeeting();
    }

    @Override
    public void setMeetingParticipants(String participants) {
        this.participants = participants;
        messageToMeeting();
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
