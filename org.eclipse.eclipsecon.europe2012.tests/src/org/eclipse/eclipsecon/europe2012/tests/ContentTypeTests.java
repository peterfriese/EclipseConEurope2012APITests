package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

public class ContentTypeTests {

	@Test
	public void testProperContentTypeForAllSessions() {
		given().
			contentType("application/json").
		expect().
			contentType("application/json").
		when().
			get("http://eclipsecon.org/europe2012/json/sessions");
	}
	
	@Test
	public void testProperContentTypeForAcceptedSessions() {
		given().
			contentType("application/json").		
		expect().
			contentType("application/json").
		when().
			get("http://eclipsecon.org/europe2012/json/sessions/accepted");
	}
	
	@Test
	public void testProperContentTypeForSpeakers() {
		given().
			contentType("application/json").
		expect().
			contentType("application/json").
		when().
			get("http://eclipsecon.org/europe2012/json/speakers");
	}

}
