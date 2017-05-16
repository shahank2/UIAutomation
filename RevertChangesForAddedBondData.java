package com.pages.Bond;

import com.helper.TestcaseHelper;
import com.pageaction.PageActionHelper;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class RevertChangesForAddedBondData extends TestcaseHelper //To revert changes (deleted Added data for Bond)

{

    private static final By Attributes = By.linkText("Attributes");
    private static final By Alias = By.linkText("Aliases");


    public void RevertAttributeAdded() //Method to Delete added Dummy attribute in Attributes Tab
    {
        PageActionHelper.clicklink(Attributes);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//tr[contains(td[2], 'Dummy')]/td[1]")).click();
        System.out.println("Deleting Added Attribute" + "\n");

    }

    public void RevertAliasAdded() //Method to Delete added Test Alias in Aliases Tab
    {

        PageActionHelper.clicklink(Alias);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//tr[contains(td[2], 'Test')]/td[1]")).click();
        System.out.println("Deleting Added Alias" + "\n");

    }
}

