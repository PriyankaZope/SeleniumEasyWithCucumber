
package com.generic.com;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {

	private BaseTest objBaseTest;
	private WebDriverWait objWebDriverWait;
	public Properties objConfig;


	public WrapperFunctions(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	public void webDriverWaitObject()
	{
		 objWebDriverWait = new WebDriverWait(objBaseTest.getDriver(), Integer.parseInt(objBaseTest.objConfig.getProperty("setExplicitlyWait")));
	}
	public boolean checkElementIsDisplayed(By locator) {
		this.setExplicitlyWait(locator);
		boolean blnFlag = false;
		try {
			blnFlag = objBaseTest.getDriver().findElement(locator).isDisplayed();
			return blnFlag;

		} catch (Exception exception) {
			System.out.println("I got Exception " + exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}

	}

	public void scrollPage(int intScrollBy) {
		JavascriptExecutor js = (JavascriptExecutor) objBaseTest.getDriver();
		js.executeScript("window.scrollBy(0," + intScrollBy + ")");
	}

	public void setImplicitlyWait(int intTimeInSecond) {
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(intTimeInSecond, TimeUnit.SECONDS);
	}
	
	public void setExplicitlyWait(By locator)  throws NotFoundException
	{
		this.webDriverWaitObject();
		objWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void checkElementpresenceInDom(By locator) throws NotFoundException
	{
		this.webDriverWaitObject();
		objWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitUntilElementSelect(By locator)
	{
	this.webDriverWaitObject();
	objWebDriverWait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	public void waitUntilButtonIsClickable(By locator)
	{
		this.webDriverWaitObject();
		objWebDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void setFluentWait(By locator)
	{
		Wait<WebDriver> wait =new FluentWait<WebDriver>(objBaseTest.getDriver())
				.withTimeout(Duration.ofSeconds(90))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class,TimeoutException.class);
		
		WebElement webElement =wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				return objBaseTest.getDriver().findElement(locator);
			}
		});
	}
	
	public void navigateToHomePage()
	{
		
		objBaseTest.getDriver().findElement(By.xpath("//a[text()='Demo Home']")).click();
	}
	
	public void checkElementVisibility(By locator,int timeUnitInSecond) {
		WebDriverWait wait = new WebDriverWait(objBaseTest.getDriver(), timeUnitInSecond);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public boolean checkElementDisplayed(By locator){
		boolean blnFlag=false;
	try {
		this.checkElementVisibility(locator, Integer.parseInt(objBaseTest.objConfig.getProperty("explicitwait")));
		 WebDriverWait wait = new WebDriverWait(objBaseTest.getDriver(), 5);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	     WebElement webElement = objBaseTest.getDriver().findElement(locator);
	  blnFlag=   webElement.isDisplayed();
		return blnFlag;
	} catch (Exception exception) {
		System.out.println("I got Exception : "+exception.getMessage());
		return blnFlag;
	}
	}
	public boolean click(By locator){
		try {
			this.checkElementDisplayed(locator);
			WebElement webElement = objBaseTest.getDriver().findElement(locator);
			webElement.click();
			return true;
		} catch (Exception exception) {
			System.out.println("I got Exception : "+exception.getMessage());
			return false;
		}	
	}
}
