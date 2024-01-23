package dev.adlet.tleubay.auklglsqincnfqquekkn.service;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.Contact;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.ContactRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service that creates data in tables & collections in DBs
 * todo: finish this service
 */
@Service
public class DataInsertionService {
    public DataInsertionService(ContactRepository mongoRepository, dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.ContactRepository postgresRepository) {
        this.mongoRepository = mongoRepository;
        this.postgresRepository = postgresRepository;
    }

    private ContactRepository mongoRepository;
    private dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.ContactRepository postgresRepository;

    @PostConstruct
    public void insertMongoData() {

        if (mongoRepository.findAll().isEmpty()) {

            Contact firstContact = Contact.builder()
                    .name("first")
                    .yearOfBirth(1999L)
                    .phoneNumber("+7(777)-777-7771")
                    .secondPhoneNumber("+7(777)-777-7751")
                    .build();

            Contact secondContact = Contact.builder()
                    .name("second")
                    .yearOfBirth(1999L)
                    .phoneNumber("+7(777)-777-7772")
                    .secondPhoneNumber("+7(777)-777-7752")
                    .build();

            Contact thirdContact = Contact.builder()
                    .name("third")
                    .yearOfBirth(1999L)
                    .phoneNumber("+7(777)-777-7773")
                    .secondPhoneNumber("+7(777)-777-7753")
                    .build();

            mongoRepository.saveAll(List.of(firstContact, secondContact, thirdContact));
        }
    }

    @PostConstruct
    public void insertPostgresData() {

        if (postgresRepository.findAll().isEmpty()) {

            dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.Contact firstContact =
                    dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.Contact.builder()
                    .name("first")
                    .yearOfBirth(1999L)
                    .phoneNumber("+7(777)-777-7771")
                    .secondPhoneNumber("+7(777)-777-7751")
                    .build();

            dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.Contact secondContact =
                    dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.Contact.builder()
                    .name("second")
                    .yearOfBirth(1999L)
                    .phoneNumber("+7(777)-777-7772")
                    .secondPhoneNumber("+7(777)-777-7752")
                    .build();

            dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.Contact thirdContact =
                    dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.Contact.builder()
                    .name("third")
                    .yearOfBirth(1999L)
                    .phoneNumber("+7(777)-777-7773")
                    .secondPhoneNumber("+7(777)-777-7753")
                    .build();

            postgresRepository.saveAll(List.of(firstContact, secondContact, thirdContact));
        }
    }
}
