package com.hubspot.controller;

import com.hubspot.dto.Contact;
import com.hubspot.service.ContactListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ContactListController {

    @Autowired
    private ContactListService contactListService;

    @RequestMapping(value = "/contact-list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contact> getContactList() throws URISyntaxException {
        return contactListService.getContactList();
    }
}
