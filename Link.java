package com.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException; 
import org.openqa.selenium.StaleElementReferenceException; 
import org.openqa.selenium.WebElement;
//import com.va.util.*;
import com.unity.helper.TestcaseHelper;



public final class Link extends PageElement { 
   protected final String id;
   public Link(String id) {
       super(id);
       this.id=id;
   }

   public Link(By by) {
      super(by); 
      this.id=null;
   }

    public void click() {
        new DynamicElementsAction() {
            @Override
            public void doAction() {
                //  new Timer().waitFor(new PageElementIsEnabled(Button.this));
                //  new Timer().waitFor(new PageElementispisplayed(Button.this));
                clickAction();
            }
        }.run(MAX_RETRIES);
    }

  private void clickAction() {
      try{
          webElement.click(); 
      }catch(StaleElementReferenceException sere){
        //  WebElement webElement = SeleniumHelper.get().getElement(By.id(id));          
          WebElement webElement = TestcaseHelper.driver.findElement(By.id(id));
          webElement.click();
      }catch(InvalidElementStateException iese){
         // WebElement webElement = SeleniumHelper.get().getElement(By.id(id));
          WebElement webElement = TestcaseHelper.driver.findElement(By.id(id));
          webElement.click();
      }

  }

}
