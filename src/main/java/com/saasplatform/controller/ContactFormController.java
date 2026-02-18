package com.saasplatform.controller;

import com.saasplatform.model.ContactForm;
import com.saasplatform.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/contact-forms")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactFormController {

    @Autowired
    private ContactFormService contactFormService;

    @PostMapping
    public ResponseEntity<?> createContactForm(@RequestBody ContactForm contactForm) {
        try {
            ContactForm createdContactForm = contactFormService.createContactForm(contactForm);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Contact form submitted successfully");
            response.put("contactForm", createdContactForm);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error submitting contact form: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContactFormById(@PathVariable Long id) {
        try {
            Optional<ContactForm> contactForm = contactFormService.getContactFormById(id);
            if (contactForm.isPresent()) {
                return ResponseEntity.ok(contactForm.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact form not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching contact form");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllContactForms() {
        try {
            List<ContactForm> contactForms = contactFormService.getAllContactForms();
            return ResponseEntity.ok(contactForms);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching contact forms");
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> getContactFormsByStatus(@PathVariable String status) {
        try {
            List<ContactForm> contactForms = contactFormService.getContactFormsByStatus(status);
            return ResponseEntity.ok(contactForms);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching contact forms");
        }
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<?> resolveContactForm(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String response = request.get("response");
            ContactForm resolvedContactForm = contactFormService.resolveContactForm(id, response);
            if (resolvedContactForm != null) {
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("success", true);
                responseMap.put("message", "Contact form resolved successfully");
                responseMap.put("contactForm", resolvedContactForm);
                return ResponseEntity.ok(responseMap);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact form not found");
        } catch (Exception e) {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("success", false);
            responseMap.put("message", "Error resolving contact form: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContactForm(@PathVariable Long id) {
        try {
            Optional<ContactForm> contactForm = contactFormService.getContactFormById(id);
            if (contactForm.isPresent()) {
                contactFormService.deleteContactForm(id);
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Contact form deleted successfully");
                return ResponseEntity.ok(response);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact form not found");
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error deleting contact form: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}