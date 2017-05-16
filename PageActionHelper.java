package com.pageaction;

import com.elements.Button;
import com.elements.InputTextBox;
import com.elements.Link;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by shahank2 on 12/28/2016.
 */
public class PageActionHelper //Method to perform different action on elements

{

    // Button Class functions
    public static void verifyButtonEnabled(By id, String name)
    {
        Button button = new Button(id);
        Assert.assertTrue(button.isEnabled());
    }

    public static void clickButton(By id)
    {
        Button button = new Button(id);
        button.click();
    }

    public static void checkbutton(By id, String name)
    {
        Button button = new Button(id);
        Assert.assertTrue(button.isDisplayed());
    }

    public static void verifyButtonDisabled(By id, String name)
    {
        Button button = new Button(id);
        Assert.assertTrue(button.isDisplayed());
    }

    // Link Functions

    public static void clicklink(By id)
    {
        Link link = new Link(id);
        link.click();
    }

    public static void verifylinkDisplayed(By id)
    {
        Link link = new Link(id);
        Assert.assertTrue(link.isDisplayed());
    }

    public static boolean verifylinkisDisplayed(By id)
    {
        Link link = new Link(id);
        return (link.isDisplayed());
    }

    public static String  getlinktext(By id)
    {
        Link link = new Link(id);
        return (link.getText());

    }

    // Input Text Box Functions
    public static void typeintoInputBox(By id, String text)
    {
        InputTextBox inputBox = new InputTextBox(id);
        inputBox.setValue(text);
    }


    public static void clearinputBox(By id)
    {
        InputTextBox inputBox = new InputTextBox(id);
        inputBox.clear();
    }

    public static void clickinputbox(By id)
    {
        InputTextBox inputBox = new InputTextBox(id);
        inputBox.Click();
    }

    public static String gettextinputbox(By id)
    {
        InputTextBox inputBox = new InputTextBox(id);
        return inputBox.getvalue();
    }

    public static void verifyinputboxEnabled(By id,String name)
    {
        InputTextBox inputBox = new InputTextBox(id);
        Assert.assertTrue(inputBox.isEnabled());
    }

    public static void checkinputbox(By id, String name)
    {
        InputTextBox inputBox = new InputTextBox(id);
        Assert.assertTrue(inputBox.isDisplayed());
    }

    public static void checkinputboxnotpresent(By id, String name)
    {
        InputTextBox inputBox = new InputTextBox(id);
        Assert.assertFalse(inputBox.isDisplayed());
    }

    // Generic WebElement Functions
    public static void clickwebelement(WebElement element)
    {
        element.click();
    }

    public static void sendkeystowebelement(WebElement element, String Data)
    {
        element.sendKeys(Data);

    }
}
