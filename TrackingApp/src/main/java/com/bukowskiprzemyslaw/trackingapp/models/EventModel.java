package com.bukowskiprzemyslaw.trackingapp.models;

public class EventModel {

     public ActionType actionType;
     public Long tutorId;

     public EventModel(ActionType actionType, Long tutorId) {
          this.actionType = actionType;
          this.tutorId = tutorId;
     }

        public EventModel() {
        }
}
