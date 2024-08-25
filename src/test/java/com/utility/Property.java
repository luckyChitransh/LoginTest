package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property 
{
	public static String validUsername;
	public static String invalidUsername1;
	public static String invalidUsername2;
	public static String validPassword;
	public static String invalidPassword1;
	public static String invalidPassword2;
	
	
	public void readDataFromTextFile() throws Exception
	{
		String fileLocation = System.getProperty("user.dir") + "\\src\\" + "\\test\\" + "\\java\\" + "config.properties";
		
		FileInputStream input = new FileInputStream(fileLocation);
		
		Properties prop = new Properties();
		
		prop.load(input);
		
		validUsername = prop.getProperty("validUsername");
		invalidUsername1 = prop.getProperty("invalidUsername1");
		invalidUsername2 = prop.getProperty("invalidUsername2");
		validPassword = prop.getProperty("validPassword");
		invalidPassword1 = prop.getProperty("invalidPassword1");
		invalidPassword2 = prop.getProperty("invalidPassword2");
		
		
	}
	
}
