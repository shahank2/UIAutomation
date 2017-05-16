package com.pages.Bond;

import com.TestcaseHelper;
import com.pageaction.PageActionHelper;
import org.openqa.selenium.By;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BondDataDetailsPage extends TestcaseHelper //To search for Bond entity

{
    private static final By Result = By.xpath("/html/body/div[3]/div/section/div/div[2]/div[3]/div[2]/div[5]/div/div[2]/div[1]");

    public void ClickResultRecordToLoadDetails() throws InterruptedException   //Method to click on Result data and load details, after searching for a Particular Bond via security ID
    {

        String handle = driver.getWindowHandle();
//        System.out.println("Current Handle value is " + handle + "\n");
        PageActionHelper.clicklink(Result);
        @SuppressWarnings("rawtypes")
        Set handles = driver.getWindowHandles();
//        System.out.println("Handle value of all windows are " + handles + "\n");
        for (String currentwindow : driver.getWindowHandles())
        {
            if (!currentwindow.equals(handle))
            {
                System.out.println("Current Window handle is" + currentwindow + "\n");
                driver.switchTo().window(currentwindow);
                driver.manage().window().maximize();
            }
        }
        System.out.println("url of new opened window is " + driver.getCurrentUrl() + "\n");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("clicking on Desired Sub class" + "\n");
        Thread.sleep(10000);
    }

   
}

