package org.eclipse.eclipsecon.europe2012.tests;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import static org.eclipse.eclipsecon.europe2012.tests.Config.BASE_URL;

public class SpeakerStructuralTests {

	@Test
	public void testSpeakersCollectionIsAnArray() {
		String json = get(BASE_URL + "/speakers").asString();
		Object object = from(json).get();
		assertThat(object, is(instanceOf(ArrayList.class)));
	}
	
	@Test
	public void testAllSpeakersStructure() {
		List<HashMap<String, String>> list = get(BASE_URL + "/speakers").jsonPath().getList("");
		assertThat(list.size(), is(greaterThan(1)));
		for (HashMap<String, String> speaker : list) {
			assertThat(speaker, hasKey("id"));
			assertThat(speaker, hasKey("fullname"));
			assertThat(speaker, hasKey("twitter"));
			assertThat(speaker, hasKey("picture"));
			assertThat(speaker, hasKey("bio"));
			assertThat(speaker, hasKey("jobtitle"));
			assertThat(speaker, hasKey("organization"));
			assertThat(speaker, hasKey("interests"));
		}
	}

}
