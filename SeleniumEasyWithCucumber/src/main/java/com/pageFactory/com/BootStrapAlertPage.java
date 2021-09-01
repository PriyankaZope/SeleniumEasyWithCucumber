package com.pageFactory.com;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.com.BaseTest;

public class BootStrapAlertPage {

	private BaseTest objBaseTest;
	public boolean blnAlertMsg = false;
	public boolean blnFlag = false;

	public BootStrapAlertPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	By loc_HeaderBootStrapAlertPage = By.xpath("//h2[text()='Bootstrap Alert messages']");

	
	/**
	 * @Description : Verify Header of Bootstrap Alert Page
	 */
	public void verifyBootStrapAlertTextIsDisplayed() {
		blnFlag = objBaseTest.getObjWrapperFunctions().checkElementIsDisplayed(loc_HeaderBootStrapAlertPage);
		Assert.assertTrue(blnFlag);
		System.out.println("Alert page header is desplayed");
	}

	/**
	 * @Description : click on button
	 * @param strAlertButtonpath
	 */
	public void clickOnMassageButton(String strAlertButtonpath) {
		objBaseTest.getDriver().findElement(By.xpath("//button[@id='" + strAlertButtonpath + "']")).click();
	}

	/**
	 * @Description : verify alert massage is Displayed or not
	 * @param strLocator
	 * @return true/false
	 */
	public boolean verifyAlertMassageISDisplayed(By strLocator)
	{
		blnAlertMsg=false;
		blnAlertMsg=objBaseTest.getDriver().findElement(strLocator).isDisplayed();
		
		return  blnAlertMsg;
	}

	/**
	 * @Description : Get Alert massage for Auto closable Success
	 * @return String Alert Text
	 */
	public String getMassageAlertTextAutoSuccessMassage() {
		By loc_AlertAutoText=By.xpath("//div[@class='alert alert-success alert-autocloseable-success']");
		Assert.assertTrue(verifyAlertMassageISDisplayed(loc_AlertAutoText));
		String strActualMassage = objBaseTest.getDriver().findElement(loc_AlertAutoText).getText();
		
		return strActualMassage;
	}

	public void verifyMassageAlertAutoSuccessMassage(String strExpectedMassageAlert) {
		String strActualMassage = this.getMassageAlertTextAutoSuccessMassage();
		Assert.assertTrue(strExpectedMassageAlert.equals(strActualMassage));
		
	}

	// normal success Massage
	public String getMassageAlertTextNormalSuccessMassage() {
		By loc_AlertText=By.xpath("//div[@class='alert alert-success alert-normal-success']");
		Assert.assertTrue(verifyAlertMassageISDisplayed(loc_AlertText));
		String strActualMassage = objBaseTest.getDriver()
				.findElement(loc_AlertText).getText();
		return strActualMassage;
	}

	public void verifyMassageAlertNormalSuccessMassage(String strExpectedMassageAlert) {
		String strActualMassage = this.getMassageAlertTextNormalSuccessMassage();
		String strReplace = strActualMassage.replace('×', ' ');
		String strTrim = strReplace.trim();

		Assert.assertTrue(strExpectedMassageAlert.equals(strTrim));
	}
	
	
	//auto close warning verifying using pageSource
	public String getMassageAlertTextAutoWarning()
	{
		By locator=By.xpath("//div[@class='alert alert-warning alert-autocloseable-warning']");
		
		Assert.assertTrue(verifyAlertMassageISDisplayed(locator));
		String strActualMassage=objBaseTest.getDriver().findElement(locator).getText();
		
		return strActualMassage;
	}
	
	public void verifyMassageAlertAutoWarningMassage()
	{
		String strActualMassage=this.getMassageAlertTextAutoWarning();
		Assert.assertTrue(objBaseTest.getDriver().getPageSource().contains(strActualMassage));
	}
}
