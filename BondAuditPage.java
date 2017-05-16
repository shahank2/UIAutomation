package com.pages.Bond;


import com.helper.TestcaseHelper;
import com.pageaction.PageActionHelper;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BondAuditPage extends TestcaseHelper //Method to load Attribute Audit details for verifying user Audit are captured in Audit logs

{


    private static final By AuditMenu = By.xpath("/html/body/div[3]/div/section/div/div[1]/div/ul[3]/li[3]/a/span");
    private static final By AuditOption = By.linkText("Audit");


    public void SelectAuditOptionAndVerifyAttribute(String Data) throws InterruptedException //Method to load Audit Data and verify for the Attribute or Alias Added
    {
        Set<String> initialWindowsOpen = driver.getWindowHandles();
        PageActionHelper.clicklink(AuditMenu);
        String handle = driver.getWindowHandle();
        System.out.println("Current Handle value is " + handle + "\n");
        PageActionHelper.clicklink(AuditOption);
        Thread.sleep(20000);
        System.out.println("Windows handle for open window are " + driver.getWindowHandles() + "\n");
        Set<String> finalWindowsOpen = driver.getWindowHandles();
        finalWindowsOpen.removeAll(initialWindowsOpen);
        List<String> finalWindowRemaining = new ArrayList<String>(finalWindowsOpen);
        driver.switchTo().window(finalWindowRemaining.get(0));
        String DisplayedValue = driver.findElement(By.xpath("//*[contains(text(), 'securityAttributes')]/../div[contains(@class, 'slick-cell l2 r2')]")).getText();
        System.out.println("Value is displayed as " + DisplayedValue + "\n");
        Assert.assertEquals(DisplayedValue, Data);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().window(handle);

   }


    public void SelectAuditOptionAndVerifyAlias(String Data) throws InterruptedException //Method to load Alias Audit details for verifying user Audit are captured in Audit logs
    {
        Set<String> initialWindowsOpen = driver.getWindowHandles();
        PageActionHelper.clicklink(AuditMenu);
        String handle = driver.getWindowHandle();
        System.out.println("Current Handle value is " + handle + "\n");
        PageActionHelper.clicklink(AuditOption);
        Thread.sleep(20000);
        System.out.println("Windows handle for open window are " + driver.getWindowHandles() + "\n");
        Set<String> finalWindowsOpen = driver.getWindowHandles();
        finalWindowsOpen.removeAll(initialWindowsOpen);
        List<String> finalWindowRemaining = new ArrayList<String>(finalWindowsOpen);
        driver.switchTo().window(finalWindowRemaining.get(0));
        String DisplayedValue = driver.findElement(By.xpath("//*[contains(text(), 'securityIdMaps')]/../div[contains(@class, 'slick-cell l2 r2')]")).getText();
        System.out.println("Value is displayed as " + DisplayedValue + "\n");
        Assert.assertEquals(DisplayedValue, Data);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.switchTo().window(handle);

    }


}



