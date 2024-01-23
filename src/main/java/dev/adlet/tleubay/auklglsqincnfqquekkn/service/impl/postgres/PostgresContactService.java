package dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.PostgresContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostgresContactService implements ContactService {
    private final PostgresContactRepository repository;

    public PostgresContactService(PostgresContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ContactDTO> getAllContacts() {
        List<ContactDTO> contacts = repository.findAll()
                .stream()
                .map(contact -> ContactDTO.builder()
                        .id(contact.getId())
                        .name(contact.getName())
                        .yearOfBirth(contact.getYearOfBirth())
                        .phoneNumber(contact.getPhoneNumber())
                        .secondPhoneNumber(contact.getSecondPhoneNumber())
                        .build()).toList();
        return new PageImpl<>(contacts);
    }

    @Override
    public Optional<ContactDTO> getContactById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<ContactDTO> getContactByPhoneNumber(String phoneNumber) {
        return Optional.empty();
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
