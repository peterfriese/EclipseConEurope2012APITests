package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.get;
import static org.eclipse.eclipsecon.europe2012.tests.Config.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;

public class SessionDiacriticsTests {
	
	private static JsonPath jsonPath;

	@BeforeClass
	public static void fetchSessions() {
		System.out.println("Fetching list of sessions, stand by...");
		jsonPath = get(BASE_URL + SESSIONS).jsonPath();
	}
	
	@Test
	public void testSeminarraeume() {
		HashMap<String, String> sessionScoutContinued = jsonPath.get("find { ele -> ele.id == '1104'}");
		assertThat(sessionScoutContinued.get("room"), startsWith("Seminarräume"));
	}
	
}
