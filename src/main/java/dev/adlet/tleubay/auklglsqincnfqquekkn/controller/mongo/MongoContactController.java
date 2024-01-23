package dev.adlet.tleubay.auklglsqincnfqquekkn.controller.mongo;

import dev.adlet.tleubay.auklglsqincnfqquekkn.dto.ContactDTO;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.ContactService;
import dev.adlet.tleubay.auklglsqincnfqquekkn.service.impl.mongo.MongoContactService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class MongoContactController {
    private final ContactService service;

    public MongoContactController(MongoContactService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ContactDTO>> getAllMongoContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }
}
