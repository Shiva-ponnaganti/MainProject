package com.mainProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;

	public ReadConfig() {
		
		File file =new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
	
		try {
			FileInputStream fis=new FileInputStream(file);
			properties=new Properties();
			properties.load(fis);
		
	
		}catch(IOException e) {
			System.out.println("File not found");
		}
	
	}
	
	
	public String getChromeDriverPath() {
		return properties.getProperty("chromedriverPath");
	}
	
	public String getFirefoxDriverPath() {
		return properties.getProperty("firefoxpath");
	}
	
	public String getApplicationUrl() {
		return properties.getProperty("baseUrl");
	}
	
	public String getUserName() {
		return properties.getProperty("userName");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
	
}

