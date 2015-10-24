package com.nativeExample.framework;

import com.nativeExample.utils.AutoItHelper;

public class ContactHelper {

	private static final String LAST_NAME_ID = "TDBEdit11";
	private static final String FIRST_NAME_ID = "TDBEdit12";
	private AutoItHelper autoItHelper;
	private static final int windowTimeout = 2000;

	public ContactHelper(AutoItHelper autoItHelper) {
		this.autoItHelper = autoItHelper;
	}

	public void create(Contact contact) {
		ensureMainWindow()
			.click("TRbButton4")
			.winWaitAndActivate("Add Contact", "", windowTimeout)
			.send(FIRST_NAME_ID, contact.getFirstName())
			.send(LAST_NAME_ID, contact.getLastName())
			.click("TRbButton1");
	}

	protected AutoItHelper ensureMainWindow() {
		return autoItHelper
			.winWaitAndActivate("AddressBook Portable", "" , windowTimeout);
	}

	public void deleteAllContacts() {
		ensureMainWindow()
			.click("Select All")
			.click("Delete")
			.winWaitAndActivate("Confirm", "" , windowTimeout)
			.click("TButton2"); //??? "Yes" doesn't work for some reason

		ensureMainWindow();
	}

	public Contact getFirstContact() {
		Contact contact = new Contact();
		
		ensureMainWindow()
			.click("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", windowTimeout);
		
		contact = contact
			.withFirstName(autoItHelper.getText(FIRST_NAME_ID))
			.withLastName(autoItHelper.getText(LAST_NAME_ID));
			
		
		autoItHelper	
			.click("Cancel");
		
		ensureMainWindow();
			
		return contact;
	}

}
