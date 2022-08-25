package com.edu.LMS.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{

//public void onTestSuccess(ITestResult result) {
//
//	  String testName = result.getMethod().getMethodName();
//	  System.out.println(testName +"==Execute & I'm Listeneing");
//	  
//	  EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
//	  File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
//	  try 
//	  {
//		  FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+".png"));
//	  }
//	  catch(IOException e)
//	  {
//		e.printStackTrace();  
//	  }
//}

  public void onTestFailure(ITestResult result)
  {
	  String testName = result.getMethod().getMethodName();
	  System.out.println(testName +"==Execute & I'm Listeneing");
	  
	  EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sdriver);
	  File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
	  try 
	  {
		  FileUtils.copyFile(srcFile, new File("./screenshot/"+testName+".png"));
	  }
	  catch(IOException e)
	  {
		e.printStackTrace();  
	  }
  }


}
