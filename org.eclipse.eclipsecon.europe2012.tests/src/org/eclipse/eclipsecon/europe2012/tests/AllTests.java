package org.eclipse.eclipsecon.europe2012.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CachingTests.class,
	ContentTypeTests.class,
	SessionDicriticsTests.class,
	SessionStructuralTests.class,
	SessionTimeTests.class,
	SpeakerDicriticsTests.class,
	SpeakerStructuralTests.class,
})
public class AllTests {

}
