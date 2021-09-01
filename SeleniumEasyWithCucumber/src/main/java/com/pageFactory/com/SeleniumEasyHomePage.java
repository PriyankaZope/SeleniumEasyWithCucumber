package com.pageFactory.com;



import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.generic.com.BaseTest;

public class SeleniumEasyHomePage {

	private BaseTest objBaseTest;

	public boolean blnFlag = false;

	public SeleniumEasyHomePage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}
	
	
	
	By loc_Popup=By.xpath("//a[@id='at-cv-lightbox-close']");

	/**
	 * @Description :Verifying PopUp is Displayed or Not
	 * @return true/False
	 */
	public boolean isPopUPVisible() {
		
		objBaseTest.getObjWrapperFunctions().setExplicitlyWait(loc_Popup);
		try {
			blnFlag = objBaseTest.driver.findElement(loc_Popup).isDisplayed();
			System.out.println("Pop up is Displayed");
			
			return blnFlag;
		} catch (Exception exception) {
			System.out.println("Not Getting Pop Up" + exception.getMessage());
			return blnFlag;
		}
	}

	/**
	 * @Description :Close PopUp if Displayed
	 */
	public void closePopUp() {
		objBaseTest.getObjWrapperFunctions().setFluentWait(loc_Popup);
//		objBaseTest.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if (this.isPopUPVisible()) {
			System.out.println(" Handling Popup");
			objBaseTest.getObjWrapperFunctions().setFluentWait(loc_Popup);
			objBaseTest.getDriver().findElement(loc_Popup).click();
			System.out.println("Popup got handled");
		} else {
			System.out.println("No popup");
			
		}

	}
	public void verifyDemoHomePageHeaderIsDisplayed(){
		By loc_hdr_DemoHomePage=By.xpath("//a[text()='Demo Home']");
		objBaseTest.getDriver().findElement(loc_hdr_DemoHomePage).isDisplayed();

		
	}
	/**
	 * @Description : Click on DropDown
	 * @param strExpectedWebElement
	 */
	public void getAllDropDownsFields(String strExpectedWebElement) {
//		objBaseTest.getObjWrapperFunctions().setImplicitlyWait(10);
		By locators = By.xpath(
				"//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"
						+ strExpectedWebElement + "')]");

		objBaseTest.getObjWrapperFunctions().setFluentWait(locators);
		objBaseTest.getObjWrapperFunctions().checkElementpresenceInDom(locators);
		objBaseTest.getDriver().findElement(locators).click();

	}

	/**
	 * @Description : Select value from DropDown 
	 * @param strValueOfDropDown
	 */
	public void getvaluesOfDropDown(String strValueOfDropDown) {

		By locaterOFValue = By
				.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='" + strValueOfDropDown + "']");


		objBaseTest.getDriver().findElement(locaterOFValue).click();

	}

	/**
	 * @Description : calling Select DropDown And Select value Method using this
	 * @param strSelectDropDown
	 * @param strSelectValue
	 */
	public void getDropdownAndValues(String strSelectDropDown, String strSelectValue) {

		this.getAllDropDownsFields(strSelectDropDown);
		this.getvaluesOfDropDown(strSelectValue);
	}
	/**
	 * @Description : 
	 * @param strTopUpMenu
	 */
public void verifytopUpMenuIsDisplayedAndClickable(String strTopUpMenu){
	By locators = By.xpath(
			"//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"
					+ strTopUpMenu + "')]");

	objBaseTest.getObjWrapperFunctions().setFluentWait(locators);
	objBaseTest.getObjWrapperFunctions().checkElementpresenceInDom(locators);
	Assert.assertTrue(	objBaseTest.getObjWrapperFunctions().checkElementIsDisplayed(locators));
	System.out.println(strTopUpMenu+" is Displayed on Home Page");
	objBaseTest.getObjWrapperFunctions().click(locators);
	System.out.println(strTopUpMenu+" is Clickable on Home Page");

}

}
