package com.bukowskiprzemyslaw.mainapp.entity;

import com.bukowskiprzemyslaw.mainapp.repository.TutorRepository;

import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotBlank(message = "Proszę podać imię trenera")
    private String firstName;

    @NotBlank(message = "Proszę podać nazwisko trenera")
    private String lastName;

    @Email(message = "Proszę podać adres e-mail w formacie xxx@xx.xx")
    private String email;

    @NotBlank(message = "Proszę podać telefon składający się z 9-11 cyfr")
    private String phoneNumber;

    public Tutor(){
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}

