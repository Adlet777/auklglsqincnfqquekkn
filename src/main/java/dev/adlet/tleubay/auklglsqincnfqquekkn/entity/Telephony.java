package dev.adlet.tleubay.auklglsqincnfqquekkn.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
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
