package com.bukowskiprzemyslaw.mainapp.service;

import com.bukowskiprzemyslaw.mainapp.entity.Tutor;
import com.bukowskiprzemyslaw.mainapp.repository.TutorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TutorServiceImplementationTests {

    @Mock
    private TutorRepository tutorRepository;

    private TutorServiceImplementation tutorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        tutorService = new TutorServiceImplementation(tutorRepository);
        tutorService.setTutorRepository(tutorRepository);
    }

    @Test
    public void testFetchTutorList() {
        // Given
        Tutor tutor1 = new Tutor();
        tutor1.setId(1L);
        Tutor tutor2 = new Tutor();
        tutor2.setId(2L);
        List<Tutor> tutorList = Arrays.asList(tutor1, tutor2);

        when(tutorRepository.findAll()).thenReturn(tutorList);

        // When
        List<Tutor> result = tutorService.fetchTutorList();

        // Then
        verify(tutorRepository, times(1)).findAll();
        assertSame(tutorList, result);
    }

    @Test
    public void testSaveTutor() {
        // Given
        Tutor tutor = new Tutor();
        tutor.setId(1L);

        when(tutorRepository.save(any(Tutor.class))).thenReturn(tutor);

        // When
        tutorService.saveTutor(tutor);

        // Then
        verify(tutorRepository, times(1)).save(tutor);
    }

    @Test
    public void testUpdateTutor() {
        // Given
        Tutor tutor = new Tutor();
        tutor.setId(1L);

        when(tutorRepository.save(any(Tutor.class))).thenReturn(tutor);

        // When
        tutorService.updateTutor(tutor);

        // Then
        verify(tutorRepository, times(1)).save(tutor);
    }

    @Test
    public void testFetchTutorById() {
        // Given
        Tutor tutor = new Tutor();
        tutor.setId(1L);

        when(tutorRepository.findById(anyLong())).thenReturn(Optional.of(tutor));

        // When
        Tutor result = tutorService.fetchTutorById(1L);

        // Then
        verify(tutorRepository, times(1)).findById(1L);
        assertSame(tutor, result);
    }

    @Test
    public void testDeleteTutor() {
        // Given
        Tutor tutor = new Tutor();
        tutor.setId(1L);

        // When
        tutorService.deleteTutor(tutor);

        // Then
        verify(tutorRepository, times(1)).delete(tutor);
    }
}