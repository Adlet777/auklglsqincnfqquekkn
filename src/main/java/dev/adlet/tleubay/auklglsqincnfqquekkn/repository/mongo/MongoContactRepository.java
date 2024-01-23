package dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.MongoContact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoContactRepository extends MongoRepository<MongoContact, UUID> {
}
