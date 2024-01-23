package dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.MongoContact;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.PostgresContact;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.MongoContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.PostgresContactRepository;
import jakarta.annotation.PostConstruct;

import java.util.List;


/**
 * Service that creates data in tables & collections in DBs
 * todo: add logs
 */
public class DataInsertionServiceImpl {
    private final MongoContactRepository mongoRepository;
    private final PostgresContactRepository postgresRepository;

    public DataInsertionServiceImpl(MongoContactRepository mongoRepository, PostgresContactRepository postgresRepository) {
        this.mongoRepository = mongoRepository;
        this.postgresRepository = postgresRepository;
    }

    @PostConstruct
    public void insertMongoData() {
        if (mongoRepository.findAll().isEmpty()) {
            List<MongoContact> contacts = createMongoContacts();
            mongoRepository.saveAll(contacts);
        }
    }

    @PostConstruct
    public void insertPostgresData() {
        if (postgresRepository.findAll().isEmpty()) {
            List<PostgresContact> contacts = createPostgresContacts();
            postgresRepository.saveAll(contacts);
        }
    }

    private List<MongoContact> createMongoContacts() {
        return List.of(
                new MongoContact("first", 1999L, "+7(777)-777-7771", "+7(777)-777-7751"),
                new MongoContact("second", 1999L, "+7(777)-777-7772", "+7(777)-777-7752"),
                new MongoContact("third", 1999L, "+7(777)-777-7773", "+7(777)-777-7753")
        );
    }

    private List<PostgresContact> createPostgresContacts() {
        return List.of(
                new PostgresContact("first", 1999L, "+7(777)-777-7771", "+7(777)-777-7751"),
                new PostgresContact("second", 1999L, "+7(777)-777-7772", "+7(777)-777-7752"),
                new PostgresContact("third", 1999L, "+7(777)-777-7773", "+7(777)-777-7753")
        );
    }
}
