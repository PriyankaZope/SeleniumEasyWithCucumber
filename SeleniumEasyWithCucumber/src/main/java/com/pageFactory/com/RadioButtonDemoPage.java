package com.pageFactory.com;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.com.BaseTest;

public class RadioButtonDemoPage {

	private BaseTest objBaseTest;

	public boolean blnFlag = false;

	public RadioButtonDemoPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	By loc_HeaderOfRedioButtonDemoPageText=By.xpath("//h3[text()='This is again simple example to start working with radio buttons using Selenium.']");
	
	
	/**
	 * @Description : verify Header of Radio button demo page
	 * @Developer : Rushikesh Thakare
	 */
	public void verifyHeaderTextOfRedioButtonPageIsDisplayed() //verify Header
	{
		
		blnFlag=  objBaseTest.getObjWrapperFunctions().checkElementIsDisplayed(loc_HeaderOfRedioButtonDemoPageText);
	    Assert.assertTrue(blnFlag);
	}
	

	/**
	 * @Description :check is radio button is selected
	 * @Developer : Rushikesh Thakare
	 * @param strLocator
	 * @return true/false
	 */
	public boolean checkIsRadioButtonIsSelected(String strLocator)    //Check radio button is selected
	{
		boolean blnFlag = false;
		blnFlag = objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strLocator+"' and @name='optradio']")).isSelected();
		return blnFlag;
	}
	
	/**
	 * @Description :if Radio Button is not selected click on button
	 * @Developer : Rushikesh Thakare
	 * @param strPath
	 */
	public void clickOnRedioButton(String strPath)
	{
		Assert.assertFalse(this.checkIsRadioButtonIsSelected(strPath));
		objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strPath+"' and @name='optradio']")).click();
	}
	
	
	
	/**
	 * @Description :Click on get Value button
	 * @Developer : Rushikesh Thakare
	 */
	public void clickonGetCheckedValueButton()     
	{
		By loc_GetValues=By.xpath("//*[text()='Get Checked value']");
		objBaseTest.getObjWrapperFunctions().waitUntilButtonIsClickable(loc_GetValues);
		objBaseTest.getDriver().findElement(loc_GetValues).click();
		System.out.println("Get Checked value is clicked");
	}
	
	/**
	 * @Description : verify selected check box
	 * @Developer : Rushikesh Thakare
	 */
	public void checkResult()
	{
		boolean blnresult=objBaseTest.getDriver().findElement(By.xpath("//p[@class='radiobutton']")).isDisplayed();
		String strMasseage=objBaseTest.getDriver().findElement(By.xpath("//p[@class='radiobutton']")).getText();
		Assert.assertTrue(blnresult);
		Assert.assertTrue(strMasseage.contains("Female"));
		objBaseTest.getObjWrapperFunctions().scrollPage(400);
	}
	
	/**
	 * @Description : check radio button for Gender is selected
	 * @param LocatorGender
	 * @return
	 */
	public boolean checkIsGroupRedioButtonGenderIsSelected(String LocatorGender)   // check radio button for Gender isselected
	{

		boolean blnFlagGender = false;

		blnFlagGender = objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+LocatorGender+"' and @name='gender']")).isSelected();

		return blnFlagGender;
	}

	/**
	 * @Description :check radio button for Age is selected
	 * @param locatorAge
	 * @return
	 */
	public boolean checkIsGroupRedioButtonAgeIsSelected(String locatorAge)    // check radio button for Age isselected
	{
		boolean blnFlagAge = false;
		blnFlagAge = objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+locatorAge+"']")).isSelected();
		return blnFlagAge;
	}

	/**
	 * @Description :click on GroupRedio Button Gender
	 * @param strGenderPath
	 */
	public void clickOnGroupRedioButtonsGender(String strGenderPath)   //click on GroupRedio Button Gender
	{
		
		Assert.assertFalse(this.checkIsGroupRedioButtonGenderIsSelected(strGenderPath));
		objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strGenderPath+"' and @name='gender']")).click();
	}

	
	/**
	 * @Description :click on GroupRedio Button Age
	 * @param strAgePath
	 */
	public void clickOnGroupRedioButtonAge(String strAgePath)
	{
		
		Assert.assertFalse(this.checkIsGroupRedioButtonAgeIsSelected(strAgePath));
		objBaseTest.getDriver().findElement(By.xpath("//input[@value='"+strAgePath+"']")).click();
	}
	
	/**
	 * @Description : click on Get Value Button for Group radio buttons
	 */
	public void clickonGetValueButton() {
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Get values']")).click();
		System.out.println("Get value is clicked");
	}
	
	/**
	 * @Description : verify result of Group radio Button 
	 */
	public void checkGroutRedioResult()
	{
			blnFlag=objBaseTest.getDriver().findElement(By.xpath("//p[@class='groupradiobutton']")).isDisplayed();
			Assert.assertTrue(true);
			System.out.println("Massage is Displayd : "+objBaseTest.getDriver().findElement(By.xpath("//p[@class='groupradiobutton']")).getText());
		
	}
}
