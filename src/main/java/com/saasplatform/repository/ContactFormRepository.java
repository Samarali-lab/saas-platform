package com.saasplatform.repository;

import com.saasplatform.model.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {
    List<ContactForm> findByStatus(String status);
    List<ContactForm> findByEmail(String email);
}