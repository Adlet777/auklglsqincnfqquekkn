package dev.adlet.tleubay.auklglsqincnfqquekkn.service;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.Telephony;
import dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo.TelephonyRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Service that creates data in tables & collections in DBs
 * todo: finish this service
 */
@Service
public class DataInsertionService {
    @Autowired
    private TelephonyRepository repository;

    @PostConstruct
    public void test() {
        Telephony testEntity = new Telephony();
        testEntity.setId(1L);
        testEntity.setName("p2");
        testEntity.setCreatedAt(LocalDate.now());
        testEntity.setPhoneNumber("p1");
        testEntity.setSecondPhoneNumber("p2");

        if (!repository.existsById(1L)) {
            System.out.println("collection created");
            repository.save(testEntity);
        }
    }
}
