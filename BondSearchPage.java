package com.pages.Bond;

import com.helper.TestcaseHelper;
import com.pageaction.PageActionHelper;
import com.utilities.ReadDataFromExcel;
import org.openqa.selenium.By;

import java.io.IOException;


public class BondSearchPage extends TestcaseHelper //To search for Bond entity

{

    private static final By advance = By.linkText("Advanced");
    private static final By Result = By.xpath("/html/body/div[3]/div/section/div/div[2]/div[3]/div[2]/div[5]/div/div[2]/div[1]");
    private static final By input = By.xpath("//input[@name='securityId']");
    private static final By SearchButton = By.xpath("//*[@data-bind='click: searchIt']");


    public void searchForBondToEditAttribute() throws IOException

    {
        PageActionHelper.clicklink(advance);
        PageActionHelper.typeintoInputBox(input, ReadDataFromExcel.readDataFromExcel("Bond", 1, 0));
        PageActionHelper.clickButton(SearchButton);
        String value = PageActionHelper.getlinktext(Result);//result.gettext();
        System.out.println("Value of resulting SecurityId is " + value);

    }


    public void searchForBondToEditAlias() throws IOException, InterruptedException

    {
        Thread.sleep(4000);
        PageActionHelper.clicklink(advance);
        Thread.sleep(4000);
        PageActionHelper.typeintoInputBox(input, ReadDataFromExcel.readDataFromExcel("Bond", 2, 0));
        PageActionHelper.clickButton(SearchButton);
        String value = PageActionHelper.getlinktext(Result);//result.gettext();
        System.out.println("Value of resulting SecurityId is " + value);

    }
}


