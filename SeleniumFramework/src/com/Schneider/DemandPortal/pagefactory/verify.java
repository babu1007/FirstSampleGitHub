package com.Schneider.DemandPortal.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Schneider.commonUtils.FrameworkUtil;

public class verify
{
	
	@FindBy(how=How.ID, using ="TestSummary")
	private WebElement nav_TestSummaryTable;
	
	
	public WebElement getNav_TestSummaryTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TestSummaryTable;
	}


	
	
}
