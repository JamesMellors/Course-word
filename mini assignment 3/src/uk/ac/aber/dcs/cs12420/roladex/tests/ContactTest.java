package uk.ac.aber.dcs.cs12420.roladex.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import uk.ac.aber.dcs.cs12420.roladex.Contact;

public class ContactTest {

	@Test
	public void testCreateContactWithoutName() {
	Contact contact = new Contact();
	assertEquals("Expected an 'unknown' name",
	"unknown", contact.getName());
	assertNull("Expected phone number to be null", contact.getPhone());
	}
	
	@Test
	public void testCreateContactWithNameAndPhoneNumber() {
	Contact contact = new Contact("Jess", "789902");
	assertEquals("Incorrect name", "Jess", contact.getName());
	assertEquals("Incorrect phone", "789902", contact.getPhone());
	}
	@Test
	public void testSetAndGetName() {
	Contact contact = new Contact();
	contact.setName("Fred");
	assertEquals("Incorrect name", "Fred", contact.getName());
	}
	@Test
	public void testSetAndGetPhone() {
	Contact contact = new Contact();
	contact.setPhone("01234");
	assertEquals("Incorrect number", "01234", contact.getPhone() );
	}
	@Test
	public void testToStringWithEmptyConstructor() {
	Contact contact = new Contact();
	assertEquals("Incorrect string returned", "unknown null",
	contact.toString());
	}
	@Test
	public void testToStringWithNameAndPhoneConstructor() {
	Contact contact = new Contact("Jess", "789902");
	assertEquals("Incorrect string returned", "Jess 789902",
	contact.toString());
	}
	@Test
	public void testEquals() {
	Contact contact1 = new Contact("Jeryy", "12345");
	Contact contact2 = new Contact("Jerry", "12345");
		contact1.equals(contact2);
    }
	@Test
	public void testNotEquals() {
	Contact contact = new Contact("David", "12322");
	assertFalse("Should not be equal", contact.equals(new Contact()));
	}
	@Test
	public void testCompareTo(){
	Contact contact1 = new Contact("Jeryy", "12345");
	Contact contact2 = new Contact("David", "12345");	
	contact1.compareTo(contact2);
	}
	@Test
	public void testStreetName() {
		
	}

}
