package dev.adlet.tleubay.auklglsqincnfqquekkn.repository;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.MongoTelephony;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<MongoTelephony, Long> {
}
