package dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByIdRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByPhoneNumberRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.PostgresContact;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PostgresContactMapper {
    ContactDTO toDTO(PostgresContact contact);
    PostgresContact toEntity(UUID id, UpdateContactByIdRequest requestBody);
    PostgresContact toEntity(String phoneNumber, UpdateContactByPhoneNumberRequest requestBody);
}
