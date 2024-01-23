package dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository(value = "MongoContactRepository")
public interface ContactRepository extends MongoRepository<Contact, UUID> {
}
