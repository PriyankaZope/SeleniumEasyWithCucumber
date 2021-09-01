package com.generic.com;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public WebDriver driver = null;
	public Properties objConfig;
	private WrapperFunctions objWrapperFunctions;

	public void initilizeWebEnvirnment() {
		this.loadConfigProperties();
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		objWrapperFunctions = new WrapperFunctions(this);
		this.setObjWrapperFunctions(objWrapperFunctions);
		driver.get(objConfig.getProperty("AUT_URL"));
//		driver.get(url);
		driver.manage().window().maximize();
		
		this.getObjWrapperFunctions().setImplicitlyWait(Integer.parseInt(objConfig.getProperty("setInmplicitlyWait")));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	
	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties"));
			System.out.println("No Exception");
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WrapperFunctions getObjWrapperFunctions() {
		return objWrapperFunctions;
	}

	public void setObjWrapperFunctions(WrapperFunctions objWrapperFunctions) {
		this.objWrapperFunctions = objWrapperFunctions;
	}
	

	public void tearDownEnvirnment() {
		driver.quit();
		System.out.println("Browser closed");
	}

}
