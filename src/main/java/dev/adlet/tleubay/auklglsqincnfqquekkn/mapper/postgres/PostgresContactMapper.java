package dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByIdRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByPhoneNumberRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.PostgresContact;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface PostgresContactMapper {
    ContactDTO toDTO(PostgresContact contact);
    PostgresContact toEntity(@MappingTarget PostgresContact updatedContact, UpdateContactByIdRequest requestBody);
    PostgresContact toEntity(@MappingTarget PostgresContact updatedContact, UpdateContactByPhoneNumberRequest requestBody);
}
