package com.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unity.helper.TestcaseHelper;

public class InputTextBox extends PageElement {

	public InputTextBox (String id){
		super(id);
	}
	
	public InputTextBox(By id) {
		super(id);
	}

	public void clear(){
		webElement.clear();
	}
	
	public void setValue(String text)  {
		webElement.sendKeys(text);
	}

	public void Click() {
		webElement.click();
	}

//	public void typeAndSetTextFromAutopopulate(String text){
//		webElement.sendKeys(text);
//		new Timer().waitForTime(2000);
//		webElement.sendKeys(Keys.ARROW_DOWN);
//		new Timer().waitForTime(1000);
//		webElement.sendKeys(Keys.ENTER);
//	}

	public String getvalue(){

		if (webElement.getAttribute("value") == null || webElement.getAttribute("value") == "") {
				return "BLANK";
	}else{
		return webElement.getAttribute("value");
		}
	}
}