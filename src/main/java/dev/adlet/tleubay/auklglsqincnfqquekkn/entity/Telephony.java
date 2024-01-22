package dev.adlet.tleubay.auklglsqincnfqquekkn.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Telephony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long yearOfBirth;
    private String phoneNumber;
    private String secondPhoneNumber;
    private LocalDate createdAt;
}
