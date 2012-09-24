package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.get;
import static org.eclipse.eclipsecon.europe2012.tests.Config.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;

public class SessionTimeTests {
	
	private static JsonPath jsonPath;

	@BeforeClass
	public static void fetchSessions() {
		System.out.println("Fetching list of sessions, stand by...");
		jsonPath = get(BASE_URL + "/sessions").jsonPath();
	}
	
	@Test
	public void testOSGi() {
		HashMap<String, String> sessionModularOSGi = jsonPath.get("find { ele -> ele.id == '839'}");
		assertThat(sessionModularOSGi.get("start"), is("10:30:00"));
	}
	
	@Test
	public void testOrion() {
		HashMap<String, String> sessionModularOSGi = jsonPath.get("find { ele -> ele.id == '923'}");
		assertThat(sessionModularOSGi.get("start"), is("09:00:00"));
	}
	
}
