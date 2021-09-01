package com.pageFactory.com;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.com.BaseTest;

public class CheckBoxDemoPage {

	private BaseTest objBaseTest;

	public boolean blnFlag = false;

	public CheckBoxDemoPage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}
	
	By loc_HeaderOfCheckBoxDemoPage=By.xpath("//h3[text()='This would be a basic example to start with checkboxes using selenium.']");
	
	/**
	 * @Description :Verify Header of Check box page is Displayed or Not
	 */
	public void verifyHeaderTextIsDisplayedOfCheckBoxDemoPage()
	{
		blnFlag=objBaseTest.getObjWrapperFunctions().checkElementIsDisplayed(loc_HeaderOfCheckBoxDemoPage);
		Assert.assertTrue(blnFlag);
	}
	
	
	/**
	 * @Description :Verify CheckBox Demo Text for Single and multiple check box
	 * @param strCheckBoxPath
	 * @param strExpectedText
	 */
	public void verifyCheckboxDemoText(String strCheckBoxPath, String strExpectedText)  //verifying Text single and Multi
	{
		String strCheckBoxText=objBaseTest.getDriver().findElement(By.xpath("//div[text()='" + strCheckBoxPath + "']")).getText();
		String strExpected=strExpectedText;
		Assert.assertEquals(strCheckBoxText, strExpected);
	}

	/**
	 * @Description :verify single check box is selected or not
	 * @return
	 */
	public boolean verifySingleCheckBoxIsSected()    //check box isSelectred or Not
	{
		boolean blnFlag = false;
		blnFlag = objBaseTest.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
		
		return blnFlag;
	}
	

	/**
	 * @Description :Select check box if not selected
	 */
	public void selectSingleCheckBox()   //Select Check box if not selected
	{
//		By loc_SelectSingleCheckBox=By.xpath("//input[@id='isAgeSelected']");
		Assert.assertFalse(verifySingleCheckBoxIsSected());
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']")).click();
//		objBaseTest.getObjWrapperFunctions().waitUntilElementSelect(loc_SelectSingleCheckBox);
	}
	
	/**
	 * @Description :Verify Result text of single check box
	 */
	public void verifyResultSingleCheckBoxText(String strExpectedResult)
	{
		
		String strResultText=objBaseTest.getDriver().findElement(By.xpath("//div[text()='Success - Check box is checked']")).getText();
		Assert.assertNotNull(strResultText);
		Assert.assertEquals(strResultText, strExpectedResult);
	}

	/**
	 * @Description : verify check box is selected or not Group
	 * @param xpathofCheckBox
	 * @return
	 */
	public boolean verifyMultipelCheckBoxIsSelected(String xpathofCheckBox)  //check box isSelectred or Not Group
	{
		boolean blnFlag = false;
		blnFlag=objBaseTest.getDriver().findElement(By.xpath("//label[text()='"+xpathofCheckBox+"']")).isSelected();
		
		return blnFlag;
		
	}

	/**
	 * @Description :Select Group check boxes if not selected
	 * @param strCheckBoxPath
	 */
	public void selectMultipleCheckBox(String strCheckBoxPath) //Select Check box if not selected Group
	{
		
		objBaseTest.getObjWrapperFunctions().scrollPage(300);
		Assert.assertFalse(verifyMultipelCheckBoxIsSelected(strCheckBoxPath));
		
		objBaseTest.getDriver().findElement(By.xpath("//label[text()='"+strCheckBoxPath+"']")).click();

	}

	
	
	
}
