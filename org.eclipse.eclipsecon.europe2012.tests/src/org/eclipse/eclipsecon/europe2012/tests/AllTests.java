package org.eclipse.eclipsecon.europe2012.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CachingTests.class,
	ContentTypeTests.class,
	SessionDiacriticsTests.class,
	SessionStructuralTests.class,
	SessionTimeTests.class,
	SpeakerDiacriticsTests.class,
	SpeakerStructuralTests.class,
})
public class AllTests {

}
