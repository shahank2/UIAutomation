package com.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class BrowserTypeHelper //Method to pick up in init.properties file and pass it BrowserType or Testcase Helper file

{

    public static WebDriver driver;
    public static WebDriver getWebDriver(final String browser, final String remoteSeleniumHub) throws Throwable
    {

        final DesiredCapabilities dCaps = BrowserTypeHelper.getCapabilities(browser);
        dCaps.setJavascriptEnabled(true);

        String useGrid = null ;
        useGrid = PropertyHelper.getPropertiesByKey("USE.GRID");

        if (useGrid.equalsIgnoreCase("TRUE"))
        {
            String gridBrowser = PropertyHelper.getPropertiesByKey("GRID.BROWSER");
            String gridHubPort = PropertyHelper.getPropertiesByKey("GRID.HUB.PORT");

            if (gridBrowser.equalsIgnoreCase("IE"))
            {
                setIEcapabilities(dCaps);
            }

            if (gridBrowser.equalsIgnoreCase("FF"))
            {
                setFFcapabilities(dCaps);
            }

            if (gridBrowser.equalsIgnoreCase("CH"))
            {
                setCHcapabilities(dCaps);
            }

//            dCaps.setCapability("tool.platform",PropertyHelper.getPropertiesByKey("GRID.OS"));
            System.out.println("Following capabilities set : " + dCaps);
            System.out.println("http://" + remoteSeleniumHub +":"+ gridHubPort + "/wd/hub");
            return new RemoteWebDriver(new URL("http://" + remoteSeleniumHub + ":" + gridHubPort + "/wd/hub"), dCaps);

        } else
        {
            if (browser.equalsIgnoreCase("ff"))
            {

                FirefoxProfile myprofile = setFFcapabilities(dCaps);
                driver = new FirefoxDriver(myprofile);

            }
            else if (browser.equalsIgnoreCase("ie"))
            {
                File file = new File("drivers/IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//                String configPath = System.getProperty("user.dir") + "/drivers/";
//                System.setProperty("webdriver.ie.driver", configPath+"/IEDriverServer.exe");
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                ieCapabilities.setCapability("ignoreZoomSetting", true);
                ieCapabilities.setCapability("nativeEvents", false);
                driver = new InternetExplorerDriver(ieCapabilities);
                driver.manage().deleteAllCookies();
            }
            else if (browser.equalsIgnoreCase("ch"))
            {
                File file = new File("drivers/CHDriverServer.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//                String configPath = System.getProperty("user.dir") + "/drivers/";
//                System.setProperty("webdriver.chrome.driver", configPath+"/chromedriver.exe");
                DesiredCapabilities chCapabilities = DesiredCapabilities.chrome();
                chCapabilities.setCapability("ignoreZoomSetting", true);
                chCapabilities.setCapability("nativeEvents", false);
                driver = new ChromeDriver(chCapabilities);
                driver.manage().deleteAllCookies();
            }

            return driver;
        }

    }

    private static DesiredCapabilities getCapabilities(final String browser)
    {

        final BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());

        switch (browserType)
        {
            case FF:
                return DesiredCapabilities.firefox();
            case IE:
                return DesiredCapabilities.internetExplorer();
            case CH:
                return DesiredCapabilities.chrome();
//            case HEADLESS:
//                return DesiredCapabilities.phantomjs();
            default:
                // Use IE by default
                return DesiredCapabilities.internetExplorer();
        }
    }

    public enum BrowserType
    {
        FF, IE, CH, //HEADLESS
    }

    private static void setIEcapabilities(DesiredCapabilities dCaps)
    {
        dCaps.setBrowserName("internet explorer");
        dCaps.setCapability("ignoreZoomSetting", true);
        dCaps.setCapability("nativeEvents", false);
        dCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        File file = new File("drivers/IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//        System.out.println("IE driver :" + System.getProperty("webdriver.ie.driver"));
    }

    private static FirefoxProfile setFFcapabilities(DesiredCapabilities dCaps)
    {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        dCaps.setCapability(FirefoxDriver.PROFILE,myprofile);
        dCaps.setBrowserName("firefox");
        return myprofile;
    }

    private static void setCHcapabilities(DesiredCapabilities dCaps)
    {
        dCaps.setBrowserName("chrome");
        File file = new File("drivers/CHDriverServer.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        System.out.println("CH driver :" + System.getProperty("webdriver.chrome.driver"));
    }

}
