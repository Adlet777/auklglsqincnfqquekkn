package dev.adlet.tleubay.auklglsqincnfqquekkn.repository.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.entity.postgres.PostgresContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostgresContactRepository extends JpaRepository<PostgresContact, UUID> {
}
