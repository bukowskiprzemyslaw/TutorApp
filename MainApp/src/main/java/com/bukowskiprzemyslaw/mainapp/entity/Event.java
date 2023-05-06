package com.bukowskiprzemyslaw.mainapp.entity;

import com.bukowskiprzemyslaw.mainapp.models.ActionType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long eventId;
    private String ipAddress;
    private ActionType actionType;
    private Long tutorId;
    private LocalDateTime actionDate;


    public Event(String ipAddress, ActionType actionType, Long tutorId, LocalDateTime actionDate) {
        this.ipAddress = ipAddress;
        this.actionType = actionType;
        this.tutorId = tutorId;
        this.actionDate = actionDate;
    }

    public Event() {
    }
    // getters and setters


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }


    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}


