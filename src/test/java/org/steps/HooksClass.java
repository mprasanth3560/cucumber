package org.steps;

import java.time.Duration;

import org.base.BaseClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public  class HooksClass extends BaseClass {
	
	@Before
	public static void tc01() {
		try {
			System.setProperty("webdriver.chromedriver.com","chromedriver.exe");
			
			driver = new ChromeDriver();
			
			geturl("https://magento.softwaretestingboard.com/?ref=hackernoon.com");
			
			System.out.println("Browser Launched is Successfullly");

		} catch (Exception e) {

			System.out.println("Browser Launced is Not Successfully");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	@After
	public static void tc02() {
		sessionclose();
		terminate();
	}

}
