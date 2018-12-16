package com.DemandPortal.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.commonUtils.FrameworkUtil;
import com.commonUtils.WebObjectUtil;

public class DemandDetailScreenTestPageFactory {
	
	//Demand Details Information Page
	
		@FindBy(how=How.XPATH, using="//input[@value='EDIT']")
		private WebElement DemandInfo_EditButton;
		
		@FindBy(how=How.XPATH, using="//input[@value='CANCEL']")
		private WebElement DemandInfo_CancelButton;
		
		@FindBy(how=How.XPATH, using="//input[@value='SAVEASDRAFT']")
		private WebElement DemandInfo_SaveAsDraftButton;
		
		@FindBy(how=How.XPATH, using="//input[@value='SUBMIT']")
		private WebElement DemandInfo_SubmitButton;
		
		@FindBy(how=How.XPATH, using="//span[contains(@id,'wtRegionDropDownAjaxRfrsh')]//span[@class='select2-arrow']")
		private WebElement DemandInfo_ScopedIPORegionListArrowButton;
		
		@FindBy(how=How.XPATH, using="//div[contains(@id,'wtCountryFilter')]//span[@class='select2-arrow']")
		private WebElement DemandInfo_ScopedIPOCountriesListArrowButton;
		
		@FindBy(how=How.XPATH, using="//select[contains(@id,'wtDemand_NatureId')]")
		private WebElement DemandInfo_SolComplexityList;
	
		@FindBy(how=How.XPATH, using="//input[contains(@id,'wtDemand_NumberOfUsers2')]")
		private WebElement DemandInfo_NoOfUsers;
		
		@FindBy(how=How.XPATH, using="//select[contains(@id,'wtContent_wt102')]")
		private WebElement DemandInfo_RequestorsBusinessGlobalFunctionList;
		
		@FindBy(how=How.XPATH, using="//select[contains(@id,'wtContent_wtQuarter')]")
		private WebElement DemandInfo_BusinessExpectedCompletionQList;
		
		@FindBy(how=How.XPATH, using="//select[contains(@id,'wtContent_wt218')]")
		private WebElement DemandInfo_BusinessExpectedCompletionYList;
		
		@FindBy(how=How.XPATH, using="//textarea[contains(@id,'wtContent_wtDemand_Scope')]")
		private WebElement DemandInfo_ScopeInput;
		
		@FindBy(how=How.XPATH, using="//input[contains(@id,'wtContent_wtDemand_ExpectedBudget')]")
		private WebElement DemandInfo_ExpectedRequestedBudgetInput;

		public WebElement getDemandInfo_EditButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_EditButton;
		}

		public WebElement getDemandInfo_CancelButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_CancelButton;
		}

		public WebElement getDemandInfo_SaveAsDraftButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_SaveAsDraftButton;
		}

		public WebElement getDemandInfo_SubmitButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_SubmitButton;
		}

		public WebElement getDemandInfo_ScopedIPORegionListArrowButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_ScopedIPORegionListArrowButton;
		}

		public WebElement getDemandInfo_ScopedIPOCountriesListArrowButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_ScopedIPOCountriesListArrowButton;
		}

		public WebElement getDemandInfo_SolComplexityList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_SolComplexityList;
		}

		public WebElement getDemandInfo_NoOfUsers() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_NoOfUsers;
		}

		public WebElement getDemandInfo_RequestorsBusinessGlobalFunctionList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_RequestorsBusinessGlobalFunctionList;
		}

		public WebElement getDemandInfo_BusinessExpectedCompletionQList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_BusinessExpectedCompletionQList;
		}

		public WebElement getDemandInfo_BusinessExpectedCompletionYList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_BusinessExpectedCompletionYList;
		}

		public WebElement getDemandInfo_ScopeInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_ScopeInput;
		}

		public WebElement getDemandInfo_ExpectedRequestedBudgetInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return DemandInfo_ExpectedRequestedBudgetInput;
		}
		
		
		
		
}
