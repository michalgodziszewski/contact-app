package pl.contactapp.contactapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.contactapp.contactapp.dao.ContactRepository;
import pl.contactapp.contactapp.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactRepository contactRepository;
	
	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Contact getContactById(int theId) {
		Optional<Contact> result = contactRepository.findById(theId);
		
		Contact contact = null;
		if(result.isPresent()) {
			contact = result.get();
		}
		else {
			throw new RuntimeException("Nie znaleziono kontaktu o tym id " + theId);
		}
		return contact;
	}

	@Override
	public void saveContact(Contact theContact) {
		contactRepository.save(theContact);

	}

	@Override
	public void deleteContactById(int theId) {
		contactRepository.deleteById(theId);
	}

}
