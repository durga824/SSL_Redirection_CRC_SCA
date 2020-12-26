package com.PropertyFile;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile
{
	
	public static Properties prop;
	public PropertyFile()		
	{		
	try
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\pmaniratnam\\eclipse-workspace\\CRC_SCA_SSL_Redirection\\config.properties");
		prop.load(fis);
	}
	catch(IOException e)
	{
		e.getMessage();
	}
    }
}