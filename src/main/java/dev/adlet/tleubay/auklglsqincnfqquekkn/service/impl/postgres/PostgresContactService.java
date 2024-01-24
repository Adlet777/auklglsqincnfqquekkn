package dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.FilterDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByIdRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByPhoneNumberRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.PostgresContact;
import dev.adlet.tleubay.auklglsqincnfqquekkn.exception.ContactException;
import dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.postgres.PostgresContactMapper;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.PostgresContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import dev.adlet.tleubay.auklglsqincnfqquekkn.util.ContactsCustomPaginator;
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
    public Page<ContactDTO> getAllContacts(FilterDTO filter) {
        List<ContactDTO> contacts = repository.findAll()
                .stream()
                .map(mapper::toDTO).toList();

        contacts = ContactsCustomPaginator.paginateContactsByFilter(contacts, filter);
        return new PageImpl<>(contacts);
    }

    @Override
    public ContactDTO getContactById(UUID id) {
        PostgresContact contact = repository.findById(id).orElseThrow(() ->
                new ContactException(String.format("Contact with id={%s} not found", id)));
        return mapper.toDTO(contact);
    }

    @Override
    public ContactDTO getContactByPhoneNumber(String phoneNumber) {
        PostgresContact contact = repository.findByPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber)
                .orElseThrow(() ->
                        new ContactException(String.format("Contact with phone_number={%s} not found", phoneNumber)));

        return mapper.toDTO(contact);
    }

    @Override
    public void deleteContactById(UUID id) {
        PostgresContact contact = repository.findById(id).orElseThrow(() ->
                new ContactException(String.format("Contact with id={%s} not found", id)));
        repository.delete(contact);
    }

    @Override
    public void deleteContactByPhoneNumber(String phoneNumber) {
        PostgresContact contact = repository.findByPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber)
                .orElseThrow(() ->
                        new ContactException(String.format("Contact with phone_number={%s} not found", phoneNumber)));
        repository.delete(contact);
    }

    @Override
    public ContactDTO updateContactById(UUID id, UpdateContactByIdRequest requestBody) {
        PostgresContact updatedContact = repository.findById(id).orElseThrow(() ->
                new ContactException(String.format("Contact with id={%s} not found", id)));
        mapper.toEntity(updatedContact, requestBody);
        repository.save(updatedContact);

        return mapper.toDTO(updatedContact);
    }

    @Override
    public ContactDTO updateContactByPhoneNumber(String phoneNumber, UpdateContactByPhoneNumberRequest requestBody) {
        PostgresContact updatedContact = repository.findByPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber)
                .orElseThrow(() ->
                        new ContactException(String.format("Contact with phone_number={%s} not found", phoneNumber)));

        mapper.toEntity(updatedContact, requestBody);
        repository.save(updatedContact);

        return mapper.toDTO(updatedContact);
    }
}
