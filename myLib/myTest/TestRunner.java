package myTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestSuite.class);
		System.out.println("Tests done:  " + result.getRunCount() + "\nFailures: " + result.getFailureCount());
		for (Failure failure : result.getFailures())
			System.out.println("\t" + failure.toString());
		System.out.println("Testing was successful: " + result.wasSuccessful());
	}
}