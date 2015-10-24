package com.nativeExample.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import com.nativeExample.framework.Contact;

public class ContactCreateTests extends TestBase {
	public ContactCreateTests() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		applicationManager.getContactHelper().deleteAllContacts();
	}

	@Test
	public void createContact() {
		Contact contact = new Contact()
				.withFirstName(getRandomString("firstName"))
				.withLastName(getRandomString("lastName"));
		applicationManager.getContactHelper().create(contact);
		Contact newContact = applicationManager.getContactHelper().getFirstContact();
		
		assertThat(newContact, equalTo(contact));
	}

	@Test
	public void createContactWithEmptyFirstName() {
		Contact contact = new Contact()
				.withFirstName(getRandomString("firstName"))
				.withLastName(getRandomString("lastName"));
		applicationManager.getContactHelper().create(contact);
		Contact newContact = applicationManager.getContactHelper().getFirstContact();
		
		assertThat(newContact, equalTo(contact));
	}

	protected String getRandomString(String prefix) {
		return String.format("%s%d", prefix, getRandomValue(100));
	}
}
