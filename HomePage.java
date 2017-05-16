package com.pages.Bond;


import com.helper.TestcaseHelper;
import com.pageaction.PageActionHelper;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class HomePage extends TestcaseHelper //This is base class to click on Search link from Home page

{

    private static final By Search = By.xpath("//a[contains(text(),'Search')]");

	public EntitySelectPage ClickSearchPage() throws InterruptedException //Method to click on Search link from Home page
	{
        Thread.sleep(5000);
        PageActionHelper.clicklink(Search);
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 return new EntitySelectPage();
	 
	}
	
}

	