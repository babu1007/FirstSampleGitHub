package com.Schneider.DemandPortal.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Schneider.commonUtils.FrameworkUtil;
import com.Schneider.commonUtils.WebObjectUtil;

public class SmokeTestPageFactory {
	
	//Demand Portal Home Page
	@FindBy(how=How.XPATH,using="//div[text()='Demand Portal']")
	private WebElement DemandPortalLink;

	@FindBy(how=How.XPATH, using="//img[contains(@src,'logo_white_schneider.png')]")
	private WebElement SchneiderLogoImage;
	
	@FindBy(how=How.XPATH, using="//a[text()='Home']")
	private WebElement HomeLink;
	
	
	@FindBy(how=How.XPATH, using="//a[text()='CREATE NEW DEMAND']")
	private WebElement CreateDemandLink;
	
	@FindBy(how=How.XPATH, using="//div[@class='Others_Menu']//input[contains(@id,'wtInputMenuSearch')]")
	private WebElement SearchInput;

	@FindBy(how=How.XPATH, using="//div[text()='Create Demand']")
	private WebElement CreateDemandTextOnCreateDemandWindow;
	
	
	@FindBy(how=How.XPATH, using="//iframe[contains(@src,'leap.schneider-electric.com')]")
	private WebElement CreateDemand_Frame;
	
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'wtDemand_Title')]")
	private WebElement CreateDemand_Title;
	
	@FindBy(how=How.XPATH, using="//textarea[contains(@id,'wtDemand_Description')]")
	private WebElement CreateDemand_TitleDescription;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'wtUsernameSearch')]")
	private WebElement CreateDemand_RequesterInput;
	
	@FindBy(how=How.XPATH, using="//ul[1]")
	private WebElement CreateDemand_RequesterList;
	
	@FindBy(how=How.XPATH, using="//a[contains(@id,'wtRequestorLookUp_block_wtCheck')]")
	private WebElement CreateDemand_RequesterInputTickLink;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'wtDemand_Program_Id')]")
	private WebElement CreateDemand_LifeCycleStage;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'wtBusinessAreaStructure')]")
	private WebElement CreateDemand_BusinesAreaCategory;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'wtDemand_BusinessAreaFinalId')]")
	private WebElement CreateDemand_BusinesAreaArea;
	
	@FindBy(how=How.XPATH, using="//select[contains(@id,'wtInvestmentClassificationDropDown')]")
	private WebElement CreateDemand_InvestmentClassification;
	
	@FindBy(how=How.XPATH, using="//input[@value='SUBMIT']")
	private WebElement CreateDemand_SubmitButton;

	
	public WebElement getDemandPortalLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return DemandPortalLink;
	}

	public WebElement getSchneiderLogoImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return SchneiderLogoImage;
	}

	public WebElement getHomeLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return HomeLink;
	}

	public WebElement getCreateDemandLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemandLink;
	}

	public WebElement getSearchInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return SearchInput;
	}

	
	
	public WebElement getCreateDemand_Frame() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_Frame;
	}
	public WebElement getCreateDemandTextOnCreateDemandWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemandTextOnCreateDemandWindow;
	}

	public WebElement getCreateDemand_Title() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_Title;
	}

	public WebElement getCreateDemand_TitleDescription() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_TitleDescription;
	}

	public WebElement getCreateDemand_RequesterInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_RequesterInput;
	}
	
	public WebElement getCreateDemand_RequesterList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_RequesterList;
	}
	
	public WebElement getCreateDemand_RequesterInputTickLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_RequesterInputTickLink;
	}
	
	public WebElement getCreateDemand_BusinesAreaCategoryList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_BusinesAreaCategory;
	}
	
	public WebElement getCreateDemand_BusinesAreaAreaList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_BusinesAreaArea;
	}
	
	public WebElement getCreateDemand_LifeCycleStageList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_LifeCycleStage;
	}

	public WebElement getCreateDemand_InvestmentClassificationList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_InvestmentClassification;
	}

	public WebElement getCreateDemand_SubmitButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CreateDemand_SubmitButton;
	}
	
	
	
	
}
