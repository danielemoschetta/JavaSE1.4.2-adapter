package myTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.BeforeClass;
import org.junit.AfterClass;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ListAdapterTest.class, MapAdapterTest.class })

public class TestSuite {
	@BeforeClass
	public static void starting() {
		System.out.println("Starting JUnit 4 testing suite...");
	}

	@AfterClass
	public static void ending() {
		System.out.println("Testing ended");
	}
}