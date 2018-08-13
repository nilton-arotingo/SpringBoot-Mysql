package com.nto.dockermysql.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nto.dockermysql.exception.ResourceNotfoundException;
import com.nto.dockermysql.model.Contact;
import com.nto.dockermysql.repository.ContactRepository;

@RestController
@RequestMapping(value="/contact")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping(value="/list")
	public List<Contact> listContact() {
		return contactRepository.findAll();
	}
	
	@PostMapping(value="/save")
	public Contact savContact(@Valid @RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	
	// ----
	
	@GetMapping(value="/find/{id}")
	public Contact findContactbyId(@PathVariable(value="id") Integer id) {
		return contactRepository.findById(id)
				.orElseThrow(()-> new ResourceNotfoundException("Contact", "id", id));
	}
	
	@PutMapping(value="/update/{id}")
	public Contact updatebyId(@PathVariable(value="id") Integer id, @Valid @RequestBody Contact contact) {
		
		Contact contactUpd = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotfoundException("Contact", "id", id));
		
		contactUpd.setUsername(contact.getUsername());
		contactUpd.setCellphone(contact.getCellphone());
		
		contactRepository.save(contactUpd);
		return contactUpd;
	}
	
	// ----
	
	@PutMapping(value="/update")
	public Contact updateContact(@Valid @RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<?> deleteContact(@PathVariable("id") Integer id) {
		
		Contact contact = contactRepository.findById(id)
				.orElseThrow(()-> new ResourceNotfoundException("Contact", "id", id));
		
		if (contact != null) {
			contactRepository.delete(contact);
		}
		
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
	
	
}
