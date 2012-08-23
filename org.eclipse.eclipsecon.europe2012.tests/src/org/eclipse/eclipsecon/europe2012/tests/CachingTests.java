package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CachingTests {

	private static final String URL = "http://eclipsecon.org/europe2012/json/speakers";
	
	// In case you'd like to see how a proper implementation operates like, 
	// uncomment this line (and comment the URL above)
//	private static final String URL = "https://api.github.com/users/peterfriese/repos";

	@Test
	public void testSpeakersUseETag() {
		String etag = 
			given().
				contentType("application/json").
			when().
				get(URL).
			header("Etag");
		
		assertNotNull("The server didn't send an Etag!", etag);
		
		expect().
			statusCode(304).
		given().
			contentType("application/json").
			header("If-None-Match", etag).
		when().
			get(URL);
	}

}
