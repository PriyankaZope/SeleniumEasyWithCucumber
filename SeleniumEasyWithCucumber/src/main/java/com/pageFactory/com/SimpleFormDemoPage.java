package com.pageFactory.com;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.generic.com.BaseTest;

public class SimpleFormDemoPage {

	private BaseTest objBaseTest;

	public boolean blnFlag = false;

	public SimpleFormDemoPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	By loc_HeaderSimpleFormDemoPage = By
			.xpath("//h3[text()='This would be your first example to start with Selenium.']");

	/**
	 * @Description : Verifying Header of Simple form Demo page is Displayed or not
	 */
	public void verifyDemoPageIsDisplayed() {
		objBaseTest.getObjWrapperFunctions().setImplicitlyWait(Integer.parseInt(objBaseTest.objConfig.getProperty("setInmplicitlyWait")));
		blnFlag = objBaseTest.getObjWrapperFunctions().checkElementIsDisplayed(loc_HeaderSimpleFormDemoPage);
		Assert.assertTrue(blnFlag);
	}

	/**
	 * @Description : Verifying Single input text
	 * @param strInputField
	 * @param strExpectedInputFieldText
	 */
	public void verifyInputFields(String strInputField, String strExpectedInputFieldText) // Single and Multi
	{
		By locatorInputFieldText = By.xpath("//div[text()='" + strInputField + "']");
		String actualInputFieldText = objBaseTest.getDriver().findElement(locatorInputFieldText).getText();
		Assert.assertTrue(strExpectedInputFieldText.equals(actualInputFieldText));

	}

	/**
	 * @Description : Enter Text to Single input field
	 * @param strsendkeys
	 */
	public void setSingleInput(String strsendkeys) {
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(strsendkeys);

	}

	/**
	 * @Description : click on show massage button
	 */
	public void clickOnShowMsg() {
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Show Message']")).click();
		JavascriptExecutor js = (JavascriptExecutor) objBaseTest.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
	}

	/**
	 * @Description : verify result of single input field
	 * @param strExpectedMsg
	 */
	public void verifyMsgOfSingleInput(String strExpectedMsg) {

		String strActualText = objBaseTest.getDriver().findElement(By.xpath("//*[@id='display']")).getText();

		System.out.println("Massege is  : " + strExpectedMsg);
		Assert.assertTrue(strExpectedMsg.equals(strActualText));
	}

	/**
	 * @Description : Enter value to input field a and b
	 * @param strLocator
	 * @param strNumber
	 */
	public void setTwoInputFields(String strLocator, String strNumber) {

		objBaseTest.getDriver().findElement(By.xpath("//*[@id='" + strLocator + "']")).sendKeys(strNumber);

	}

	/**
	 * @Description : click on Get Total
	 */
	public void clickOnGetTotal() {
		objBaseTest.getDriver().findElement(By.xpath("//*[text()='Get Total']")).click();
	}

	
	/**
	 * @Description : verify sum of value a and b
	 * @param strNumberOne
	 * @param strNumberTwo
	 */
	public void verifyMsgOfTwoInputField(String strNumberOne, String strNumberTwo) {
		int intResult = Integer.parseInt(strNumberOne) + Integer.parseInt(strNumberTwo);

		String strActualSum = objBaseTest.getDriver().findElement(By.xpath("//*[@id='displayvalue']")).getText();

		System.out.println("Sum is : " + strActualSum);
		Assert.assertTrue(intResult == Integer.parseInt(strActualSum));
	}
}
