package dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.postgres.PostgresContactMapper;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.PostgresContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostgresContactService implements ContactService {
    private final PostgresContactRepository repository;
    @Autowired
    private PostgresContactMapper mapper;

    public PostgresContactService(PostgresContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ContactDTO> getAllContacts() {
        List<ContactDTO> contacts = repository.findAll()
                .stream()
                .map(contact -> mapper.toDTO(contact)).toList();
        return new PageImpl<>(contacts);
    }

    @Override
    public ContactDTO getContactById(UUID id) {
        return null;
    }

    @Override
    public ContactDTO getContactByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public void deleteContactById(UUID id) {

    }

    @Override
    public void deleteContactByPhoneNumber(String phoneNumber) {

    }

    @Override
    public ContactDTO updateContactById(UUID id) {
        return null;
    }

    @Override
    public ContactDTO updateContactByPhoneNumber(String phoneNumber) {
        return null;
    }
}
