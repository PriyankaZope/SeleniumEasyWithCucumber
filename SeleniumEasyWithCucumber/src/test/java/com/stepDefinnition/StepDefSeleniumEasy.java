package com.stepDefinnition;


import java.util.List;
import java.util.Map;

import com.generic.com.BaseTest;
import com.pageFactory.com.BootStrapAlertPage;
import com.pageFactory.com.CheckBoxDemoPage;
import com.pageFactory.com.RadioButtonDemoPage;
import com.pageFactory.com.SeleniumEasyHomePage;
import com.pageFactory.com.SimpleFormDemoPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefSeleniumEasy extends BaseTest{
	public SeleniumEasyHomePage objSeleniumEasyHomePage;
	public SimpleFormDemoPage objSimpleFormDemoPage;
	public BootStrapAlertPage objBootStrapAlertPage;
	public CheckBoxDemoPage objCheckBoxDemoPage;
	public RadioButtonDemoPage objRadioButtonDemoPage; 
	 private String testData;

	public StepDefSeleniumEasy() {
		
		objSeleniumEasyHomePage = new SeleniumEasyHomePage(this);
		objSimpleFormDemoPage = new SimpleFormDemoPage(this);
		objBootStrapAlertPage=new BootStrapAlertPage(this);
		objCheckBoxDemoPage=new CheckBoxDemoPage(this);
		objRadioButtonDemoPage=new RadioButtonDemoPage(this);
	
		
	}
	
	@Before
	public void initializeWebEnvAndClosePopUp(){
		this.initilizeWebEnvirnment();
		objSeleniumEasyHomePage.closePopUp();

	}
	@After
	public void closeBrowser(){
		   this.tearDownEnvirnment();

	}
	
	@Given("user launch chrome browser and navigate to URL")
	public void user_launch_chrome_browser_and_navigate_to_url() {
		this.initilizeWebEnvirnment();
		System.out.println("Initializing ");
	}

	@When("user close PopUp")
	public void user_close_pop_up() {
		objSeleniumEasyHomePage.closePopUp();
		System.out.println("Closing Pop up");

	}

	@And("user click on {string}")
	public void user_click_on(String string) {
		objSeleniumEasyHomePage.getAllDropDownsFields(string);
	}

	@And("select {string} from dropdown")
	public void select_from_dropdown(String string) {
		objSeleniumEasyHomePage.getvaluesOfDropDown(string);

	}

	@Then("Simple form damo page is open")
	public void simple_form_damo_page_is_open() {
		objSimpleFormDemoPage.verifyDemoPageIsDisplayed();

	}
	
	@When("single input form demo text is displayed as {string}")
	public void single_input_form_demo_text_is_displayed_as(String string) {
	   objSimpleFormDemoPage.verifyInputFields("Single Input Field", string);
	}

	@And("user enters single input text {string}")
	public void user_enters_single_input_text(String string) {
	    
		objSimpleFormDemoPage.setSingleInput(string);
	}

	@And("user click on Get Massage button")
	public void user_click_on_get_massage_button() {
	   objSimpleFormDemoPage.clickOnShowMsg();
	}

	@Then("Text massage will display as {string}")
	public void same_massage_will_display(String string) {
	    objSimpleFormDemoPage.verifyMsgOfSingleInput(string);
	}
	
	//multiple input
	
	@Given("Multiple input form demo text is displayed as {string}")
	public void multiple_input_form_demo_text_is_displayed_as(String string) {
	    objSimpleFormDemoPage.verifyInputFields("Two Input Fields", string);
	}

	@When("user enters two integer values as {string} and {string}")
	public void user_enters_two_integer_values_as_and(String strNum1, String strNum2) {
	   objSimpleFormDemoPage.setTwoInputFields("sum1", strNum1);
	   objSimpleFormDemoPage.setTwoInputFields("sum2", strNum2);
	}

	@And("click on Get Total button")
	public void click_on_get_total_button() {
	   objSimpleFormDemoPage.clickOnGetTotal();
	}

	@Then("sum of two numbers will be displayed")
	public void sum_of_two_numbers_will_be_displayed() {
	   objSimpleFormDemoPage.verifyMsgOfTwoInputField("84", "16");
	}
	
	@Then("sum of two numbers {string} and {string} will be displayed")
	public void sum_of_two_numbers_and_will_be_displayed(String strOne, String strTwo) {
		 objSimpleFormDemoPage.verifyMsgOfTwoInputField(strOne, strTwo);
	}
	
	
	//Bootstrap alert
	
	@Given("user navigate to home page")
	public void user_navigate_to_home_page() {
	   this.getObjWrapperFunctions().navigateToHomePage();
	}

	@And("click on DropDown {string} and select {string}")
	public void click_on_drop_down_and_select(String topUp, String value) {
		objSeleniumEasyHomePage.getAllDropDownsFields(topUp);
		objSeleniumEasyHomePage.getvaluesOfDropDown(value);
	}

	@When("header of page is displayed")
	public void header_of_page_is_displayed() {
		 objBootStrapAlertPage.verifyBootStrapAlertTextIsDisplayed();
	}

	@And("click on auto closable success massage button")
	public void click_on_auto_closable_success_massage_button() {
		objBootStrapAlertPage.clickOnMassageButton("autoclosable-btn-success");
	}

	@And("verify alert auto closable success massage is displayed")
	public void verify_alert_auto_closable_success_massage_is_displayed() {
		objBootStrapAlertPage.verifyMassageAlertAutoSuccessMassage(this.objConfig.getProperty("strExpectedalertMassageAutoCloseSuccess"));
	}

	@And("click on Normal Success button")
	public void click_on_normal_success_button() {
		objBootStrapAlertPage.clickOnMassageButton("normal-btn-success");
	}

	@And("verify alert Normal Success massage is displayed")
	public void verify_alert_normal_success_massage_is_displayed() {
		objBootStrapAlertPage.verifyMassageAlertNormalSuccessMassage(this.objConfig.getProperty("strExpectedalertMassageNormalSuccess"));
	}

	@And("click Auto closable Warning button")
	public void click_auto_closable_warning_button() {
		objBootStrapAlertPage.clickOnMassageButton("autoclosable-btn-warning");
	}

	@Then("verify alert Auto closable Warning massage is displayed")
	public void verify_alert_auto_closable_warning_massage_is_displayed() {
		objBootStrapAlertPage.verifyMassageAlertAutoWarningMassage();
	}
	
	//Check box
	
	@Given("click on DropDown TopUp {string} and select {string}")
	public void click_on_drop_down_top_up_and_select(String topUp, String value) {
		objSeleniumEasyHomePage.getAllDropDownsFields(topUp);
		objSeleniumEasyHomePage.getvaluesOfDropDown(value);
	}

	@Given("header of Check box demo page is displayed")
	public void header_of_check_box_demo_page_is_displayed() {
	  objCheckBoxDemoPage.verifyHeaderTextIsDisplayedOfCheckBoxDemoPage();
	}

	@When("single input form Title text is displayed as {string}")
	public void single_input_form_title_text_is_displayed_as(String strText) {
	   objCheckBoxDemoPage.verifyCheckboxDemoText("Single Checkbox Demo", strText);
	}

	@When("user clicks single checkbox and selected check box text will be {string}")
	public void user_clicks_single_checkbox_and_selected_check_box_text_will_be(String strExpected) {
	    objCheckBoxDemoPage.selectSingleCheckBox();
	    objCheckBoxDemoPage.verifyResultSingleCheckBoxText(strExpected);
	}

	@When("Multiple check box title text is displayed as {string}")
	public void multiple_check_box_title_text_is_displayed_as(String strText) {
	  objCheckBoxDemoPage.verifyCheckboxDemoText("Multiple Checkbox Demo", strText);
	}

	@Then("select multiple check box {string} and {string}")
	public void select_multiple_check_box_and(String strOption, String strOption2) {
	   objCheckBoxDemoPage.selectMultipleCheckBox(strOption);
	   objCheckBoxDemoPage.selectMultipleCheckBox(strOption2);
	}
	
	//Radio button
	@Given("header of radio button demo page is displayed")
	public void header_of_radio_button_demo_page_is_displayed() {
	   objRadioButtonDemoPage.verifyHeaderTextOfRedioButtonPageIsDisplayed();
	}

	@When("user click on radio button")
	public void user_click_on_radio_button() {
		objRadioButtonDemoPage.clickOnRedioButton("Female");
	}

	@When("user verify Result of RadioButton")
	public void user_verify_result_of_radio_button() {
		objRadioButtonDemoPage.clickonGetCheckedValueButton();
		objRadioButtonDemoPage.checkResult();
	}
	
	@Then("user Close the Browser")
	public void user_close_the_browser() {
	   this.tearDownEnvirnment();
	}
	
	//data table
	
	@Given("user is on the Demo home page")
	public void user_is_on_the_demo_home_page() {
	}

	@When("verify header of demo home page")
	public void verify_header_of_demo_home_page() {
		   objSeleniumEasyHomePage.verifyDemoHomePageHeaderIsDisplayed();
 
	}

	@Then("verify the topup menu of demo home page")
	public void verify_the_topup_menu_of_demo_home_page(io.cucumber.datatable.DataTable dataTable) {
	List<Map<String , String >> listDataTable = dataTable.asMaps(String.class, String.class);
	for (int i = 0; i < listDataTable.size(); i++) {
		testData = listDataTable.get(i).get("topUpMenu");
		if (!testData.equals("")){
			objSeleniumEasyHomePage.verifytopUpMenuIsDisplayedAndClickable(testData);
		}
		 }
	      }
	/*@And("close the browser")
	public void close_the_browser() {
		   this.tearDownEnvirnment();

	}*/
	
}
