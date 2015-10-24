package com.nativeExample.framework;

import java.io.IOException;
import java.util.Properties;

import com.nativeExample.utils.AutoItHelper;

public class ApplicationManager {
	private ContactHelper contactHelper;
	protected String path;
	private AutoItHelper autoItHelper;
	private static ProcessHelper helper = new ProcessHelper(); 
	

	public ApplicationManager(Properties properties) {
		path = properties.getProperty("applicationPath");
	}

	public ContactHelper getContactHelper() {
		if(contactHelper==null) {
			contactHelper = new ContactHelper(getAutoItHelper());
		}
		return contactHelper;
	}

	private AutoItHelper getAutoItHelper() {
		if( autoItHelper==null ) {
			autoItHelper = new AutoItHelper();
			
		}
		return autoItHelper;
	}

	public void suiteSetUp() throws IOException {
		helper.start(path);
	}
	
	public void suiteTearDown() {
		helper.stop();
	}
}
