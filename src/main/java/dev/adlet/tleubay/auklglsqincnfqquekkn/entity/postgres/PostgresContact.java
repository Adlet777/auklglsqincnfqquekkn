package dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.ContactSuperClass;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostgresContact extends ContactSuperClass {
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_birth")
    private Long yearOfBirth;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Column(name = "second_phone_number", unique = true)
    private String secondPhoneNumber;
}
