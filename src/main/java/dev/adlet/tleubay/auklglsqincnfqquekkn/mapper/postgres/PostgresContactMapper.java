package dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.PostgresContact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostgresContactMapper {
    ContactDTO toDTO(PostgresContact contact);
}
