package dev.adlet.tleubay.auklglsqincnfqquekkn.exception.handler;

import dev.adlet.tleubay.auklglsqincnfqquekkn.exception.ContactException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ContactExceptionHandler {
    private static final Logger logger = Logger.getLogger(ContactExceptionHandler.class.getName());

    @ExceptionHandler(ContactException.class)
    public ResponseEntity<String> handleException(ContactException ex) {
        logger.log(Level.SEVERE, ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
