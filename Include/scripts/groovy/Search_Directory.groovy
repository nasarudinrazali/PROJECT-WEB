import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Search_Directory {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I navigate to OrangeHRM homepage")
	public void i_navigate_to_OrangeHRM_homepage() {

		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
	}

	@When("I enter username and password")
	public void i_enter_username_and_password() {

		WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), 'Admin')

		WebUI.setEncryptedText(findTestObject('Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')
	}

	@When("I click Login button")
	public void i_click_Login_button() {

		WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Login'))
	}


	@When("I click Directory tab")
	public void i_click_Directory_tab() {

		WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/span_Directory'))
	}

	@When("I type (.*)")
	public void i_type_employee_Name(String employeeName) {

		WebUI.setText(findTestObject('Page_OrangeHRM/input'), employeeName)
	}

	@When("I click on the hint")
	public void i_click_on_the_hint() {
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Page_OrangeHRM/autocomplete_dropdown'))
		WebUI.click(findTestObject('Page_OrangeHRM/autocomplete_dropdown'))
	}

	@When("I click on Search button")
	public void i_click_on_Search_button() {
		WebUI.click(findTestObject('Page_OrangeHRM/button_Search'))
	}

	@Then("I should be able to view the (.*) in the record")
	public void i_should_be_able_to_view_the_employee_Name_in_the_record(String employeeName) {

		WebUI.verifyElementVisible(findTestObject('Page_OrangeHRM/p_employeeName', [('nameParam') : employeeName]))
		WebUI.closeBrowser()
	}

	@Then("I should be able to view the invalid message")
	public void i_should_be_able_to_view_the_invalid_message() {
		
		WebUI.verifyElementVisible(findTestObject('Page_OrangeHRM/span_Invalid'))
		WebUI.closeBrowser()
	}
}