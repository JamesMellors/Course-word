package uk.ac.aber.dcs.cs12420.roladex.tests;


import static org.junit.Assert.*;


import org.junit.Before;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.roladex.Contact;
import uk.ac.aber.dcs.cs12420.roladex.Roladex;


public class RoladexTest {

	private Roladex roladex;
	private Object contact;


	@Before
	public void setup(){
		Roladex roladex = new Roladex();
		Contact contact = new Contact("James", "786341");
		roladex.add(contact);
	}
	
	
	@Test
	public void testAddOneContactAndFind(){
		Roladex roladex = new Roladex();
		Contact contact = new Contact("James", "786341");
		roladex.add(contact);
		Contact searchContact = new Contact();
		searchContact.setName("James");
		Contact foundContact = new Contact();
		foundContact = roladex.find(searchContact);
		assertEquals("Expected contact James", contact, foundContact);
	}
	
	
	@Test
	public void testFindNonExistingContact(){
		Roladex roladex = new Roladex();
		Contact contact = new Contact("James", "786341");
		roladex.add(contact);
		Contact searchContact = new Contact();
		searchContact.setName("Craig");
		Contact foundContact = new Contact();
		foundContact = roladex.find(searchContact);
		assertNotSame("Expected contact James", contact, foundContact);
	}
	
}
