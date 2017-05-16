package com.pages.Bond;

import com.TestcaseHelper;
import com.pageaction.PageActionHelper;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class EntitySelectPage extends TestcaseHelper //To Select Bond Entity from entity selection page

{

    private static final By Bond = By.xpath("//Span[contains(text(),'Bond')]");

	public BondSearchPage Bond() //Method to Select Bond entity after clicking Search Link on Home Page
	{
		System.out.println("Selecting Entity Bond \n");
        PageActionHelper.clicklink(Bond);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return new BondSearchPage();
	}
}

