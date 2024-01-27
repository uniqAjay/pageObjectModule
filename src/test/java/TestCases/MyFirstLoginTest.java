package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.Commonfunction;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstLoginTest extends Commonfunction {
	@Test
	public void logIn() throws IOException, InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("navigateToTheSignIn"))).click();
		driver.findElement(By.xpath(loc.getProperty("inputId"))).sendKeys(pageElementValues.getProperty("email"));
		driver.findElement(By.xpath(loc.getProperty("nextButton"))).click();
		driver.findElement(By.xpath(loc.getProperty("inputPassword"))).sendKeys(pageElementValues.getProperty("password"));
		driver.findElement(By.xpath(loc.getProperty("signInButton"))).click();

		Thread.sleep(5000);
		

	}

}
