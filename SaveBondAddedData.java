package com.pages.Bond;

import com.helper.TestcaseHelper;
import com.pageaction.PageActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
* Created by shahank2 on 12/9/2016.
*/
public class SaveBondAddedData extends TestcaseHelper
{

    private static final By EnterBusinessJustification = By.xpath("//*[contains(@class,'bootbox-input bootbox-input-textarea form-control')]");
    private static final By OkButton = By.xpath("//*[contains(@class,'btn btn-primary')]");

    @FindBy(xpath = "//*[@data-bind='value: name, typeahead: $root.list']") //Locate WebElement
    private List<WebElement> InputName;

    @FindBy(xpath = "//*[@data-bind='value: value']")
    private List<WebElement> InputValue;

    @FindBy(xpath = "//*[@data-bind='click: $root.createIt']")
    private List<WebElement> Add;


    public SaveBondAddedData()  //POM Method to initialize page objects(WebElements)
    {
              PageFactory.initElements(driver, this);
    }

    private void SaveAddedBondAttribute()  //Method to click on Save button after adding Attributes
    {
        for (WebElement saveattributebutton : Add)
        {
            if (saveattributebutton.isDisplayed())
            {
                PageActionHelper.clickwebelement(saveattributebutton);
                System.out.println("Added Attribute is saved" + "\n");
                driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
                break;
            }

        }

    }


    private void SaveAddedBondAliases() //Method to click on Save button after adding Aliases
    {
        for (WebElement savealiasbutton : Add)
        {
            if (savealiasbutton.isDisplayed())
            {
                PageActionHelper.clickwebelement(savealiasbutton);
                System.out.println("Added Alias is saved" + "\n");
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            }

        }
    }

    private void EnterNameField(String Data)   //Method to input Name details while data under Attributes or Alises Tab

    {
        for (WebElement NameField : InputName)
        {
//            System.out.println("Duplicate" + we.isDisplayed());
            if (NameField.isDisplayed())
            {
               PageActionHelper.clickwebelement(NameField);
                System.out.println("Editing Name Field" + "\n");
                PageActionHelper.sendkeystowebelement(NameField, Data);
                break;
            }
        }

    }

    private void EnterValueField(String Data)    //Method to input Value details while data under Attributes or Alises Tab

    {
        for (WebElement ValueField : InputValue)
        {
//            System.out.println("Duplicate" + webElement.isDisplayed());
            if (ValueField.isDisplayed()) {

                PageActionHelper.clickwebelement(ValueField);
                System.out.println("Editing Value Field" + "\n");
                PageActionHelper.sendkeystowebelement(ValueField, Data);
                break;
            }
        }

    }


    public void testAdditionOfBondAttribute() throws InterruptedException //Method to enter Attribute details and save Attribute

    {
        EnterNameField("Dummy");
        EnterValueField("XYZ");
        SaveAddedBondAttribute();
    }

    public void testAdditionOfBondAlias() //Method to enter Alias details and save Attribute
    {
        EnterNameField("Test");
        EnterValueField("XYZ");
        SaveAddedBondAliases();
    }



    public void EnterBusinessJustification(String text) throws InterruptedException //Method to Enter Justification while adding Aliases.
    {
        PageActionHelper.typeintoInputBox(EnterBusinessJustification, text);
        PageActionHelper.clickButton(OkButton);
        Thread.sleep(12000);
    }

}

