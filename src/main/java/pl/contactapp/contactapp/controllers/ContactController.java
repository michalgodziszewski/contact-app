package pl.contactapp.contactapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.contactapp.contactapp.entity.Contact;
import pl.contactapp.contactapp.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping("/list")
	public String listContacts(Model model) {
		
		List<Contact> contacts = contactService.getAllContacts();
		
		model.addAttribute("contacts", contacts);
		model.addAttribute("appName", "Contact App");
		
		return "contacts/contacts-list";
	}
	
	@GetMapping("/addContact")
	public String addContact(Model model) {
		
		Contact contact = new Contact();
		
		model.addAttribute("contact", contact);
		model.addAttribute("appName", "Contact App");
		model.addAttribute("action", "Dodaj Kontakt");
		
		return "contacts/add-contact";
	}
	
	@GetMapping("updateContact")
	public String updateContact(@RequestParam("contactId") int id, Model model) {
		
		Contact contact = contactService.getContactById(id);
		
		model.addAttribute("contact", contact);
		model.addAttribute("appName", "Contact App");
		model.addAttribute("action", "Edytuj Kontakt");
		
		return "contacts/add-contact";
	}
	
	@GetMapping("deleteContact")
	public String deleteContact(@RequestParam("contactId") int id) {
			
		contactService.deleteContactById(id);
		
		return "redirect:/contacts/list";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		
		contactService.saveContact(contact);
		
		return "redirect:/contacts/list";
	}
	
	@GetMapping("/searchContacts")
	public String searchContacts(@RequestParam("searchText") String searchText, Model model) {
		
		List<Contact> contacts = contactService.getSeatchContacts(searchText);
		
		model.addAttribute("contacts", contacts);
		model.addAttribute("appName", "Contact App");
		
		return "contacts/contacts-list";
	}
	
	
	
}
