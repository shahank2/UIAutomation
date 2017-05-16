package com.helper;

import com.unity.bean.EnvironmentDetails;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class TestcaseHelper   //This is base Class to load and close firefox browser
{
	public static WebDriver driver;
    public static EnvironmentDetails envDetails;


	public static void setup() throws Throwable //This is base method to load browser
	{
        envDetails = new EnvironmentDetails();
        String browser = PropertyHelper.getPropertiesByKey("BROWSER.type");
        String gridIP = PropertyHelper.getPropertiesByKey("GRID.HUB.IP");
        driver =  BrowserTypeHelper.getWebDriver(browser, gridIP);

        String url = envDetails.getRunningEnvironment();
        driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

    public static void tearDown() throws IOException, MessagingException //to close all browser that were open during selenium test run
    {
        driver.quit();
    }


    public static void takeScreenshot(Scenario scenario) throws IOException //Method to Take screenshot on failure

    {
        String filePath = System.getProperty("user.dir") + "/src/test/java/com/unity/screenshot/";
        if (scenario.isFailed())
        {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String imageName = filePath + scenario.getName() + "_" + currentDateTime() + ".png";
            FileUtils.copyFile(screenshot, new File(imageName));
        }

    }
    public static String currentDateTime() //Method to get current Data and time during execution
    {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }


//    public WebDriver getWebDriver()
//    {
//        return driver;
//    }

}




