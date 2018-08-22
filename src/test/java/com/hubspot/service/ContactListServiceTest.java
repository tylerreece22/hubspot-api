package com.hubspot.service;

import org.junit.jupiter.api.Test;
import java.net.URISyntaxException;

class ContactListServiceTest {

    private ContactListService contactListService = new ContactListService();

    @Test
    void getContactList() throws URISyntaxException {
        contactListService.getContactList();
    }
}