package pl.contactapp.contactapp.service;

import java.util.List;

import pl.contactapp.contactapp.entity.Contact;

public interface ContactService {
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(int theId);
	
	public void saveContact(Contact theContact);
	
	public void deleteContactById(int theId);

}
