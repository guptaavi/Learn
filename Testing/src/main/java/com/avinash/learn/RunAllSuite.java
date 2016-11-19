package com.avinash.learn;

import static org.junit.extensions.cpsuite.SuiteType.JUNIT38_TEST_CLASSES;
import static org.junit.extensions.cpsuite.SuiteType.RUN_WITH_CLASSES;
import static org.junit.extensions.cpsuite.SuiteType.TEST_CLASSES;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.ClassnameFilters;
import org.junit.extensions.cpsuite.ClasspathSuite.IncludeJars;
import org.junit.extensions.cpsuite.ClasspathSuite.SuiteTypes;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(ClasspathSuite.class)
@SuiteTypes({ RUN_WITH_CLASSES, JUNIT38_TEST_CLASSES, TEST_CLASSES })
@IncludeJars(true)
@ClassnameFilters({ "com.avinash.learn.*","!com.avinash.learn.RunAllSuite" })
public class RunAllSuite {
	/* main method not needed, but I use it to run the tests */
	public static void main(String args[]) {
		System.out.println(System.getProperty("java.class.path"));
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(RunAllSuite.class);
	}
}