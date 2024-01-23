package dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository(value = "PostgresContactRepository")
public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
