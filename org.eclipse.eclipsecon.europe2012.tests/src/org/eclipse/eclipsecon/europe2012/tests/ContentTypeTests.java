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
			contentType("application/json; charset=utf-8").
		when().
			get(BASE_URL + SESSIONS);
	}
	
	@Test
	public void testProperContentTypeForSpeakers() {
		given().
			contentType("application/json").
		expect().
			contentType("application/json; charset=utf-8").
		when().
			get(BASE_URL + SPEAKERS);
	}

}
