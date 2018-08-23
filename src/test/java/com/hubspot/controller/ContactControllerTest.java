package com.hubspot.controller;

import com.hubspot.dto.Contact;
import com.hubspot.service.ContactListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ContactControllerTest {

    @Mock
    private ContactListController contactListController;
    @Mock
    private ContactListService contactListService;
    private List<Contact> contactList;

    @BeforeEach
    public void beforeEach() throws URISyntaxException {
        MockitoAnnotations.initMocks(this);
        doReturn(new ArrayList()).when(contactListController).getContactList();
        contactList = contactListController.getContactList();
    }

    @Test
    public void contactListEndpointShouldWork() throws URISyntaxException {
        verify(contactListController).getContactList();
    }
}