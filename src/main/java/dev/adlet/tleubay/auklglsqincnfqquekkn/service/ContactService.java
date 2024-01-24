package dev.adlet.tleubay.auklglsqincnfqquekkn.service;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.FilterDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByIdRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByPhoneNumberRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ContactService {
    Page<ContactDTO> getAllContacts(FilterDTO filter);

    ContactDTO getContactById(UUID id);

    ContactDTO getContactByPhoneNumber(String phoneNumber);

    void deleteContactById(UUID id);

    void deleteContactByPhoneNumber(String phoneNumber);

    ContactDTO updateContactById(UUID id, UpdateContactByIdRequest requestBody);

    ContactDTO updateContactByPhoneNumber(String phoneNumber, UpdateContactByPhoneNumberRequest requestBody);
}
