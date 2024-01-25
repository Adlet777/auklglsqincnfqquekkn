package dev.adlet.tleubay.auklglsqincnfqquekkn.util;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.MongoContact;
import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.PostgresContact;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.MongoContactRepository;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres.PostgresContactRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class that creates data in tables & collections in DBs
 */
@Component
public class InitialDataUploader {
    private static final Logger logger = Logger.getLogger(InitialDataUploader.class.getName());

    private final MongoContactRepository mongoRepository;
    private final PostgresContactRepository postgresRepository;

    @Value(value = "${initial-data-uploader.entries}")
    public int entries;

    public InitialDataUploader(MongoContactRepository mongoRepository, PostgresContactRepository postgresRepository) {
        this.mongoRepository = mongoRepository;
        this.postgresRepository = postgresRepository;
    }

    @PostConstruct
    public void insertMongoData() {
        if (mongoRepository.findAll().size() < entries) {
            List<MongoContact> contacts = createMongoContacts();
            mongoRepository.deleteAll();
            mongoRepository.saveAll(contacts);

            logger.log(Level.INFO, "Mock data inserted into 'contacts' collection in MongoDB database");
        }
    }

    @PostConstruct
    public void insertPostgresData() {
        if (postgresRepository.findAll().size() < entries) {
            List<PostgresContact> contacts = createPostgresContacts();
            postgresRepository.deleteAll();
            postgresRepository.saveAll(contacts);

            logger.log(Level.INFO, "Mock data inserted into 'contacts' table in PostreSQL database");
        }
    }

    private List<MongoContact> createMongoContacts() {
        List<MongoContact> contacts = new ArrayList<>();

        for (int i = 0; i < entries; i++) {
            contacts.add(new MongoContact(
                    String.format("name-%s", i),
                    (long) (1990 + i),
                    String.format("+7(777)-777-777%s", i),
                    String.format("+7(777)-777-775%s", i)));
        }

        return contacts;
    }

    private List<PostgresContact> createPostgresContacts() {
        List<PostgresContact> contacts = new ArrayList<>();

        for (int i = 0; i < entries; i++) {
            contacts.add(new PostgresContact(
                    String.format("name-%s", i),
                    (long) (1990 + i),
                    String.format("+7(777)-777-777%s", i),
                    String.format("+7(777)-777-775%s", i)));
        }

        return contacts;
    }
}
