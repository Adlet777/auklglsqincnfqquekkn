package dev.adlet.tleubay.auklglsqincnfqquekkn.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class ContactSuperClass {
    @Id
    private UUID id = UUID.randomUUID();
    @CreatedDate
    private LocalDate createdAt;
}
