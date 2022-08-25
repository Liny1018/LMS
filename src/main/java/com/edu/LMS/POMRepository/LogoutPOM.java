package com.edu.LMS.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPOM {
	WebDriver driver;
	public LogoutPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath= "//a[text()=' Logout']")
 private WebElement logout;
public WebElement getLogout() {
	return logout;
}
 public void logoutPage()
 {
	 logout.click(); 
 }

}
