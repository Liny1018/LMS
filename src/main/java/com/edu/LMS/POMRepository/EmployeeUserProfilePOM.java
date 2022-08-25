package com.edu.LMS.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.LMS.GenericUtility.WebDriverUtility;

public class EmployeeUserProfilePOM {
	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	public EmployeeUserProfilePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//a[text()=' User Profile']")
	private WebElement userprofilelink;
	@FindBy(css = "#userPersonalPhoneNumber")
	private WebElement personalphonenumber;
	@FindBy(css = "#userPresentAddress")
	private WebElement presentaddress;
	@FindBy(css = "#userPassword")
	private WebElement password;
	@FindBy(name="btnUserInfoUpdate")
	private WebElement updatebutton;

	public WebElement getUserprofilelink() {
		return userprofilelink;
	}
	public WebElement getPersonalphonenumber() {
		return personalphonenumber;
	}
	public WebElement getPresentaddress() {
		return presentaddress;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getUpdateButton() {
		return updatebutton;
	}
	public void userProfilePage(String userPersonalPhnNumber,String userPersonalAddress,String userPassword)
	{
		userprofilelink.click();
		wLib.executeJavaScriptScroll(driver, "window.scrollBy(0,2000);");
		personalphonenumber.clear();
		personalphonenumber.sendKeys(userPersonalPhnNumber);
		presentaddress.clear();
		presentaddress.sendKeys(userPersonalAddress);
		password.clear();
		password.sendKeys(userPassword);
		updatebutton.click();
	}


}
