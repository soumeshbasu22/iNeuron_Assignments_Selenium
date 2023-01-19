package com.iNeuron_Assignments_Selenium.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver browser(String browsername,WebDriver driver,String url) {
		if(browsername.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); 
		}
		else if(browsername.equals("headless")) {
			ChromeOptions option=new ChromeOptions();
			option.setHeadless(true);
			driver=new ChromeDriver(option);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		return driver;
	}
}
