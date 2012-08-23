package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;

public class SpeakerDicriticsTests {
	
	private static JsonPath jsonPath;

	@BeforeClass
	public static void fetchSpeakers() {
		System.out.println("Fetching list of speakers, stand by...");
		jsonPath = get("http://eclipsecon.org/europe2012/json/speakers").jsonPath();
	}
	
	@Test
	public void testEsa() {
		HashMap<String, String> speakerEsa = jsonPath.get("find { ele -> ele.id == '402'}");
		assertThat(speakerEsa.get("fullname"), is("Esa Ryhänen"));
	}
	
	@Test
	public void testJoerg() {
		HashMap<String, String> speakerJoerg = jsonPath.get("find { ele -> ele.id == '981'}");
		assertThat(speakerJoerg.get("fullname"), is("Jörg Lamprecht"));
	}
}
