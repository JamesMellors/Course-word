package uk.ac.aber.dcs.cs12420.roladex.tests;


import static org.junit.Assert.*;


import org.junit.Test;


import roladex.*;
import uk.ac.aber.dcs.cs12420.roladex.Address;
import uk.ac.aber.dcs.cs12420.roladex.CountryCode;
    
    
public class TestAddress {
	
	@Test
	public void testSetAndGetHouseNameNum() {
	Address address = new Address();
	address.setHouseNameNum("30");
	assertEquals("Incorrect house name or number", "30", address.getHouseNameNum() );
	}
	
	@Test
	public void testSetAndGetStreetName() {
	Address address = new Address();
	address.setStreetName("A street Name");
	assertEquals("Incorrect street name", "A street Name", address.getStreetName() );
	}
	
	@Test
	public void testSetAndGetTown() {
	Address address = new Address();
	address.setTown("A town Name");
	assertEquals("Incorrect town name", "A town Name", address.getTown() );
	}
	
	@Test
	public void testSetAndGetCountry() {
	Address address = new Address();
	address.setCountry(CountryCode.DE);
	assertEquals("Incorrect country code name", CountryCode.DE, address.getCountry() );
	}
	
	@Test
	public void testSetAndGetPostZipCode() {
	Address address = new Address();
	address.setPostZipCode("A Post/Zip Code");
	assertEquals("Incorrect Post/Zip Code", "A Post/Zip Code", address.getPostZipCode() );
	}
	
}
