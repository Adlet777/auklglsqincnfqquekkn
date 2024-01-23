package dev.adlet.tleubay.auklglsqincnfqquekkn.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ContactDTO {
    @Nonnull
    private UUID id;
    @NotBlank
    private String name;
    @Nonnull
    @Positive
    private Long yearOfBirth;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String secondPhoneNumber;
}
