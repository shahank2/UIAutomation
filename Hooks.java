package com.steps;

import com.helper.TestcaseHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import javax.mail.MessagingException;
import java.io.IOException;


/**
 * Created by shahank2 on 1/4/2017.
 */
public class Hooks //Hooks class is invoked before and after every scenario is executed

{

    @Before //This runs before every scenario
    public void  start() throws Throwable
    {

        TestcaseHelper.setup();
    }


    @After  //This runs after every scenario
    public void  end(Scenario scenario) throws IOException, MessagingException

    {
        TestcaseHelper.takeScreenshot(scenario);
        TestcaseHelper.tearDown();
    }
}
