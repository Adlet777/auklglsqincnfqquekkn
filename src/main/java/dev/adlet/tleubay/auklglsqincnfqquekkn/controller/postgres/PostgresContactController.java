package dev.adlet.tleubay.auklglsqincnfqquekkn.controller.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.postgres.PostgresContactService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postgres")
public class PostgresContactController {
    private final ContactService service;

    public PostgresContactController(PostgresContactService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ContactDTO>> getAllPostgresContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }
}
