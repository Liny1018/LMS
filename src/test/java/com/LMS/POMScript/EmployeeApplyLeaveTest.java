package com.LMS.POMScript;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.LMS.GenericUtility.BaseClass;
import com.edu.LMS.GenericUtility.ExcelUtility;
import com.edu.LMS.GenericUtility.FileUtility;
import com.edu.LMS.GenericUtility.JavaUtility;
import com.edu.LMS.GenericUtility.WebDriverUtility;
import com.edu.LMS.POMRepository.EmployeeApplyLeavePOM;
import com.edu.LMS.POMRepository.EmployeeLoginPOM;
import com.edu.LMS.POMRepository.LogoutPOM;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.edu.LMS.GenericUtility.ListenerImplementation.class)
public class EmployeeApplyLeaveTest extends BaseClass {
	@Test(groups= {"regressionTest"})
	public void empApplyLeave() throws Throwable 
	{
		
		//Initialization
		WebDriver driver = null;
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
  //step 1: get properties from commondata
		
		String URL = fLib.getPropertyKeyValue("url");
		String UN = fLib.getPropertyKeyValue("un");
		String PWD = fLib.getPropertyKeyValue("pwd");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
//	//step 2: launch browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
	//step 3: Open application
		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);

		
	//step 4: login to application
	driver.get(URL);	
	EmployeeLoginPOM lo =new EmployeeLoginPOM(driver);
	lo.loginApp(UN, PWD);

		
	//step 5: Apply leave
		
		String alterEmpCodeName= eLib.getExcelData("TestSheet", 11, 0);
		
		String empLeaveReason =eLib.getExcelData("TestSheet", 11, 1);
	
		String modifyFromDate=jLib.getSystemDateInIST();

		// for To date
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_YEAR,2);
		Date nextDate = cal1.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/YYYY");
		String modifyToDate =sdf1.format(nextDate);
		
		String contactAddressDuringLeave =eLib.getExcelData("TestSheet", 11, 4);
		
		EmployeeApplyLeavePOM ap = new EmployeeApplyLeavePOM(driver);
		ap.applyLeavePage(alterEmpCodeName, empLeaveReason, modifyFromDate, modifyToDate, contactAddressDuringLeave);
		
        String actsucmsg = "Your Application Is Successfully Placed";
		String expsucmsg =driver.findElement(By.xpath("//h3[text()='Your Application Is Successfully Placed']")).getText();
		Assert.assertEquals(actsucmsg, expsucmsg);
		//logout application
		
		LogoutPOM log = new LogoutPOM(driver);
		log.logoutPage();
		
		
		//close the browser
		driver.quit();

	}

}
