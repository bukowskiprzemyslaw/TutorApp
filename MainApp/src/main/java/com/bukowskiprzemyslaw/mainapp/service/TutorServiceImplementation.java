package com.bukowskiprzemyslaw.mainapp.service;

import com.bukowskiprzemyslaw.mainapp.entity.Tutor;
import com.bukowskiprzemyslaw.mainapp.repository.TutorRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.bukowskiprzemyslaw.mainapp.models.ActionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bukowskiprzemyslaw.mainapp.models.EventModel;
import org.yaml.snakeyaml.events.Event;

@Service
public class TutorServiceImplementation implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public List < Tutor > fetchTutorList() {
        return tutorRepository.findAll();
    }

    @Override
    public void saveTutor(Tutor tutor) {
        Tutor persistedTutor = this.tutorRepository.save(tutor);

        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("http://localhost:8081/tracking/event");

            EventModel eventModel = new EventModel(ActionType.ADD_TUTOR, persistedTutor.getId());

            ResponseEntity<Void> result = restTemplate.postForEntity(uri, eventModel, Void.class);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }




    @Override
    public Tutor fetchTutorById(Long id) {
        Optional< Tutor > optional = tutorRepository.findById(id);
        Tutor tutor = null;
        if (optional.isPresent()) {
            tutor = optional.get();
        } else {
            throw new RuntimeException(" Nie znaleziono trenera przypidsanego do ID:: " + id);
        }
        return tutor;
    }

    @Override
    public void deleteTutor(Tutor tutor) {

        tutorRepository.delete(tutor);

        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("http://localhost:8081/tracking/event");

            EventModel eventModel = new EventModel(ActionType.DELETE_TUTOR, tutor.getId());

            ResponseEntity<Void> result = restTemplate.postForEntity(uri, eventModel, Void.class);

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
