package com.hubspot.controller;

import com.hubspot.dto.Contact;
import com.hubspot.service.ContactListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ContactControllerTest {

    @Mock
    private ContactListController contactListController;
    @Mock
    private ContactListService contactListService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        doReturn(new Contact()).when(contactListController).getContactList();
        contactListController.getContactList();
    }

    @Test
    public void contactListEndpointShouldWork() {
        verify(contactListController).getContactList();
    }

    @Test
    public void contactListServiceShouldCallContactList() {
        verify(contactListService).getContactList();
    }

    @Test
    public void contactListServiceShouldHitHubSpotApi() {

    }

}