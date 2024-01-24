package dev.adlet.tleubay.auklglsqincnfqquekkn.controller.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.FilterDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByIdRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.UpdateContactByPhoneNumberRequest;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.mongo.MongoContactService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/mongo")
public class MongoContactController {
    private final ContactService service;

    public MongoContactController(MongoContactService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ContactDTO>> getAllMongoContacts(FilterDTO filter) {
        return ResponseEntity.ok(service.getAllContacts(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getMongoContactById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getContactById(id));
    }

    @GetMapping("/phone-number/{phoneNumber}")
    public ResponseEntity<ContactDTO> getMongoContactByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(service.getContactByPhoneNumber(phoneNumber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMongoContactById(@PathVariable UUID id) {
        service.deleteContactById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/phone-number/{phoneNumber}")
    public ResponseEntity<Void> deleteMongoContactByPhoneNumber(@PathVariable String phoneNumber) {
        service.deleteContactByPhoneNumber(phoneNumber);
        return ResponseEntity.ok().build();
    }

    //todo: add validation
    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateMongoContactById(@PathVariable UUID id, @RequestBody UpdateContactByIdRequest request) {
        ContactDTO updatedContact = service.updateContactById(id, request);
        return ResponseEntity.ok(updatedContact);
    }

    @PutMapping("/phone-number/{phoneNumber}")
    public ResponseEntity<ContactDTO> updateMongoContactByPhoneNumber(@PathVariable String phoneNumber, @RequestBody UpdateContactByPhoneNumberRequest request) {
        ContactDTO updatedContact = service.updateContactByPhoneNumber(phoneNumber, request);
        return ResponseEntity.ok(updatedContact);
    }
}
