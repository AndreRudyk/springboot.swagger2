package io.javabrains.springboot.swagger2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {
    Map<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Contact Contact(@PathVariable String id){
        return contacts.get(id);
    }
    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());

    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
