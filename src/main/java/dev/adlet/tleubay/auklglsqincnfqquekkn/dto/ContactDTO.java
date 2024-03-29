package dev.adlet.tleubay.auklglsqincnfqquekkn.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ContactDTO {
    private UUID id;
    private String name;
    private Long yearOfBirth;
    private String phoneNumber;
    private String secondPhoneNumber;
}
