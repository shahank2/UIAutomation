package com.runner;

/**
 * Created by shahank2 on 12/28/2016.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
//import cucumber.api.java.Before;

@RunWith(Cucumber.class)


//Format to define cucumber parameters : Format of results, target location to steps and location for stories
@CucumberOptions(monochrome = true, format = { "pretty",
        "html:target/cucumber-reports/RegressionTest",
        "json:target/cucumber-reports/RegressionTest.json",
        "junit:target/cucumber-reports/RegressionTest.xml" },
        snippets = SnippetType.CAMELCASE, glue = "com.nomura.unity.takara.steps",
        features = {"classpath:stories"})


public class RegressionTest extends AbstractTestNGCucumberTests //Cucumber class extends TestNG class
{

}


