package com.Schneider.DemandPortal.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Schneider.commonUtils.FrameworkUtil;

public class AboutPageFactory
{
	
	@FindBy(how=How.XPATH, using ="//div[@id='AboutPortletDiv']/div/div")
	private WebElement nav_AboutHeader;
	
	}


	
	
