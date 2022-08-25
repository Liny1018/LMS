package com.edu.LMS.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeLoginPOM {
	 WebDriver driver;
		public EmployeeLoginPOM(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
	 
			@FindBy(id="form-username")
			private WebElement usernameEdt;
			
			@FindBy(id="form-password")
			private WebElement passwordEdt;
			
			@FindBy(name="btnSubmit")
			private WebElement loginButton;

			public WebElement getUsernameEdt()
	        {
				return usernameEdt;
			}
			public WebElement getPasswordEdt() 
			{
				return passwordEdt;
			}
			public WebElement getLoginButton() 
			{
				return loginButton;
			}
	       
			
			public void loginApp(String UN, String PWD)
			{
				usernameEdt.sendKeys(UN);
				passwordEdt.sendKeys(PWD);
				loginButton.click();
			}
			

}
