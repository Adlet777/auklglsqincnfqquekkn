package dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.MongoContact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MongoContactMapper {
    ContactDTO toDTO(MongoContact contact);
}
