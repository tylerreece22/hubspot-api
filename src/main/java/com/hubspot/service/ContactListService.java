package com.hubspot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.dto.Contact;
import com.hubspot.dto.FormSubmission;
import com.hubspot.dto.IdentityProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Slf4j
@Service
public class ContactListService {

    @Value("${contact.url}")
    private String contactUrl;

    public List<Contact> getContactList() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        List<Contact> contacts = new LinkedList<>();
        ObjectMapper jsonObjectMapper = new ObjectMapper();

        JsonNode jsonContacts = restTemplate.getForObject(new URI( "https://api.hubapi.com/contacts/v1/lists/724/contacts/all?hapikey=d0fad6c4-faa9-4e9d-89d1-0f8221e3ee96"), JsonNode.class);
        JsonNode actualContacts = jsonContacts.get("contacts");
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

            HashMap properties = new LinkedHashMap();
            jsonContact.get("properties").fields()
                    .forEachRemaining(property -> properties.put(property .getKey(), property .getValue()));
            contact.setProperties(properties);

            contacts.add(contact);
        });

        return contacts;
    }

    public LinkedList<Contact> getContactsByWeek() throws URISyntaxException {
        Date weekday = new Date();
        LinkedList<Contact> contacts = (LinkedList<Contact>) getContactList();
        contacts.sort(Comparator.comparing(Contact::getAddedAt));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(weekday);
        int weekNumber = calendar.WEEK_OF_YEAR;

        return (LinkedList<Contact>) contacts.stream().filter(contact -> isDayOfWeek(contact, weekNumber));
   }

    private boolean isDayOfWeek(Contact contact, int weekNumber) {
        Calendar contactCalendar = Calendar.getInstance();
        contactCalendar.setTime(new Date(Long.parseLong(contact.getAddedAt()) * 1000L));
        if (weekNumber == contactCalendar.WEEK_OF_YEAR) {
            return true;
        } else {
            return false;
        }

    }

}
