package com.DemandPortal.testcases;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.DemandPortal.pagefactory.DemandDetailScreenTestPageFactory;
import com.DemandPortal.pagefactory.SmokeTestPageFactory;
import com.commonUtils.FrameworkUtil;
import com.commonUtils.LoggerUtil;
import com.commonUtils.WebDriverUtil;
import com.commonUtils.WebObjectUtil;

public class SmokeTestCase {
	//String sSummaryURL = LoginTestCase.sSummaryURL;
	
	public static SmokeTestPageFactory smokeTest = new SmokeTestPageFactory();
	public static DemandDetailScreenTestPageFactory demandInfo=new DemandDetailScreenTestPageFactory();
	
	
	@Test(priority=1)
	public void homePagePortletsLinks(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "homePageportletsLinks";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Home Page portlets & Links";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			LoginTestCase.loginSESA402879();
			WebObjectUtil.verifyElementPresent(smokeTest.getDemandPortalLink());
			WebObjectUtil.verifyElementPresent(smokeTest.getSchneiderLogoImage());
			WebObjectUtil.verifyElementPresent(smokeTest.getHomeLink());
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemandLink());
			WebObjectUtil.verifyElementPresent(smokeTest.getSearchInput());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
		
		
	}
	@Test(priority=2)
	public void verifyCreateDemandPage(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyCreateDemandPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Create Demand Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			String sTitle = (String)FrameworkUtil.dictPropertyData.get("DEMAND.TITLE");
			String sTitleDescription=(String)FrameworkUtil.dictPropertyData.get("DEMAND.TITLE.DESCRIPTION");
			String sRequester=(String)FrameworkUtil.dictPropertyData.get("DEMAND.REQUESTER");
			String sLifecycle=(String)FrameworkUtil.dictPropertyData.get("DEMAND.LIFECYCLE");
			String sBusinessAreaCategory=(String)FrameworkUtil.dictPropertyData.get("DEMAND.BUSINESSAREA.CATEGRY");
			String sBusinessAreaArea=(String)FrameworkUtil.dictPropertyData.get("DEMAND.BUSINESSAREA.AREA");
			String sInvestmentClassification=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INVESTMENT.CLASSIFICATION");
			
			//Actions action = new Actions(driver);
			
			WebObjectUtil.clickElement(smokeTest.getCreateDemandLink());
						
			WebObjectUtil.switchToFrame(smokeTest.getCreateDemand_Frame());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemand_Title());
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemand_TitleDescription());
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemand_RequesterInput());
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemand_BusinesAreaCategoryList());
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemand_LifeCycleStageList());
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemand_InvestmentClassificationList());
			WebObjectUtil.verifyElementPresent(smokeTest.getCreateDemand_SubmitButton());
			
			WebObjectUtil.SetValueEdit(smokeTest.getCreateDemand_Title(), sTitle);
			WebObjectUtil.SetValueEdit(smokeTest.getCreateDemand_TitleDescription(), sTitleDescription);
			WebObjectUtil.SetValueEdit(smokeTest.getCreateDemand_RequesterInput(), sRequester);
			//action.doubleClick(smokeTest.getCreateDemand_RequesterInput());
			//action.moveToElement(smokeTest.getCreateDemand_RequesterList()).click();
			WebObjectUtil.selectCustomWebList(smokeTest.getCreateDemand_RequesterList(), sRequester);
			WebObjectUtil.clickElement(smokeTest.getCreateDemand_RequesterInputTickLink());
			WebObjectUtil.selectWebList(smokeTest.getCreateDemand_BusinesAreaCategoryList(),sBusinessAreaCategory ,null,null);
			WebObjectUtil.selectWebList(smokeTest.getCreateDemand_BusinesAreaAreaList(), sBusinessAreaArea,null,null);
			WebObjectUtil.selectWebList(smokeTest.getCreateDemand_LifeCycleStageList(), sLifecycle,null,null);
			WebObjectUtil.selectWebList(smokeTest.getCreateDemand_InvestmentClassificationList(), sInvestmentClassification,null,null);
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(smokeTest.getCreateDemand_SubmitButton());
			//WebObjectUtil.explicitWait(15);
			//LoginTestCase.logout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	@Test(priority=3)
	public void enterDemandDetailsAndSubmit(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		PageFactory.initElements(driver, demandInfo);
		
		
		try {
			FrameworkUtil.sTestCaseName = "enterDemandDetailsAndSubmit";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Enter Qualify demand details and click on submit in demand details screen";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			String sScopedIPORegion = (String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.SCOPED.IPO.REGION");
			String sScopedIPOCountries=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.SCOPED.IPO.COUNTRIES");
			String sSolComplexity=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.SOL.COMPLEXITY");
			String sNoofUsers=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.NO.OF.USERS");
			String sReqBusiness=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.REQ.BUSINESS");
			String sQuarter=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.QUARTER");
			String sYear=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.YEAR");
			String sScope=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.SCOPE");
			String sExpBudget=(String)FrameworkUtil.dictPropertyData.get("DEMAND.INFO.EXP.BUDGET");
			
			String sULElementXpath =(String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");

			//LoginTestCase.loginSESA402879();
			
			//WebElement el=driver.findElement(By.id("Theme_TH_wt105_block_wtMainContent_WebPatterns_wt101_block_wtContent_WebPatterns_wtNavigationTabs_block_wtContent1_WebPatterns_wt137_block_wtColumn2_wtDemandsList_ctl00_WebPatterns_wt76_block_wtColumn2_Patterns_TH_wt62_block_wtContent_wt48"));
			//el.click();
			
			WebObjectUtil.clickElement(demandInfo.getDemandInfo_EditButton());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(demandInfo.getDemandInfo_ScopedIPORegionListArrowButton());
			WebElement wDropdown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDropdown, sScopedIPORegion);
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(demandInfo.getDemandInfo_ScopedIPOCountriesListArrowButton());
			wDropdown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDropdown, sScopedIPOCountries);
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.selectWebList(demandInfo.getDemandInfo_SolComplexityList(), sSolComplexity, null, null);
			WebObjectUtil.SetValueEdit(demandInfo.getDemandInfo_NoOfUsers(), sNoofUsers);
			WebObjectUtil.selectWebList(demandInfo.getDemandInfo_RequestorsBusinessGlobalFunctionList(), sReqBusiness, null, null);
			WebObjectUtil.selectWebList(demandInfo.getDemandInfo_BusinessExpectedCompletionQList(), sQuarter, null, null);
			WebObjectUtil.selectWebList(demandInfo.getDemandInfo_BusinessExpectedCompletionYList(), sYear, null, null);
			WebObjectUtil.SetValueEdit(demandInfo.getDemandInfo_ScopeInput(), sScope);
			WebObjectUtil.SetValueEdit(demandInfo.getDemandInfo_ExpectedRequestedBudgetInput(), sExpBudget);
			WebObjectUtil.clickElement(demandInfo.getDemandInfo_SubmitButton());
			WebObjectUtil.explicitWait(10);
			//WebElement el=driver.findElement(By.id("Theme_TH_wt105_block_wtMainContent_WebPatterns_wt101_block_wtContent_WebPatterns_wtNavigationTabs_block_wtContent1_WebPatterns_wt137_block_wtColumn2_wtDemandsList_ctl00_WebPatterns_wt76_block_wtColumn2_Patterns_TH_wt62_block_wtContent_wt48"));
			//el.click();
			Alert alrt= driver.switchTo().alert();
			alrt.accept();
			
			LoginTestCase.logout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=3)
	public void fileupload(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		PageFactory.initElements(driver, demandInfo);
		
		
		try {
			FrameworkUtil.sTestCaseName = "enterDemandDetailsAndSubmit";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Enter Qualify demand details and click on submit in demand details screen";
			
			String filepath="C://Users//SESA459278//Downloads//dissertacao (1).pdf";
			String autoitscriptpath="C://Users//SESA459278//Desktop//Fileupload1.exe";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			LoginTestCase.loginSESA402879();
			WebElement el=driver.findElement(By.id("Theme_TH_wt105_block_wtMainContent_WebPatterns_wt101_block_wtContent_WebPatterns_wtNavigationTabs_block_wtContent1_WebPatterns_wt137_block_wtColumn2_wtDemandsList_ctl00_WebPatterns_wt76_block_wtColumn2_Patterns_TH_wt62_block_wtContent_wt48"));
			el.click();
			driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/div[3]")).click();
			
			WebElement brs=driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/span/div[3]/div[4]/div/div[1]/div[1]/a[1]"));
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.scrollElementAtPageCenter(brs);
			WebObjectUtil.clickElement(brs);
			//driver.switchTo().frame((WebElement) By.tagName("iframe "));
			//WebElement wFrameElement=driver.findElement(By.tagName("iframe "));
			WebObjectUtil.switchToFrame(smokeTest.getCreateDemand_Frame());
			driver.findElement(By.id("wtUploadedFile")).click();
			
			WebObjectUtil.explicitWait(10);
			//Runtime.getRuntime().exec("cmd.exe /c Start AutoIt3.exe " + autoitscriptpath + " \""+ filepath + "\"");
			Runtime.getRuntime().exec(autoitscriptpath);
			
			System.out.println("SUKUR");
			LoginTestCase.logout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	//update each @Test result in custom result file
	@AfterMethod
	public void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	/*
	@BeforeTest
	public void beforeTest(){
		
		FrameworkUtil.sTestCaseName = "Login";
		FrameworkUtil.sManualTestCaseName="SmokeTest-Login to Navigator";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		//LoginTestCase.nav_Login(sUserName, sPassword);
		
		LoginTestCase.LoginAsQaautoUser();
		
		sSummaryURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		//sSummaryURL = smokeTest.getNav_HomeBreadScrumb().getAttribute("href");
		//sSummaryURL=sSummaryURL.replace("/home", "/navigator");
		
		String[] arrURL = sSummaryURL.split(".com"); 
		sSummaryURL=arrURL[0]+".com";
		//WebDriverUtil.getDriver().get(sSummaryURL);
		
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	*/
	@AfterTest
	public void afterTest(){
		FrameworkUtil.sTestCaseName = "Logout";
		FrameworkUtil.sManualTestCaseName="SmokeTest-Logout Navigator";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		/*if (LoginTestCase.bLoginStatus)
		LoginTestCase.nav_Logout();*/
		FrameworkUtil.updateTestCaseStatusinResult();
		
		//verifyPermissionsPage();
		
	}
	
	
}