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

public class SessionStructuralTests {

	@Test
	public void testSessionsCollectionIsAnArray() {
		String json = get(BASE_URL + "/sessions").asString();
		Object object = from(json).get();
		assertThat(object, is(instanceOf(ArrayList.class)));
	}
	
	@Test
	public void testAllSessionsStructure() {
		List<HashMap<String, String>> list = get(BASE_URL + "/sessions").jsonPath().getList("");
		assertThat(list.size(), is(greaterThan(1)));
		for (HashMap<String, String> session : list) {
			if (!((String)session.get("type")).equals("schedule_item")) {
				assertThat(session, hasKey("category"));
				assertThat(session, hasKey("presenter"));
			}
			assertThat(session, hasKey("id"));
			assertThat(session, hasKey("title"));
			assertThat(session, hasKey("abstract"));
			assertThat(session, hasKey("room"));
			assertThat(session, hasKey("type"));
			assertThat(session, hasKey("date"));
			assertThat(session, hasKey("start"));
			assertThat(session, hasKey("end"));
			
		}
	}

}
