package com.whs.navigator.commonUtil;



import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;



public class WebObjectUtil_BK {
public static String sOperationname = null;
public static ArrayList arrCustomWebListItems ;
public static List<WebElement> webElementsList ;
public static int iWebElementsCount ;

public static String getOperationName() {
	return sOperationname;
}
public static void setOperationName(String sOperationname) {
	WebObjectUtil.sOperationname = sOperationname;
}
//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: isElementPresent
Description		: to check whether element present or not
Author 			: Arularasu
Creation Date 	: 11/12/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
	  public static boolean isElementPresent(WebElement webElement) {
		  
		    try {	
		    	//setOperationName("Check the presents of element");
		    	if (webElement.isDisplayed()){
		    		//LoggerUtil.log_type_info("Element present :" + FrameworkUtil.sElementName);
		    	}
		      return true;
		    } catch (NoSuchElementException e) {
		    	LoggerUtil.log_type_warn("Element Not present catch block:" + FrameworkUtil.sElementName);
		      return false;
		    }
		  }
	  
	  //----------------------------------------------------------------------------------------------------------------
	
	  /*==============================================================
	  Method Name		: verifyElementPresent
	  Description		: to verify the element present or not on webpage
	  Author 			: Arularasu
	  Creation Date 	: 11/12/2014
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
		
	  public static boolean verifyElementPresent(WebElement webElement) {
		 boolean bStatus = false; 
		    try {
		    	if (isElementPresent(webElement)){
		    		bStatus = true;
		    		setOperationName("Verify Element");
		    		LoggerUtil.log_type_info("Element verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "pass", "Success: Element Verified ");
		    	}
/*		    	else if (WebObjectUtil.waitForElementPresent(webElement)){
		    		//else if (WebObjectUtil.explicitWait(webElement)){
		    		LoggerUtil.log_type_info("Element verified using Explicit wait :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "warn", "Explicit wait used to verify Element");
		    	}*/
		    	else{
	    			LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "fail", "Element could not verified ");
		    			
	    		}
		     // return true;
		    } catch (Exception e) {
		    	FrameworkUtil.takeScreenShot();
		    	LoggerUtil.log_type_error("Element NOT verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "warn", "Element not Verified");
		     // return false;
		    } 
		    return bStatus;
		  }
	  
	  /*==============================================================
	  Method Name		: verifyElementPresent
	  Description		: to verify the element present or not on webpage and stop execution based on input flag.
	  Author 			: Arularasu
	  Creation Date 	: 05/08/2015
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
		
	  public static boolean verifyElementPresent(WebElement webElement,boolean bStopExecution) {
		  boolean bStatus = false;
		    try {
		    	if (isElementPresent(webElement)){
		    		bStatus = true;
		    		setOperationName("Verify Element");
		    		LoggerUtil.log_type_info("Element verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "pass", "Success: Element Verified ");
		    	}
/*		    	else if (WebObjectUtil.waitForElementPresent(webElement)){
		    		//else if (WebObjectUtil.explicitWait(webElement)){
		    		LoggerUtil.log_type_info("Element verified using Explicit wait :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "warn", "Explicit wait used to verify Element");
		    	}*/
		    	else{
	    			LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "fail", "Element could not verified ");
		    		//FrameworkUtil.takeScreenShot();
		    		if (bStopExecution){
		    			stopCurrentTestExecution();
		    		}
		    			
	    		}
		     // return true;
		    } catch (Exception e) {
		    	LoggerUtil.log_type_error("Element NOT verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "warn", "Element not Verified");
		    	FrameworkUtil.takeScreenShot();
		     // return false;
		    } 
		    return bStatus;
		  }
	  
	  /*==============================================================
	  Method Name		: verifyElementNOTPresent
	  Description		: verify the element NOT present  on webpage
	  Author 			: Arularasu
	  Creation Date 	: 11/12/2014
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
		
	  public static boolean verifyElementNOTPresent(WebElement webElement) {
		  boolean bStatus = false;
		    try {
		    	if (!isElementPresent(webElement)){
		    		setOperationName("Verify Element not present");
		    		LoggerUtil.log_type_info("Verified that Element not present :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element Not present", "pass", "Success: Element not present as expected ");
		    		bStatus = true;
		    	}else{
	    			LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element Not present", "fail", "Element present but expected is Element should noit present");
		    		FrameworkUtil.takeScreenShot();	
	    		}
		     // return true;
		    } catch (Exception e) {
		    	LoggerUtil.log_type_error("catch block: Element NOT verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "warn", "catch block: Element not Verified");
		    	FrameworkUtil.takeScreenShot();
		     // return false;
		    } 
		    return bStatus;
		  }
	//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: assertElementPresent
	  Description		: to assert the element 
	  Author 			: Arularasu
	  Creation Date 	: 11/12/2014
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static void assertElementPresent(WebElement webElement) {
		  
		    try {
		    	if (isElementPresent(webElement)){
		    		Assert.assertTrue(true);
		    		setOperationName("Assert Element");
		    		LoggerUtil.log_type_info("Element Validated :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "pass", "");
		    	/*}else if (WebObjectUtil.explicitWait(webElement)){
		    		Assert.assertTrue(true);
		    		LoggerUtil.log_type_info("Element Validated using Explicit wait :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "warn", "Explicit wait used to Assert Element");
		    	*/}else{
		    		LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "fail", "Element could not verified ");
		    		FrameworkUtil.takeScreenShot();
		    		Assert.assertTrue(false);
		    	}
		     // return true;
		    } catch (Exception e) {
		    	LoggerUtil.log_type_error("catch block:Element NOT Validated :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "warn", "catch block:Element not Asserted");
		    	FrameworkUtil.takeScreenShot();
		    	Assert.assertTrue(false);
		     // return false;
		    } 
		  } 
	  
	  
	//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: clickAndVerifyElement
	  Description		: Clicking on the element and verifying the element
	  Author 			: Arularasu
	  Creation Date 	: 11/12/2014
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean clickAndVerifyElement(WebElement webElementClick,WebElement webElementVerify) {
		  
			    try {
	
		    	if (isElementPresent(webElementClick)){
		    		setOperationName("ClickAndVerifyElement");
		    		webElementClick.click();
		    		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
			    		if (webElementVerify.isDisplayed()){
			    			LoggerUtil.log_type_info("verified object : " + FrameworkUtil.sElementName);
			    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "pass", "");
			    			}else{
			    				LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
					    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "fail", "Element could not verified ");
					    		FrameworkUtil.takeScreenShot();
			    			}
		    		}else{
		    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
			    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
			    		FrameworkUtil.takeScreenShot();
		    		}
		      return true;
		    } catch (NoSuchElementException e) {
		    	LoggerUtil.log_type_error("catch block:Element Not present/verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ClickAndVerify", "warn", "catch block:Could not Verify Element");
		    	FrameworkUtil.takeScreenShot();
		    	return false;
		    }
		  }
	  
		//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: clickAndVerifyTextUnderElement
	  Description		: Clicking on the element and verifying the text under that element
	  Author 			: Arularasu
	  Creation Date 	: 11/13/2014
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean clickAndVerifyTextUnderElement(WebElement webElement, String sText, boolean clickAndVerify) {
		  
			  try {
	
		    	if (isElementPresent(webElement)){
		    		setOperationName("verifyTextUnderElement");
		    		if (clickAndVerify){
		    		webElement.click();
		    		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
		    		}
		    			if (webElement.getText().contains(sText)){
			    			LoggerUtil.log_type_info("verified text : " + sText);
			    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Text:"+sText , "Verify Element", "pass", sText);
			    		}else{
			    			LoggerUtil.log_type_info("text could not verified :" + sText);
				    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify text", "fail", "text could not verified " + sText);
				    		FrameworkUtil.takeScreenShot();
			    		}
		    	}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
		    		//FrameworkUtil.takeScreenShot();
		    		stopCurrentTestExecution();
	    		}
		      return true;
		    } catch (NoSuchElementException e) {
		    	LoggerUtil.log_type_error( "catch block:" + sText + "- Text not verifed under :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickAndVerifyTextUnderElement", "warn", "catch block: Could not Verify Element");
		      return false;
		    }
		  }
	  
		//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: VerifyTextOnPage
	  Description		: Verifying text on page
	  Author 			: Arularasu
	  Creation Date 	: 11/14/2014
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean VerifyTextOnPage(String sText) {
		  setOperationName("VerifyTextOnPage");
		  boolean bstatus = false;
		  try {
			  WebDriver driver = WebDriverUtil.getDriver();
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  String sTextOnPage = driver.findElement(By.tagName("body")).getText();
			  if (sTextOnPage.contains(sText)){
				  //System.out.println(driver.findElement(By.tagName("body")).getText());
				  
	    			LoggerUtil.log_type_info("text verified : " + sText);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Text:"+sText , "Verify Text", "pass", "Text present: "+ sText);
	    			bstatus = true;
	    			}else{
	    				LoggerUtil.log_type_error("text NOT verified : " + sText);
	    		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text", "fail", "Text not present: "+ sText);
	    		    	bstatus =  false;
	    		    	FrameworkUtil.takeScreenShot();
	    			}
			 
	    } catch (NoSuchElementException e) {
	    	LoggerUtil.log_type_error("catch block:text NOT verified : " + sText);
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text", "warn", "catch block:Text not present: "+ sText);
	    	FrameworkUtil.takeScreenShot();
	    	return false;
	    }
		return bstatus;  
	  }
	  
	  /*==============================================================
	  Method Name		: VerifyTextUnderElement
	  Description		: Verifying text under specified element
	  Author 			: Arularasu
	  Creation Date 	: 03/03/2015
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean VerifyTextUnderElement(WebElement webElement, String sText) {
		  setOperationName("VerifyTextUnderElement");
		  boolean bstatus = false;
		  try {
			  WebDriver driver = WebDriverUtil.getDriver();
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  if (isElementPresent(webElement)){
			  String sTextUnderElement = webElement.getText();
			  if (sTextUnderElement.contains(sText)){
				  
	    			LoggerUtil.log_type_info("text verified under element: " + sText);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text  under element", "pass", "Text present: "+ sText);
	    			bstatus = true;
	    			}else{
	    				LoggerUtil.log_type_error("text NOT verified  under element : " + sText);
	    		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text  under element", "fail", "Text not present: "+ sText);
	    		    	bstatus =  false;
	    		    	FrameworkUtil.takeScreenShot();
	    			}
			  }else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "issue with Element", "fail", "Element not present/visible ");
		    		FrameworkUtil.takeScreenShot();
	    		}
	    } catch (NoSuchElementException e) {
	    	LoggerUtil.log_type_error("catch block:Exception Occured on verified  under element: " + sText);
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text  under element", "warn", "Exception Occured: "+ e.getMessage());
	    	FrameworkUtil.takeScreenShot();
	    	return false;
	    }
		return bstatus;  
	  }
	  
	  
	  
	  /*==============================================================
	  Method Name		: VerifyTextNotPresentOnPage
	  Description		: Verifying text Not Present on page
	  Creation Date 	: 02/25/2015
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean VerifyTextNotPresentOnPage(String sText) {
		  setOperationName("VerifyTextNotPresentOnPage");
		  boolean bstatus = false;
		  try {
			  WebDriver driver = WebDriverUtil.getDriver();
			  
			  if (!driver.findElement(By.tagName("body")).getText().contains(sText)){
				  //System.out.println(driver.findElement(By.tagName("body")).getText());
	    			LoggerUtil.log_type_info("Text NOT Present : " + sText);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Text:"+sText , "Text NOT Present", "pass", "Text NOT Present: "+ sText);
	    			bstatus = true;
	    			}else{
	    				LoggerUtil.log_type_error("Text Present : " + sText);
	    		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Text NOT Present", "fail", "Text Present: "+ sText);
	    		    	bstatus =  false;
	    		    	FrameworkUtil.takeScreenShot();
	    			}
			 
	    } catch (NoSuchElementException e) {
	    	LoggerUtil.log_type_error("catch block:text NOT verified : " + sText);
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Text NOT Present", "warn", "catch block:issue with verifying text : "+ sText);
	    	FrameworkUtil.takeScreenShot();
	    	return false;
	    }
		return bstatus;  
	  }
	  
		//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: SetValueEdit
	  Description		: setting the value in the edit field
	  Author 			: Arularasu
	  Creation Date 	: 11/14/2014
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
public static void SetValueEdit(WebElement webElement,String value){
	
	try{
	//webElement.click();	
	if (isElementPresent(webElement) && webElement.isEnabled()) {
		setOperationName("Enter value");
		webElement.clear();
		webElement.sendKeys(value);	
		LoggerUtil.log_type_info("\"" + value + "\" entered to " + FrameworkUtil.sElementName );
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Enter value", "Done", value);
	}else if (webElement.isEnabled()==false){
		LoggerUtil.log_type_error("Object disbled :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element disabled", "warn", value);
		//FrameworkUtil.takeScreenShot();
		stopCurrentTestExecution();
	}else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Value NOT Entered", "fail", value);
		//FrameworkUtil.takeScreenShot();
		stopCurrentTestExecution();
	}
	}catch(Exception e){
		LoggerUtil.log_type_error("catch block: Could not set value \"" + value + "\" to webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Enter value", "warn", "catch block: " + e.getMessage());
		//FrameworkUtil.takeScreenShot();
		stopCurrentTestExecution();
	}
}
	
//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: clickElement
Description		: Clicking the webelement
Author 			: Arularasu
Creation Date 	: 11/14/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void clickElement(WebElement webElement){
	
	try{
	if (isElementPresent(webElement)){
		setOperationName("Click");
		webElement.click();
		LoggerUtil.log_type_info("Clicked on " + FrameworkUtil.sElementName);
		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
		
	}else{
		LoggerUtil.log_type_error("Could NOT Click on webelement,either element not present/visible " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "fail", "Could NOT click on Element,either element not present/visible ");
		//FrameworkUtil.takeScreenShot();
		stopCurrentTestExecution();
		
	}
	}catch(Exception e){
		LoggerUtil.log_type_error("catch block:Could NOT Click on webelement,either element not present/visible  " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "warn", "catch block:Could NOT click on Element,either element not present/visible " + e.getMessage());
		//FrameworkUtil.bTestCaseResultFlag = false;
		//FrameworkUtil.takeScreenShot();
		stopCurrentTestExecution();
		
	}
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: selectCheckRadioBox
Description		: Selecting Check box
Author 			: Arularasu
Creation Date 	: 11/17/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean selectCheckRadioBox(WebElement webElement){
	
	boolean status = false;
	try{
		
	if (isElementPresent(webElement)){
		setOperationName("Select Radio");
		if (!webElement.isSelected()){
			LoggerUtil.log_type_info("Selected/checked on " + FrameworkUtil.sElementName);
			webElement.click();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select", "Done", "");
			//call wait method
		}else{
		LoggerUtil.log_type_info("Webelement already selected " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select", "warn", "");
		}
		status = true;
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
		FrameworkUtil.takeScreenShot();
	}
	}catch(Exception e){
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select", "warn", "catch block:Could NOT access Element" + e.getMessage());
		FrameworkUtil.takeScreenShot();
		
	}
	
	return status;
}

//----------------------------------------------------------------------------------------------------------------	
 
/*==============================================================
Method Name		: getCheckRadioByValue
Description		: get checkbox/radio as Webelement by passing value
Author 			: Arularasu
Creation Date 	: 11/17/2014
Pre-Requisites	: 
Revision History:
Notes:			  pass null if there is no name attribute for checkbox or radio button
==============================================================*/
public static WebElement getCheckRadioByValue(String sValueText,String sWebElementName, String sWelementType ){
	
	WebDriver driver = WebDriverUtil.getDriver();
	WebElement element = null;
	List<WebElement> oCheckBox = null;
	String sXpath = "//input[@type='" + sWelementType + "']" ;
	
	try{
		// Find the checkbox or radio button element by value
		if (sWebElementName != null ){
			 oCheckBox = driver.findElements(By.name(sWebElementName));
		}else if (sValueText != null && sWelementType != null ){
			 oCheckBox = driver.findElements(By.xpath(sXpath));
		}else{
			return null;
		}

		 int iSize = oCheckBox.size();
		 for(int i=0; i < iSize ; i++ ){
			 String sValue = oCheckBox.get(i).getAttribute("value");
			 if (sValue.equalsIgnoreCase(sValueText)){
				 setOperationName("Find Radio/Check box by Value");
				 LoggerUtil.log_type_error("checkbox/radiobox webelement found" + getWebElementLocator(oCheckBox.get(i)));
				 element= oCheckBox.get(i);
				 break;
				 }
			}
		
	}catch(Exception e){
		setOperationName("Find Radio/Check box by Value");
		LoggerUtil.log_type_error("catch block:Could NOT found checkbox/radiobox with text --> " + sValueText + e.getMessage() );
		FrameworkUtil.takeScreenShot();
	}
	return element;
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: isCheckRadioSelected
Description		: to verify whether radio btn is selected or not
Author 			: Arularasu
Creation Date 	: 11/17/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean isCheckRadioSelected(WebElement webElement){
	
	boolean status = false;
	try{
		setOperationName("is Check/Radio box Selected");
	if (isElementPresent(webElement)){
		if (webElement.isSelected()){
			
			LoggerUtil.log_type_info("Webelement already selected " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "isSelected", "Done", "Already Selected");
			status = true;
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "isSelected", "Done", "Not Selected");
			status = false;
		}
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
		FrameworkUtil.takeScreenShot();
	}
	}catch(Exception e){
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "isSelected", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
	return status;
	}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: deSelectCheckBox
Description		: unselect Check/Radio box
Author 			: Arularasu
Creation Date 	: 11/17/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean deSelectCheckBox(WebElement webElement){
	
	boolean status = false;
	try{
		
	if (isCheckRadioSelected(webElement)){
		webElement.click();
			setOperationName("unselect Check/Radio box");
			LoggerUtil.log_type_info("Webelement deselected " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "unCheck", "Done", "");
			status = true;
	}
	}catch(Exception e){
		setOperationName("unselect Check/Radio box");
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "unCheck", "warn", "catch block:Could NOT access webelement" + e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
	return status;
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: selectWebList
Description		: Select item from the web list
Author 			: Arularasu
Creation Date 	: 11/17/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void selectWebList(WebElement webElement,String byVisibleText, String byValue, Integer byIndex){
	
	try{
		
	if (isElementPresent(webElement)){
		setOperationName("Select web list");
		Select select = new Select (webElement);
		//select.deselectAll();
		if (byVisibleText != null){
			select.selectByVisibleText(byVisibleText);
			LoggerUtil.log_type_info("item selected by selectByVisibleText and item is \"" + byVisibleText + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item selected by selectByVisibleText");
		}else if (byValue != null){
			select.selectByValue(byValue);
			LoggerUtil.log_type_info("item selected by selectByValue and item is \"" + byValue + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item selected by selectByValue");
		}else if(byIndex != null ){
			select.selectByIndex(byIndex);
			LoggerUtil.log_type_info("item selected by selectByIndex and item is \"" + byIndex + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item selected by selectByIndex");
		}else{
			LoggerUtil.log_type_error("item not selected!, please check your input " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item NOT selected");
		}
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Element", "fail", "Element not present/visible ");
		FrameworkUtil.takeScreenShot();
	}
	}catch(Exception e){
		setOperationName("Select web list");
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "warn", "catch block:Could NOT access webelement" + e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
}
//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: isMultiSelect
Description		: to check the weblist is multiselect or not
Author 			: Arularasu
Creation Date 	: 11/18/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean isMultiSelect(WebElement webElement){
	
	boolean status = false;
	try{
		
		if (isElementPresent(webElement)){
		Select select = new Select (webElement);
			if (select.isMultiple()){
				setOperationName("isMultiSelect web list");
				LoggerUtil.log_type_info("Weblist allows multi select " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "is Multi Select", "Done", "");
				status = true;	
			}
		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
    		FrameworkUtil.takeScreenShot();
		}
	}catch(Exception e){
		setOperationName("isMultiSelect web list");
		LoggerUtil.log_type_error("catch block: Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "is Multi Select", "warn", "catch block: Could NOT access webelement" +	e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
	return status;
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: multiSelectWebList
Description		: select multiple item from multiselect weblist 
Author 			: Arularasu
Creation Date 	: 11/19/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void multiSelectWebList(WebElement webElement,String sVisibleTextByCommaSeparated, String sValueByCommaSeparated, String sIndexNumberByCommaSeparated){
	
	try{
	String[] arrMultiSelect = null;
		
		
	if (isElementPresent(webElement)){
		setOperationName("Select multi items from web list");
		Select select = new Select (webElement);
		select.deselectAll();
		if (sVisibleTextByCommaSeparated != null){
			if (sVisibleTextByCommaSeparated.contains(",")){
					arrMultiSelect = sVisibleTextByCommaSeparated.split(",");
					for (String valueToBeSelected : arrMultiSelect) {
						select.selectByVisibleText(valueToBeSelected);	
					}
				}
			
			LoggerUtil.log_type_info("Multi item selected by selectByVisibleText and item is \"" + sVisibleTextByCommaSeparated + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "Done", "Multi item selected by selectByVisibleText");
		}else if (sValueByCommaSeparated != null){
			if (sValueByCommaSeparated.contains(",")){
				arrMultiSelect = sValueByCommaSeparated.split(",");
				for (String valueToBeSelected : arrMultiSelect) {
					select.selectByValue(valueToBeSelected);
				}
			}
			LoggerUtil.log_type_info("Multi item selected by selectByValue and item is \"" + sValueByCommaSeparated + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "Done", "Multi item selected by selectByValue");
		}else if(sIndexNumberByCommaSeparated != null ){
			if (sIndexNumberByCommaSeparated.contains(",")){
				arrMultiSelect = sIndexNumberByCommaSeparated.split(",");
				for (String valueToBeSelected : arrMultiSelect) {
					int iValue = Integer.parseInt(valueToBeSelected);  //convert string to int.
					select.selectByIndex(iValue);	
				}
			}
			
			LoggerUtil.log_type_info("Multi item selected by selectByIndex and item is \"" + sIndexNumberByCommaSeparated + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "Done", "Multi item selected by selectByIndex");
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "fail", "item not selected!");
			LoggerUtil.log_type_error("item not selected!, please check your input " + FrameworkUtil.sElementName);	
			FrameworkUtil.takeScreenShot();
		}
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		FrameworkUtil.takeScreenShot();
	}
	}catch(Exception e){
		setOperationName("Select multi items from web list");
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "warn", "catch block:Could NOT access webelement" + e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: getElementByText
Description		: get element by passing text
Author 			: Arularasu
Creation Date 	: 11/20/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static WebElement getElementByText(String sText){
	WebElement webElement = null;
	setOperationName("Get Element by Text");
	WebDriver driver = WebDriverUtil.getDriver();
	try{
		webElement= driver.findElement(By.linkText(sText));
	//if (WebObjectUtil.isElementPresent(webElement)){
		
		LoggerUtil.log_type_info("Element found by text: " + sText);		
	//}
	}catch (NoSuchElementException e){
		FrameworkUtil.takeScreenShot();
		LoggerUtil.log_type_info("Element NOT found by text: " + sText + e.getMessage());
	}
	return webElement;
}
//----------------------------------------------------------------------------------------------------------------k
/*==============================================================
Method Name		: explicitWait
Description		: explicitly wait for particular element
Author 			: Arularasu
Creation Date 	: 11/21/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean explicitWait(WebElement webElement){
	setOperationName("explicitWait");
	WebElement element = null;
	try{
		WebDriverWait wait = new WebDriverWait(WebDriverUtil.webdriver, 100);
		//element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		element = wait.until(ExpectedConditions.visibilityOf(webElement));
		LoggerUtil.log_type_info("Explicit wait: " + FrameworkUtil.sElementName);
		return element.isDisplayed() ;
	}catch(Exception e){
		LoggerUtil.log_type_error("Error in Explicit wait for webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.takeScreenShot();
		return false;
	}
}


/*==============================================================
Method Name		: explicitWait
Description		: explicitly wait for given time
Author 			: Arularasu
Creation Date 	: 03/18/2015
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void explicitWait(int iTimeinSeconds){
	 
	 try {
		 LoggerUtil.log_type_info("Explicit wait seconds : " + iTimeinSeconds);
		 iTimeinSeconds = iTimeinSeconds * 1000;
		 Thread.sleep(iTimeinSeconds);
	  
	 } catch (InterruptedException e) {
		 LoggerUtil.log_type_error("issue Explicit wait " + e.getMessage());

	 }
	}

/*==============================================================
Method Name		: handleJSAlert
Description		: handling the java script alert
Author 			: Arularasu
Creation Date 	: 11/24/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void handleJSAlert() {
	setOperationName("Handle Javascript alert");
	WebDriver driver = WebDriverUtil.getDriver();
    try {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        //LoggerUtil.log_type_error("JS Alert present - " + alert.getText());
        alert.accept();
        //System.out.println("Alert/msgbox handled");
        LoggerUtil.log_type_info("JS Alert present - " + alert.getText() + " -and  handled successfully");
        } catch (Exception e) {
        	LoggerUtil.log_type_info("JS Alert NOT present or could not handle" + e.getMessage());
        	FrameworkUtil.takeScreenShot();
        //exception handling
    }
}
/*==============================================================
Method Name		: handleHTMLAlert
Description		: handling the html alert
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void handleHTMLAlert(WebElement webElement) {
	setOperationName("Handle HTML alert");
	WebDriver driver = WebDriverUtil.getDriver();
    try {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        
    	if  (WebObjectUtil.isElementPresent(webElement)){ 
    		webElement.click();
    		LoggerUtil.log_type_info("HTML Alert present and handled successfully" + FrameworkUtil.sElementName);
    	}
    	//    System.out.println("Alert/msgbox handled");
        } catch (Exception e) {
        	LoggerUtil.log_type_info("HTML Alert NOT present or Could not handle" + FrameworkUtil.sElementName + e.getMessage());
        	FrameworkUtil.takeScreenShot();
        //exception handling
    }
}
/*==============================================================
Method Name		: compareString
Description		: compare 2 string either exact or part of it based on flag passed
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean compareString(String sSrcString, String sDestString, boolean bIsExactCompare){
	boolean bStatus = false;
	setOperationName("Compare string");
	
	try {
		if (bIsExactCompare){
			if(sSrcString.equalsIgnoreCase(sDestString)){
				bStatus = true;
				LoggerUtil.log_type_info("Both string are equal(case ignored), String1:" + sSrcString + "and String2:" + sDestString);
			}
		}	
			if (sSrcString.contains(sDestString)){
				bStatus = true;
				LoggerUtil.log_type_info("String1 contains String2, String1:" + sSrcString + "and String2:" + sDestString);
				if (!bIsExactCompare){
					//bStatus = false;
					LoggerUtil.log_type_warn("String1 contains String2 but expected is both should be equal, String1:" + sSrcString + "and String2:" + sDestString);
				}
			}
	} catch (Exception e) {
       	LoggerUtil.log_type_error("Compare string " + FrameworkUtil.sElementName);
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "catch block: Compare string", "warn", "catch block: Compare string"+e.getMessage());
    	FrameworkUtil.takeScreenShot();
	}
	
	return bStatus;
}


/*==============================================================
Method Name		: ClickAndMouseHover
Description		: click and mouse hover on same element
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void ClickAndMouseHover(WebElement webElement) {
	setOperationName("ClickAndMouseHover");
	WebDriver driver = WebDriverUtil.getDriver();
    try {
	    	if (isElementPresent(webElement)){
		    	WebObjectUtil.clickElement(webElement);
		    	Actions builder = new Actions(driver) ;
		    	builder.moveToElement(webElement).perform();
		    	Thread.sleep(2000);
	    	}else{
    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		//FrameworkUtil.takeScreenShot();
	    		stopCurrentTestExecution();
    		}
        } catch (Exception e) {
        	LoggerUtil.log_type_error("ClickAndMouseHover " + FrameworkUtil.sElementName + e.getMessage());
        	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "catch block:ClickAndMouseHover", "warn", "catch block:ClickAndMouseHover"+e.getMessage());
        	FrameworkUtil.takeScreenShot();
    }
}


/*==============================================================
Method Name		: clickAndVerifyUrl
Description		: click on element and verify URL
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean clickAndVerifyUrl(WebElement webElement, String sURL) {
	  
	    try {

  	if (isElementPresent(webElement)){
  		setOperationName("clickAndVerifyUrl");
  		WebObjectUtil.clickElement(webElement);
  		WebObjectUtil.waitForPageLoad();
  		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
  		String sCurrentUrl = WebDriverUtil.webdriver.getCurrentUrl();
	    		if (WebObjectUtil.compareString(sCurrentUrl, sURL, true)){
	    			LoggerUtil.log_type_info("URL Verified : " + sURL);
	    			}
  		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
    		//FrameworkUtil.takeScreenShot();
    		stopCurrentTestExecution();
		}
    return true;
  } catch (NoSuchElementException e) {
  	LoggerUtil.log_type_error("Element Not present/verified :" + FrameworkUtil.sElementName + e.getMessage());
  	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "catch block: clickAndVerifyUrl", "warn", "catch block: clickAndVerifyUrl "+e.getMessage());
  	FrameworkUtil.takeScreenShot();
  	return false;
  }
}


/*==============================================================
Method Name		: clickAndVerifyText
Description		: click on element and verify given text
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean clickAndVerifyText(WebElement webElement, String sText) {
	  
	    try {

  	if (isElementPresent(webElement)){
  		setOperationName("ClickAndVerifyText");
  		webElement.click();
  		WebObjectUtil.waitForPageLoad();
  		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
	    		if (WebObjectUtil.VerifyTextOnPage(sText)){
	    			LoggerUtil.log_type_info("Text Verified : " + sText);
	    			System.out.println("Text Verified : " + sText);
	    			}
  		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
    		//FrameworkUtil.takeScreenShot();
    		stopCurrentTestExecution();
		}
    return true;
  } catch (NoSuchElementException e) {
  	LoggerUtil.log_type_error("Element Not present/verified :" + FrameworkUtil.sElementName);
  	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "catch block: ClickAndVerifyText", "warn", "catch block: ClickAndVerifyText "+e.getMessage());
  	FrameworkUtil.takeScreenShot();
  	return false;
  }
}
/*==============================================================
MethodName 		: verifyUrl
Description		: Verify URL
Author 			: Vivek Kumar
Creation Date 	:12/19/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static boolean verifyUrl(String sURL) {
	  
    try {

	
		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
		String sCurrentUrl = WebDriverUtil.webdriver.getCurrentUrl();
    		if (WebObjectUtil.compareString(sCurrentUrl, sURL, true)){
    			LoggerUtil.log_type_info("URL Verified : " + sURL);
    			}
		
return true;
} catch (NoSuchElementException e) {
	LoggerUtil.log_type_error("Element Not present/verified :" + FrameworkUtil.sElementName);
	FrameworkUtil.takeScreenShot();
	return false;
}
}



/*==============================================================
Method Name		: switchToWindow
Description		: switch window based on title or index
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/

public static void switchToWindow(int iWindowIndex,String sNewWindowTitle){

int iWinIndex=0;
String sWindowTitle;

setOperationName("switch To Window");

try {
	WebDriver driver = WebDriverUtil.getDriver();
	Set<String> handles = driver.getWindowHandles();
	
	
	for (String handle : handles ) {
		iWinIndex++;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window(handle);
		sWindowTitle = driver.getTitle();
		 new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(sWindowTitle));
		 waitForPageLoad();
		 Thread.sleep(8000);
		if (iWindowIndex > 1 ){
			if (iWinIndex==iWindowIndex){
				driver.switchTo().window(handle);
				LoggerUtil.log_type_info("Window Switched by index and Window Title :" + sWindowTitle);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch Window", "pass", sWindowTitle);
				break;
			}else{
				driver.switchTo().defaultContent();
			}
		}else if(sNewWindowTitle.length() > 0) {
			if ( driver.getTitle().equalsIgnoreCase(sNewWindowTitle) ){
				driver.switchTo().window(handle);
				LoggerUtil.log_type_info("Window Switched by Window Title :" + sWindowTitle);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch Window", "pass", sWindowTitle);
				break;
			}else{
				driver.switchTo().defaultContent();
				LoggerUtil.log_type_warn("no switching staying with parent window");
				
			}
		}else{
			driver.switchTo().defaultContent();	
			LoggerUtil.log_type_error("fail to switch window, check with input suppplied");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch Window", "fail", "failed to switch window");
			}
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block: fail to switch window, check with input suppplied");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
}


/*==============================================================
Method Name		: switchToParentWindow
Description		: switch to Parent window
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/

public static void switchToParentWindow(){
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window(WebDriverUtil.sParentWindowName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block: fail to switchToParentWindow, check with input suppplied");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", "switchToParentWindow" + e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
}

/*==============================================================
Method Name		: waitForPageLoad
Description		: wait for page to load
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void waitForPageLoad() {
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		Wait<WebDriver> wait = new WebDriverWait(driver, 90);
		wait.until(new Function<WebDriver, Boolean>() {
		    public Boolean apply(WebDriver driver) {
		    	String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
		        return String
		            .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
		            .equals("complete");
		    }
		});
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block: waitForPageLoad, check with input suppplied");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", "waitForPageLoad" + e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
}


/*==============================================================
Method Name		: MouseHover
Description		: mouse hover on given element
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void MouseHover(WebElement webElement) {
	setOperationName("MouseHover");
	WebDriver driver = WebDriverUtil.getDriver();
	
    try {
	    	if (isElementPresent(webElement)){

	    		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		    	Actions builder = new Actions(driver) ;
		    	builder.moveToElement(webElement).perform();
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
		/*    	
		    	WebObjectUtil.clickElement(webElement);
		    	builder.build().perform();
		    	Thread.sleep(2000);
		    	WebObjectUtil.clickElement(webElement);*/
	    	}else{
    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		FrameworkUtil.takeScreenShot();
    		}
	    	
/*			//#2
	    	Locatable hoverItem = (Locatable) webElement;
	    	Mouse mouse = ((HasInputDevices) driver).getMouse();
	    	mouse.mouseMove(hoverItem.getCoordinates());
	    	
	    	//#3
	    	 hoverItem = (Locatable) webElement;
	    	 int y = hoverItem.getCoordinates().onScreen().getY();
	    	 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+y+");");
	    	 
	    	 
	    	 //#4
	    	 Point coordinates = webElement.getLocation();
	    	 Robot robot = new Robot();
	    	 //webElement.click();
	    	 robot.mouseMove(coordinates.x,coordinates.y+80);
	    	 
	    	 
	    	 //#5

	    	 
*/	    	
    }catch (Exception e) {
        	LoggerUtil.log_type_error("MouseHover " + FrameworkUtil.sElementName+ e.getMessage());
        	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", "MouseHover" + e.getMessage());
        	FrameworkUtil.takeScreenShot();
        //exception handling
    }
}

/*==============================================================
Method Name		: selectCustomWebList
Description		: select item by text from custom weblist with ul-li combination
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
note: 			//this will work noly fo ul-li tags. pass ul tag as webElement and li as "text"
==============================================================*/

	public static boolean selectCustomWebList(WebElement webElement,String sVisibleText){
		String sItem = null;
		boolean flag = false;
	    	try {
				if (WebObjectUtil.isElementPresent(webElement)){
					//WebObjectUtil.MouseHover(webElement);
					List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
					for (WebElement wb: webListItems){
						sItem =wb.getText() ;
						if (sItem.contains(sVisibleText)){
							//WebObjectUtil.MouseHover(webElement);
							WebObjectUtil.explicitWait(2);
							wb.click();
							
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: "+ sVisibleText);
							flag = true;
							break;
						}
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		    		FrameworkUtil.takeScreenShot();
	    		}
				if (!flag){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item Not found/selected: "+ sVisibleText);	
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
				FrameworkUtil.takeScreenShot();
			}
	    	return flag;
	}

	
	/*==============================================================
	Method Name		: selectCustomWebList
	Description		: select item by index from custom weblist with ul-li combination
	Author 			: Arularasu
	Creation Date 	: 11/25/2014
	Pre-Requisites	: 
	Revision History:
	note: 				//this will work noly fo ul-li tags. pass ul tag as webElement and pass index no. to select item.
						//index starts with 1
	==============================================================*/	

		public static boolean selectCustomWebList(WebElement webElement,int iByIndex){
			int iItem = 0,iTemp;
			String sItem = null;
			boolean flag = false;
		    	try {
					if (WebObjectUtil.isElementPresent(webElement)){
						//WebObjectUtil.MouseHover(webElement);
						List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
						for (WebElement wb: webListItems){
							sItem =wb.getText() ;
							iTemp = iItem + 1;
							if (iByIndex == iTemp){
								//WebObjectUtil.MouseHover(webElement);
								WebObjectUtil.explicitWait(2);
								wb.click();
								WebObjectUtil.explicitWait(2);
								//wb.click();
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: By Index No." + iByIndex + ", Item: "+sItem);
								flag = true;
								break;
							}
							iItem++;
						}
					}else{
		    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
			    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
			    		FrameworkUtil.takeScreenShot();
		    		}
				if (!flag){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item NOT selected: By Index No." + iByIndex);	
				}
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
					FrameworkUtil.takeScreenShot();
				}
		    	return flag;
		}

		
		
		/*==============================================================
		Method Name		: getToolTipsMsg
		Description		: verify tooltip text for given element
		Author 			: Arularasu
		Creation Date 	: 11/25/2014
		Pre-Requisites	: 
		Revision History:
		note: 			//this method get the innerHTML of element, so pass the parent webElement to this method
						// do not pass element with has "input" tag. instead pass parent of input tag.
		==============================================================*/	

public static boolean getToolTipsMsg(WebElement webElement,String sTooltipMsg){
	boolean bStatus = false;
	String sToolTipFromWeb;
	
	try {
		if (isElementPresent(webElement)){
			System.out.println(webElement.getText());
			sToolTipFromWeb = webElement.getAttribute("innerHTML");
			//sToolTipFromWeb = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", webElement);
			if (sToolTipFromWeb.contains(sTooltipMsg)){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sTooltipMsg);
					bStatus = true;
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sTooltipMsg);
				}
		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
			FrameworkUtil.takeScreenShot();
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getToolTipsMsg", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
	
	
	return bStatus;
	
	}
		
		

/*==============================================================
Method Name		: waitForElementPresent
Description		: wait for element to be present
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean waitForElementPresent(WebElement webElement){
	int iTimeOut = 0;
boolean bStatus = false;
boolean bElementStatus = false;
String sStartTime,sEndTime;
long TimeDiff = 0;
		try {
			sStartTime = FrameworkUtil.getCurrentTimeStamp();
			while(!bElementStatus )      //while(!bElementStatus || iTimeOut <= 30 )
			{
				bElementStatus = WebObjectUtil.isElementPresent(webElement);
				   try {
					Thread.sleep(1000);
					iTimeOut++;
					sEndTime = FrameworkUtil.getCurrentTimeStamp();
					TimeDiff = TimeDiff + FrameworkUtil.timeDiffInSeconds(sStartTime, sEndTime);
					if(iTimeOut >= 5 || TimeDiff >= 45){
						bElementStatus= true;
					}
				} catch (Exception e) {
					LoggerUtil.log_type_error("waitForElementPresent catch block :" + e.getMessage());
				}
			}
			if (WebObjectUtil.isElementPresent(webElement)){
				bStatus = true;
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "waitForElementPresent", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			FrameworkUtil.takeScreenShot();
		}
		
	return bStatus;	
}

/*==============================================================
Method Name		: waitForElementNotPresent
Description		: wait for element to be NOT present
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean waitForElementNotPresent(WebElement webElement){
	int iTimeOut = 0;
	boolean bStatus = false;
	boolean bElementStatus = true;
	String sStartTime,sEndTime;
	long TimeDiff = 0;

	try {
		sStartTime = FrameworkUtil.getCurrentTimeStamp();
		while(bElementStatus )      //while(bElementStatus || iTimeOut <= 30 )
			{
				bElementStatus = WebObjectUtil.isElementPresent(webElement);
				   try {
					Thread.sleep(1000);
					iTimeOut++;
					sEndTime = FrameworkUtil.getCurrentTimeStamp();
					TimeDiff = TimeDiff + FrameworkUtil.timeDiffInSeconds(sStartTime, sEndTime);
					if(iTimeOut >= 5 || TimeDiff >= 45){
						bElementStatus= false;
					}
				} catch (Exception e) {
					LoggerUtil.log_type_error("waitForElementNotPresent catch block :" + e.getMessage());
				}
			}
if (!WebObjectUtil.isElementPresent(webElement)){
		bStatus = true;
}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "waitForElementNotPresent", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}


return bStatus;	

}


/*==============================================================
MethodName 		: GetWebElement
Description		: get as web element from its locator
Author 			: Arularasu
Creation Date 	:02/25/2015
Pre-Requisites	:
Revision History:
==============================================================*/

public static WebElement GetWebElement(String sLocatorType, String sLocatorValue,String sElementName){
    WebElement webElement = null ;
    By by ;
    try {
    if (sLocatorType.equalsIgnoreCase("id")){
          by = By.id(sLocatorValue);    
    }else if (sLocatorType.equalsIgnoreCase("name")){
          by = By.name(sLocatorValue);  
    }else if (sLocatorType.equalsIgnoreCase("xpath")){
          by = By.xpath(sLocatorValue); 
    }else if (sLocatorType.equalsIgnoreCase("linktext")){
          by = By.linkText(sLocatorValue);    
    }else if (sLocatorType.contains("partiallinktext")){
          by = By.partialLinkText(sLocatorValue);   
    }else if (sLocatorType.contains("css")){
          by = By.cssSelector(sLocatorValue); 
    }else if (sLocatorType.contains("class")){
          by = By.className(sLocatorValue);   
    }else if (sLocatorType.equalsIgnoreCase("tagname")){
          by = By.tagName(sLocatorValue);     
    }else{
          by = By.xpath(sLocatorValue);
    }
    
    
    webElementsList = WebDriverUtil.getDriver().findElements(by);
    iWebElementsCount =webElementsList.size();
    if(iWebElementsCount > 1){
        webElement = webElementsList.get(0);
        FrameworkUtil.sElementName = sElementName;
        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElement", "multiple Element found" , "warn", "More than one element found, please find tune your locator");
    }
    else{
	    if (WebDriverUtil.getDriver().findElement(by).isDisplayed()){
	    webElement = WebDriverUtil.getDriver().findElement(by);
	    FrameworkUtil.sElementName = sElementName;
	    }
    }
/*    
    if (WebDriverUtil.getDriver().findElement(by).isDisplayed()){
	    webElement = WebDriverUtil.getDriver().findElement(by);
	    FrameworkUtil.sElementName = sElementName;
	}*/
    
    //    webElement = driver.sfindElement;
    } catch (Exception e) {
    	LoggerUtil.log_type_error("catch block: GetWebElement " + e.getMessage());
          FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElement", "issue with Identifying Element" , "warn",e.getMessage());
          FrameworkUtil.takeScreenShot();
    }
return webElement;
}


/*==============================================================
MethodName 		: getElementbyTagNameValue
Description		: get as web element from tagname and its value
Author 			: Arularasu
Creation Date 	:03/24/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static WebElement getElementbyTagNameValue(String sTagName, String sTagValue,String sElementName){
	WebElement webElement = null ;
	WebDriver driver = WebDriverUtil.getDriver();
	
	try {
		WebElement body = driver.findElement(By.tagName("body"));
		List<WebElement> span  = body.findElements(By.tagName(sTagName));
		
		for (WebElement wb: span){
			if (wb.isDisplayed() && wb.getText().equalsIgnoreCase(sTagValue)){
				webElement = wb;
				FrameworkUtil.sElementName = sElementName;
				break;
			}
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block: GetWebElement " + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getElementbyTagNameValue", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
	
	return webElement;
}


/*==============================================================
Method Name		: setFocus
Description		: set the focus to given element
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void setFocus(WebElement webElement){
	
try {
	if (isElementPresent(webElement)){
	String sTagName =webElement.getTagName(); 
	if(sTagName.equalsIgnoreCase("input")){
		webElement.sendKeys("");
		} 
		else{
		   new Actions(WebDriverUtil.getDriver()).moveToElement(webElement).perform();
	
		}
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		FrameworkUtil.takeScreenShot();
	}
	LoggerUtil.log_type_info("set focus on element " + FrameworkUtil.sElementName);
	} catch (Exception e) {
		LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "setFocus", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}

}



/*==============================================================
Method Name		: stopCurrentTestExecution
Description		: stop the current @test execution so that next will continue
Author 			: Arularasu
Creation Date 	: 05/11/2015
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void stopCurrentTestExecution(){
	try {
		
		FrameworkUtil.sTestExecutionStatus = false;
		LoggerUtil.log_type_info("stop execution called");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Stop Execution" , "calling Stop Execution", "fail", "Stop Execution called due to some issue with execution flow ");
		FrameworkUtil.takeScreenShot();
		Assert.assertTrue(FrameworkUtil.sTestExecutionStatus);
	} catch (Exception e) {
		LoggerUtil.log_type_error("Exception occured at stopCurrentTestExecution :" + e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
  }


/*==============================================================
Method Name		: getWebElementLocator
Description		: get locator of the WebElement
Author 			: Arularasu
Creation Date 	: 11/3/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static String getWebElementLocator(WebElement webElement) {  
	String sWebelement = null;
	try{
		sWebelement = webElement.toString() ;
		int startPos =sWebelement.indexOf("->");
		sWebelement = sWebelement.substring(startPos, sWebelement.length()-1);
	}catch (Exception e){
		String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
    return sWebelement; 
    
}

/*==============================================================
Method Name		: getWebElementName
Description		: get runtime WebElement data
Author 			: Arularasu
Creation Date 	: 11/04/2014
Pre-Requisites	:
Revision History:
==============================================================*/

public static String getWebElementName() { 
	String sMethodname = null;
	try{
	    StackTraceElement[] stack = new Throwable().getStackTrace();  
	    StackTraceElement ste = null;
	    if (stack.length > 1)   
	        ste = stack[3]; 
	    for (int i=0; i<=stack.length;i++){
	   // System.out.println(i +" --- "+stack[i]);
	    }
	    sMethodname = ste == null ? "[Unavailable]" : ste.getMethodName();
	    //System.out.println(sMethodname);
		}catch (Exception e){
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
			FrameworkUtil.takeScreenShot();
		}
	    return sMethodname;
	    
}




/*==============================================================
Method Name		: getCustomWebListItems
Description		: get all items from custom weblist with ul-li combination
Author 			: Arularasu
Creation Date 	: 11/25/2014
Pre-Requisites	: 
Revision History:
note: 			//this will work noly fo ul-li tags. pass ul tag as webElement and li as "text"
==============================================================*/

	public static String getCustomWebListItems(WebElement webElement){
		String sItem = null,sItemsList= null ;
	    	try {
	    		arrCustomWebListItems = new ArrayList();
				if (WebObjectUtil.isElementPresent(webElement)){
					//WebObjectUtil.MouseHover(webElement);
					List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
					for (WebElement wb: webListItems){
						sItem =wb.getText() ;
						arrCustomWebListItems.add(sItem);
						sItemsList = sItemsList + "|" + sItem;
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		    		FrameworkUtil.takeScreenShot();
	    		}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
				FrameworkUtil.takeScreenShot();
			}
	    	arrCustomWebListItems.trimToSize();
	    	return sItemsList;
	}

	public static WebElement getChildElementFromParent(String sText,WebElement wParentElement, String sChildTagName, String sSubChildTagName,int iSubChildIdex){
		WebElement wWebElement = null;
		List<WebElement> wChildElementList,wSubChildElemenList;
		int iChildCount=0,iSubChildCount=0;
		String sTextFromWebElement ;
 		if (WebObjectUtil.isElementPresent(wParentElement)){
			if (sChildTagName != null && sChildTagName.length() >0){
				wChildElementList = wParentElement.findElements(By.tagName(sChildTagName));
				for (WebElement wChildElement :wChildElementList ){
					sTextFromWebElement = wChildElement.getText();
					if(sTextFromWebElement.contains(sText)){
						wWebElement = wChildElement;
						break;
						}
					iChildCount++;
				}

				if (wChildElementList.size()>0 ){
					if ( sSubChildTagName != null && sSubChildTagName.length() >0){
					wSubChildElemenList = wChildElementList.get(iChildCount).findElements(By.tagName(sSubChildTagName));
						for (WebElement wSubChildElement :wSubChildElemenList ){
							sTextFromWebElement = wSubChildElement.getText();
							if(sTextFromWebElement.contains(sText)){
								wWebElement = wSubChildElement;
								break;
							}
							iSubChildCount++;
							if(iSubChildCount==iSubChildIdex){
								wWebElement = wSubChildElemenList.get(iSubChildIdex-1);
								break;
							}
						}
					}
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "getWebElementByTag", "sSubChildTagName" , "warn", "Sub Child tag  not found, pls check the Sub child tag name:"+sSubChildTagName);	
				}
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "getWebElementByTag", "ChildTagName" , "warn", "Child tag  not found, pls check the child tag:"+sChildTagName);	
			}
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "getWebElementByTag", "Parent WebElement" , "fail", "Parent Element not found");	
		}
		return wWebElement;
	}
	

	/*==============================================================
	Method Name		: GetLocatorValueFromProperty
	Description		: Get Locator value from Dynamic property file and update its parameter(s).
	Author 			: Arularasu
	Creation Date 	: 09/21/2015
	Pre-Requisites	: 
	Revision History:
	Note			: if locator has multiple parameters, pass the parameters with comma (,) seperated
	==============================================================*/
	public static String getLocatorValueFromProperty(String sDynamicPageFactoryName,String sParameterName, String sParameterValue){
		String sLocatorValue,arrParameterName[] = null,arrParameterValue[] = null;
		sLocatorValue = (String) FrameworkUtil.dictDynamicPagePactory.get(sDynamicPageFactoryName);
		
		if (sLocatorValue.contains(sParameterName)){
			sLocatorValue = sLocatorValue.replace(sParameterName, sParameterValue);
			return sLocatorValue;
		}else if (sParameterName.contains(",")){
			arrParameterName = sParameterName.split(",");
			arrParameterValue = sParameterValue.split(",");
			if (arrParameterName.length == arrParameterValue.length){
				for (int i=0 ; i<arrParameterName.length;i++){
					sLocatorValue = sLocatorValue.replace(arrParameterName[i], arrParameterValue[i]);
				}
			}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetLocatorValueFromProperty", "Dynamic pagefactory" , "warn", "Parameter name and value count are not matching, pls check your input(s)");
			}
		}
		else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetLocatorValueFromProperty", "Dynamic pagefactory" , "warn", "Parameter not found in locator, pls check your input(s), Locator:" + sLocatorValue + "  and ParameterName:" + sParameterName);
		}
		return sLocatorValue;
	}
	
	
	/*==============================================================
	Method Name		: GetWebElementFromDynamicLocator
	Description		: Get web element from dynamic Locator value which are present on property file .
	Author 			: Arularasu
	Creation Date 	: 09/22/2015
	Pre-Requisites	: 
	Revision History:
	Note			: if locator has multiple parameters, pass the parameters with comma (,) seperated
	==============================================================*/
	public static WebElement getWebElementFromDynamicLocator(String sLocatorType, String sDynamicPageFactoryName,String sParameterName, String sParameterValue){
		String sLocatorValue,arrParameterName[] = null,arrParameterValue[] = null;
		sLocatorValue = (String) FrameworkUtil.dictDynamicPagePactory.get(sDynamicPageFactoryName);
		WebElement webElement;
		if (sLocatorValue.contains(sParameterName)){
			sLocatorValue = sLocatorValue.replace(sParameterName, sParameterValue);
		}else if (sParameterName.contains(",")){
			arrParameterName = sParameterName.split(",");
			arrParameterValue = sParameterValue.split(",");
			if (arrParameterName.length == arrParameterValue.length){
				for (int i=0 ; i<arrParameterName.length;i++){
					sLocatorValue = sLocatorValue.replace(arrParameterName[i], arrParameterValue[i]);
				}
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElementFromDynamicLocator", "Dynamic pagefactory" , "warn", "Parameter name and value count are not matching, pls check your input(s)");
			}
		}
		else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElementFromDynamicLocator", "Dynamic pagefactory" , "warn", "Parameter not found in locator, pls check your input(s), Locator:" + sLocatorValue + "  and ParameterName:" + sParameterName);
		}
		
		webElement = GetWebElement(sLocatorType, sLocatorValue, sDynamicPageFactoryName);
		return webElement;
	}

}

