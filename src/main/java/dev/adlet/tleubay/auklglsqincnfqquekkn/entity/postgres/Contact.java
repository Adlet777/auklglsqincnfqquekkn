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
public class Contact extends ContactSuperClass {
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_birth")
    private Long yearOfBirth;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "second_phone_number")
    private String secondPhoneNumber;
}
