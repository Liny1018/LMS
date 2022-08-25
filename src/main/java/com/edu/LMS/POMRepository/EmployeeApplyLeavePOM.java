package com.edu.LMS.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.LMS.GenericUtility.WebDriverUtility;

public class EmployeeApplyLeavePOM extends WebDriverUtility
{
	WebDriver driver;
	public EmployeeApplyLeavePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(linkText = "Apply Leave")
   private WebElement applyleavelink;
   @FindBy(id="livAltEmpCode")
   private WebElement altempcodename;
   @FindBy(xpath="//label[text()='Sick Leave']")
   private WebElement leavetype;
   @FindBy(id="livReason")
   private WebElement leavereason;
   @FindBy(id="livEmplivFrom")
   private WebElement from;
   @FindBy(id="livEmplivTo")
   private WebElement to;
   @FindBy(id="livAddress")
   private WebElement contactaddressduringleave;
   @FindBy(xpath="//button[text()='Apply']")
   private WebElement applybutton;
   @FindBy(xpath="//label[text()='Sick Leave']")
   private WebElement leavetypenxt;
   @FindBy(name="btnFinalSubmit")
   private WebElement finalapply;


public WebElement getApplyleavelink() {
	return applyleavelink;
}
public WebElement getAltempcodename() {
	return altempcodename;
}
public WebElement getLeavetype() {
	return leavetype;
}
public WebElement getLeavereason() {
	return leavereason;
}
public WebElement getFrom() {
	return from;
}
public WebElement getTo() {
	return to;
}
public WebElement getContactaddressduringleave() {
	return contactaddressduringleave;
}
public WebElement getApplybutton() {
	return applybutton;
}
public WebElement getleavetypenxt() {
	return leavetypenxt;
}
public WebElement getfinalapply() {
	return finalapply;
}
 public void applyLeavePage(String alterEmpCodeName, String empLeaveReason,String modifyFromDate,String modifyToDate,String contactAddressDuringLeave)
 {
	 applyleavelink.click();
	 altempcodename.sendKeys(alterEmpCodeName);
	 leavetype.click();
	 leavereason.sendKeys(empLeaveReason);
	 from.sendKeys(modifyFromDate);
	 to.sendKeys(modifyToDate);
	 contactaddressduringleave.sendKeys(contactAddressDuringLeave);
	 applybutton.click();
	 leavetypenxt.click();
	 finalapply.click();
     driver.navigate().back();

 }
}
