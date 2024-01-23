package dev.adlet.tleubay.auklglsqincnfqquekkn.service;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import org.springframework.data.domain.Page;

public interface ContactService {
    Page<ContactDTO> getAllContacts();
}
