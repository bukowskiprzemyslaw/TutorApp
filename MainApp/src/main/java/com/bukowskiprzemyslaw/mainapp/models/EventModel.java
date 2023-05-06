package com.bukowskiprzemyslaw.mainapp.models;

import com.bukowskiprzemyslaw.mainapp.models.ActionType;

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
