package com.hubspot.controller;

import com.hubspot.dto.Contact;
import com.hubspot.service.ContactListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URISyntaxException;

@Controller
public class ContactListController {

    @Autowired
    private ContactListService contactListService;

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact getContactList() throws URISyntaxException {
        return contactListService.getContactList();
    }
}
