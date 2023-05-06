package com.bukowskiprzemyslaw.mainapp.repository;

import com.bukowskiprzemyslaw.mainapp.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}

