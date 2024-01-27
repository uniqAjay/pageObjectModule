package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonfunction {

	public static WebDriver driver;
	public static Properties envConfig;
	public static Properties loc;
	public static Properties pageElementValues;

	@BeforeTest
	public void setUP() throws IOException {

		if (driver == null) {
			envConfig = loadPropertiesfile("configue.properties");
			loc = loadPropertiesfile("locators.properties");
			pageElementValues = loadPropertiesfile("pageElementValues.properties");
//			
		}

		if (envConfig.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(envConfig.getProperty("Env"));
		} else if (envConfig.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(envConfig.getProperty("Env"));
		} else {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(envConfig.getProperty("Env"));

		}

	}

	public Properties loadPropertiesfile(String propertiesFilePath) {
		String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/configfiles/"
				+ propertiesFilePath;

		return loadPropertiesFromFile(propertyFilePath);

	}

	public Properties loadPropertiesFromFile(String propertyFilePath) {

		Properties properties = new Properties();
		try {
			FileReader file = new FileReader(propertyFilePath);
			properties.load(file);
		} catch (IOException e) {
			throw new RuntimeException();
		}

		return properties;

	}

	@AfterTest
	public void tearUp() {
		driver.quit();

	}

}
