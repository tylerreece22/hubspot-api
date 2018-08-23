package com.hubspot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.dto.Contact;
import com.hubspot.dto.FormSubmission;
import com.hubspot.dto.IdentityProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class ContactListService {
//    @Autowired
//    private RestTemplate restTemplate;

    public List<Contact> getContactList() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        List<Contact> contacts = new ArrayList<>();
        ObjectMapper jsonObjectMapper = new ObjectMapper();

        JsonNode jsonContacts = restTemplate.getForObject(new URI("https://api.hubapi.com/contacts/v1/lists/724/contacts/all?hapikey=d0fad6c4-faa9-4e9d-89d1-0f8221e3ee96"), JsonNode.class);
        JsonNode actualContacts = jsonContacts.get("contacts");
        log.error(actualContacts.toString());
        actualContacts.forEach(jsonContact -> {
            log.info("Retrived Contact from https://api.hubapi.com/contacts/v1/lists/724/contacts/all\n" + jsonContact);
            Contact contact = jsonObjectMapper.convertValue(jsonContact, Contact.class);

            List<FormSubmission> formSubmissions = new LinkedList<>();
            jsonObjectMapper.convertValue(jsonContact, Contact.class);
            jsonContact.get("form-submissions")
                    .forEach(formSubmission -> formSubmissions.add(jsonObjectMapper.convertValue(formSubmission, FormSubmission.class)));
            contact.setFormSubmissions(formSubmissions);

            List<IdentityProfile> identityProfiles = new LinkedList<>();
            jsonContact.get("identity-profiles")
                    .forEach(identityProfile -> identityProfiles.add(jsonObjectMapper.convertValue(identityProfile, IdentityProfile.class)));
            contact.setIdentityProfiles(identityProfiles);

            contacts.add(contact);
        });

        return contacts;
    }

}
