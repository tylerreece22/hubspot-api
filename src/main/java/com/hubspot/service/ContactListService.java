package com.hubspot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.dto.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ContactListService {
    @Autowired
    private RestTemplate restTemplate;

    public Contact getContactList() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        List<Contact> contacts = new ArrayList<>();
        ObjectMapper jsonObjectMapper = new ObjectMapper();

        JsonNode jsonContacts = restTemplate.getForObject(new URI("https://api.hubapi.com/contacts/v1/lists/724/contacts/all?hapikey=d0fad6c4-faa9-4e9d-89d1-0f8221e3ee96"), JsonNode.class);
        JsonNode actualContacts = jsonContacts.get("contacts");
        actualContacts.forEach(jsonContact -> contacts.add(jsonObjectMapper.convertValue(jsonContact, Contact.class)));
        log.info("Retrived List<Contact> from https://api.hubapi.com/contacts/v1/lists/724/contacts/all\n");

        return null;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
