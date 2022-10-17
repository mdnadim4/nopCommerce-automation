package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getBaseUrl() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String  getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

}
