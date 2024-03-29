package dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.FilterDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByIdRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByPhoneNumberRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.MongoContact;
import dev.adlet.tleubay.auklglsqincnfqquekkn.exception.ContactException;
import dev.adlet.tleubay.auklglsqincnfqquekkn.mapper.mongo.MongoContactMapper;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.MongoContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import dev.adlet.tleubay.auklglsqincnfqquekkn.util.ContactsCustomPaginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MongoContactService implements ContactService {
    private final MongoContactRepository repository;
    @Autowired
    private MongoContactMapper mapper;

    public MongoContactService(MongoContactRepository repository) {
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
        MongoContact contact = repository.findById(id).orElseThrow(() ->
                new ContactException(String.format("Contact with id={%s} not found", id)));
        return mapper.toDTO(contact);
    }

    @Override
    public ContactDTO getContactByPhoneNumber(String phoneNumber) {
        MongoContact contact = repository.findByPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber)
                .orElseThrow(() ->
                new ContactException(String.format("Contact with phone_number={%s} not found", phoneNumber)));

        return mapper.toDTO(contact);
    }

    @Override
    public void deleteContactById(UUID id) {
        MongoContact contact = repository.findById(id).orElseThrow(() ->
                new ContactException(String.format("Contact with id={%s} not found", id)));
        repository.delete(contact);
    }

    @Override
    public void deleteContactByPhoneNumber(String phoneNumber) {
        MongoContact contact = repository.findByPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber)
                .orElseThrow(() ->
                new ContactException(String.format("Contact with phone_number={%s} not found", phoneNumber)));
        repository.delete(contact);
    }

    @Override
    public ContactDTO updateContactById(UUID id, UpdateContactByIdRequest requestBody) {
        MongoContact updatedContact = repository.findById(id).orElseThrow(() ->
                new ContactException(String.format("Contact with id={%s} not found", id)));
        mapper.toEntity(updatedContact, requestBody);
        repository.save(updatedContact);

        return mapper.toDTO(updatedContact);
    }

    @Override
    public ContactDTO updateContactByPhoneNumber(String phoneNumber, UpdateContactByPhoneNumberRequest requestBody) {
        MongoContact updatedContact = repository.findByPhoneNumberOrSecondPhoneNumber(phoneNumber, phoneNumber)
                .orElseThrow(() ->
                        new ContactException(String.format("Contact with phone_number={%s} not found", phoneNumber)));

        mapper.toEntity(updatedContact, requestBody);
        repository.save(updatedContact);

        return mapper.toDTO(updatedContact);
    }
}
