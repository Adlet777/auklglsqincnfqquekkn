package dev.adlet.tleubay.auklglsqincnfqquekkn.controller.postgres;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.postgres.PostgresContactService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getPostgresContactById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getContactById(id));
    }

    @GetMapping("/phone-number/{phoneNumber}")
    public ResponseEntity<ContactDTO> getPostgresContactByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(service.getContactByPhoneNumber(phoneNumber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostgresContactById(@PathVariable UUID id) {
        service.deleteContactById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/phone-number/{phoneNumber}")
    public ResponseEntity<Void> deletePostgresContactByPhoneNumber(@PathVariable String phoneNumber) {
        service.deleteContactByPhoneNumber(phoneNumber);
        return ResponseEntity.ok().build();
    }
}
