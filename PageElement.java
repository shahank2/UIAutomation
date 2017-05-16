package com.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;

//import com.va.util.SeleniumHelper;

import com.unity.helper.TestcaseHelper;

public abstract class PageElement {

    protected static final int MAX_RETRIES = 5;
  //  protected static final SeleniumHelper seleniumHelper = SeleniumHelper.get();

    protected final WebElement webElement;
    protected final String id;


    public PageElement(String id) {
         this.id = id;
       //  this.webElement = seleniumHelper.getElement(By.id(id));
         this.webElement = TestcaseHelper.driver.findElement(By.id(id));
    }
    
     public PageElement(By by) {
     this.id = null;
   //  this.webElement = seleniumHelper.getElement(by);
     this.webElement = TestcaseHelper.driver.findElement(by);
     }


     public String getid()
     {
         return id;
     }


     public boolean isEnabled()
     {
      return webElement.isEnabled();
     }
     
     public boolean isSelected() {
         return webElement.isSelected();
     }

     public boolean isDisplayed() {
    	 try{
               return webElement.isDisplayed();
    	 }catch(StaleElementReferenceException sere){
                 // WebElement webElement = SeleniumHelper.get().getElement(By.id(id));
                  WebElement webElement = TestcaseHelper.driver.findElement(By.id(id)); 
                  return webElement.isDisplayed();
    	 	}
    	 }


    	 public String getText()
         {
    		 return webElement.getText();
    	 }



    	 public String getAttribute(String attribute) {
    		 return webElement.getAttribute(attribute);
    	 }


     }

