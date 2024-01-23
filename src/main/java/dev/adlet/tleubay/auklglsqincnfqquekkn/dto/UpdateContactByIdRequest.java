package dev.adlet.tleubay.auklglsqincnfqquekkn.dto;

import lombok.Data;

@Data
public class UpdateContactByIdRequest {
    private String name;
    private Long yearOfBirth;
    private String phoneNumber;
    private String secondPhoneNumber;
}
