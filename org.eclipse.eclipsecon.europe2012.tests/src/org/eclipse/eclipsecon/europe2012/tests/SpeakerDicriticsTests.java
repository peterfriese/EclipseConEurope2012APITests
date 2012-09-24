package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.get;
import static org.eclipse.eclipsecon.europe2012.tests.Config.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;

public class SpeakerDicriticsTests {
	
	private static JsonPath jsonPath;

	@BeforeClass
	public static void fetchSpeakers() {
		System.out.println("Fetching list of speakers, stand by...");
		jsonPath = get(BASE_URL + "/speakers").jsonPath();
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
	
	@Test
	public void testAurelien() {
		HashMap<String, String> speakerAurelien = jsonPath.get("find { ele -> ele.id == '12'}");
		assertThat(speakerAurelien.get("bio"), startsWith("Aurélien"));
	}
}
