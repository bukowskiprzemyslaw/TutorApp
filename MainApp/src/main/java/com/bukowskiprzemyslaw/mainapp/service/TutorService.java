package com.bukowskiprzemyslaw.mainapp.service;


import com.bukowskiprzemyslaw.mainapp.entity.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;
public interface TutorService {

    void saveTutor(Tutor tutor);

    void updateTutor(Tutor tutor);

    List< Tutor > fetchTutorList();

    Tutor fetchTutorById(Long id);

    void deleteTutor(Tutor tutor);

}
