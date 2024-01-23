package dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByIdRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByPhoneNumberRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.MongoContact;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface MongoContactMapper {
    ContactDTO toDTO(MongoContact contact);
    MongoContact toEntity(UUID id, UpdateContactByIdRequest requestBody);
    MongoContact toEntity(String phoneNumber, UpdateContactByPhoneNumberRequest requestBody);
}
