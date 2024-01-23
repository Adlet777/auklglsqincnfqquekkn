package dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.MongoContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoContactService implements ContactService {
    private final MongoContactRepository repository;

    public MongoContactService(MongoContactRepository repository) {
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
}
