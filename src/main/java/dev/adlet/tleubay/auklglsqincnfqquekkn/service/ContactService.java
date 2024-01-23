package dev.adlet.tleubay.auklglsqincnfqquekkn.service;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface ContactService {
    Page<ContactDTO> getAllContacts();  //todo: add Filter

    Optional<ContactDTO> getContactById(UUID id);

    Optional<ContactDTO> getContactByPhoneNumber(String phoneNumber);

    void deleteContactById(UUID id);

    void deleteContactByPhoneNumber(String phoneNumber);

    ContactDTO updateContactById(UUID id);

    ContactDTO updateContactByPhoneNumber(String phoneNumber);
}
