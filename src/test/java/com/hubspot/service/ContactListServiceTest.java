package com.hubspot.service;

import com.hubspot.dto.Contact;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

class ContactListServiceTest {

    private ContactListService contactListService = new ContactListService();

    @Mock
    private ContactListService mockContactListService;

    private LinkedList<Contact> contacts = new LinkedList<>();

    @BeforeEach
    public void beforeEach() throws ParseException {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void setUp() throws ParseException {
        setContactsWithDaysInWeek();
    }

    private void setContactsWithDaysInWeek() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = sdf.parse("24/08/2018");
        for (int i = 1; i <= 4; i++) {
            Contact contactWithDate = new Contact();
            contactWithDate.setAddedAt(String.valueOf(startDate.getTime()*1000));
            contacts.add(contactWithDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            startDate = new Date(calendar.getTimeInMillis()*1000);
        }
    }

    @Test
    void shouldReturnListOfContactsSortedByDate() throws URISyntaxException {
        doReturn(contacts).when(mockContactListService).getContactsByWeek();
        LinkedList<Contact> filteredContacts = (LinkedList<Contact>) contactListService.getContactsByWeek();
        Date firstDate = new Date(Long.parseLong(filteredContacts.get(0).getAddedAt()) * 1000L);
        Date secondDate = new Date(Long.parseLong(filteredContacts.get(1).getAddedAt()) * 1000L);
        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(firstDate);
        Calendar secondCalendar = Calendar.getInstance();
        secondCalendar.setTime(secondDate);

        assertTrue(firstCalendar.before(secondCalendar));

    }
}