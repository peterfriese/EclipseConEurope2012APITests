package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.given;

import static org.eclipse.eclipsecon.europe2012.tests.Config.*;

import org.junit.Test;

public class ContentTypeTests {

	@Test
	public void testProperContentTypeForAllSessions() {
		given().
			contentType("application/json").
		expect().
			contentType("application/json").
		when().
			get(BASE_URL + "/sessions");
	}
	
	@Test
	public void testProperContentTypeForAcceptedSessions() {
		given().
			contentType("application/json").		
		expect().
			contentType("application/json").
		when().
			get(BASE_URL + "/sessions/accepted");
	}
	
	@Test
	public void testProperContentTypeForSpeakers() {
		given().
			contentType("application/json").
		expect().
			contentType("application/json").
		when().
			get(BASE_URL + "/speakers");
	}

}
