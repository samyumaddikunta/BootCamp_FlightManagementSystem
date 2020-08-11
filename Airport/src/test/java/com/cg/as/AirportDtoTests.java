package com.cg.as;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.as.dto.Airport;
@RunWith(SpringJUnit4ClassRunner.class)
public class AirportDtoTests {

	@Before
	public void initInput()
	{
		
	}
	@Test()
	public void testFlight()
	{
		Airport airport=new Airport("HYD", "Rajiv", "hyderabad");
		assertNotEquals("CHN",airport.getAirportCode());
		assertNotEquals("Maa",airport.getAirportName());
		assertNotEquals("chennai",airport.getAirportLocation());
	}
	
	@Test
	  public final void testToString() {
		Airport airport=new Airport("HYD", "Rajiv", "hyderabad");
		  String result = String.format("Airport [airportCode=%s,airportName=%s,airportLocation=%s]",
		 airport.getAirportCode(),airport.getAirportName(),airport.getAirportLocation());
		  assertNotEquals(result, airport.toString());
	  }
}
