package pl.contactapp.contactapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.contactapp.contactapp.entity.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	public List<Contact> findAllByOrderByLastNameAsc();
}
