package com.bukowskiprzemyslaw.mainapp.controller;

import com.bukowskiprzemyslaw.mainapp.entity.Event;
import com.bukowskiprzemyslaw.mainapp.entity.Tutor;
import com.bukowskiprzemyslaw.mainapp.models.EventList;
import com.bukowskiprzemyslaw.mainapp.repository.TutorRepository;
import com.bukowskiprzemyslaw.mainapp.service.TutorService;
import com.bukowskiprzemyslaw.mainapp.models.ActionType;
import com.bukowskiprzemyslaw.mainapp.models.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Properties;

@Controller

public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/newtutor")
    public String showAddTutorForm(Tutor tutor) {
        return "add-tutor";
    }

    @PostMapping("/addtutor")
    public String addTutor(@Valid Tutor tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-tutor";
        }

        tutorService.saveTutor(tutor);
        return "redirect:/tutorlist";
    }

    @GetMapping("/tutorlist")
    public String showTutorList(Model model) {
        model.addAttribute("tutors", tutorService.fetchTutorList());
        return "tutor-list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateTutorForm(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorService.fetchTutorById(id);

        model.addAttribute("tutor", tutor);
        return "update-tutor";
    }

    @PostMapping("/update/{id}")
    public String updateTutor(@PathVariable("id") long id, @Valid Tutor tutor,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            tutor.setId(id);
            return "update-tutor";
        }

        tutorService.updateTutor(tutor);
        return "redirect:/tutorlist";
    }

    @GetMapping("/delete/{id}")
    public String deleteTutor(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorService.fetchTutorById(id);
        tutorService.deleteTutor(tutor);
        return "redirect:/tutorlist";
    }

    @GetMapping("/tracking/logs")
    public String showLogs(Model model) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("http://localhost:8081/tracking/logs");

            ResponseEntity<EventList> result = restTemplate.getForEntity(uri, EventList.class);
            EventList events = result.getBody();
            model.addAttribute("events", result.getBody().getEvents());

        } catch (Exception e) {
            System.out.println("Error");

        }
        return "logs";
    }

}
