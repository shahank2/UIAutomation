package com.pages.Bond;

import com.helper.TestcaseHelper;
import com.pageaction.PageActionHelper;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class BondTabSelectionPage extends TestcaseHelper //To Click on Desired Bond sub class (Attributes or Aliases)

{

    private static final By Attributes = By.linkText("Attributes");
    private static final By Aliases = By.linkText("Aliases");

    public void ClickAttributesTab() //Method to click on Attribute Sub class (Attributes Tab)
    {
        PageActionHelper.clicklink(Attributes);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void ClickAliasesTab() //Method to click on Alias Sub class (Aliases Tab)
    {
        PageActionHelper.clicklink(Aliases);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



}





   


