package com.edu.LMS.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.edu.LMS.POMRepository.EmployeeLoginPOM;
import com.edu.LMS.POMRepository.LogoutPOM;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	
	/* Object creation for lIB*/
    public JavaUtility jLib = new JavaUtility();
    public WebDriverUtility wLib = new WebDriverUtility();
    public  FileUtility fLib = new FileUtility();
    public  ExcelUtility eLib = new ExcelUtility();
    /* iNITIALIZATION*/
    String BROWSER;
    String URL;
    String UN;
    String PWD;
    
    
    @BeforeSuite (groups = {"systemTest","regressionTest"})
    public void configBS()
    {
   	System.out.println("Connect to DB"); 
    }
    
    @Parameters("BROWSER")
    @BeforeClass
    public void configBC() throws Throwable
    {
   	 System.out.println("launch the browser");
   	 //launch browser
   	 BROWSER = fLib.getPropertyKeyValue("browser");
   	 
   		if(BROWSER.equalsIgnoreCase("chrome"))
   		{
   			WebDriverManager.chromedriver().setup();
   			driver= new ChromeDriver();
   		}
   		 else if(BROWSER.equalsIgnoreCase("firefox"))
   		{
   			WebDriverManager.firefoxdriver().setup();
   			driver= new FirefoxDriver();
   		}
   		else
   		{
   			System.out.println("Invalid browser");
   		}

   	 //driver = new ChromeDriver();
   	 wLib.waitForElementInDOM(driver);
   	 driver.manage().window().maximize();
   	 sdriver = driver;
    }
    
    @BeforeMethod
    public void configBM() throws Throwable
    {
    	 URL = fLib.getPropertyKeyValue("url");
		 UN = fLib.getPropertyKeyValue("un");
		 PWD = fLib.getPropertyKeyValue("pwd");
	     driver.get(URL);
	     
		//login application
		
		EmployeeLoginPOM elo = new EmployeeLoginPOM(driver);
		elo.loginApp( UN, PWD);
		
    }
    @AfterMethod
    public void configAM()
    {
   	 LogoutPOM log = new LogoutPOM(driver);
   	 log.logoutPage();
 	
    }
    @AfterClass
    public void configAC()
    {
   	 System.out.println("Close the browser");
   	 driver.quit();
    }
    @AfterSuite
    public void configAS()
    {
   	 System.out.println("close DB");
    }

}
