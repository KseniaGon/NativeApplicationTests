package com.nativeExample.tests;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.nativeExample.framework.ApplicationManager;

public class TestBase {

	protected ApplicationManager applicationManager;
			

	public TestBase() throws IOException {
		Properties properties = new Properties();
		Reader reader = new FileReader(System.getProperty("configFile", "application.properties"));
		properties.load(reader);
		reader.close();
		
		applicationManager = new ApplicationManager(properties);
		
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		//applicationManager.setUp();
	}

	@BeforeSuite
	public void suiteSetUp() throws Exception {
		applicationManager.suiteSetUp();
	}

	@AfterSuite
	public void tearDown() throws Exception {
		applicationManager.suiteTearDown();
	}
	
	protected int getRandomValue(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}	
}