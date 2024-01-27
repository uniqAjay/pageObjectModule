package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;


public class LoadProps {
	
	public static Properties props;
	    public String loadConfigueProps(String Key) throws IOException {
		props = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\ajayg\\eclipse-workspace\\PageObjectModule\\src\\test\\resources\\configfiles\\configue.properties");
		props.load(file);
		return props.getProperty(Key);
		
	}
	
	public String loadLoacatorProps(String key ) throws IOException {
		props = new Properties();
		FileInputStream file  = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\locators.properties");
		props.load(file);
		return props.getProperty("key");
	
	}
	

}


