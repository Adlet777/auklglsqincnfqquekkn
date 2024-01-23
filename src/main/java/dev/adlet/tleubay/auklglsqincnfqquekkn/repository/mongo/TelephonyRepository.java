package dev.adlet.tleubay.auklglsqincnfqquekkn.repository.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.mongo.Telephony;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephonyRepository extends MongoRepository<Telephony, Long> {
}
