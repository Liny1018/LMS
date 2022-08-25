package com.edu.LMS.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.LMS.GenericUtility.WebDriverUtility;

public class EmployeeBloodGroupPOM {
	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	public EmployeeBloodGroupPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//a[text()=' Blood Group']")
	private WebElement bloodgrouplink;
	@FindBy(id="empDptName")
	private WebElement blooddropdown;

	public WebElement getBloodgrouplink() {
		return bloodgrouplink;
	}
	public WebElement getBlooddropdown() {
		return blooddropdown;
	}
   public void bloodGroupPage()
   {
	   bloodgrouplink.click();
	  // blooddropdown.click();
	  // WebElement bloodDrop = null;
	   wLib.select(blooddropdown, "O+"); 
	
	}
	

}
