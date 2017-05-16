package com.steps;

import com.pages.Bond.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;

import java.io.IOException;
/**
 * Created by shahank2 on 12/28/2016.
 */
@Test

public class VerifyBondAttributeAuditLogSteps //Verify user edit under Alias Tab are being captured in Audit logs
{

    @Given("^User is able to search for a Bond to edit Attribute$")
    public void searchForBond() throws IOException, InterruptedException
    {

        HomePage homePage = new HomePage();
        EntitySelectPage entitySelectPage = homePage.ClickSearchPage();
        BondSearchPage bondSearchPage = entitySelectPage.Bond();
        bondSearchPage.searchForBondToEditAttribute();
        BondDataDetailsPage dataDetailsPage = new BondDataDetailsPage();
        dataDetailsPage.ClickResultRecordToLoadDetails();

    }

    @When("^User adds Attribute data$")
    public void enterAttributeDetails() throws InterruptedException

    {
        BondTabSelectionPage tabSelectionPage = new BondTabSelectionPage();
        tabSelectionPage.ClickAttributesTab();
        SaveBondAddedData saveBondAddedData = new SaveBondAddedData();
        saveBondAddedData.testAdditionOfBondAttribute();
    }

    @Then("^User edits for Attributes must be displayed in Audit logs$")

    public void verifyAuditLog() throws InterruptedException {
        BondAuditPage auditPage = new BondAuditPage();
        auditPage.SelectAuditOptionAndVerifyAttribute("XYZ");
        RevertChangesForAddedBondData revertAddedAttribute = new RevertChangesForAddedBondData();
        revertAddedAttribute.RevertAttributeAdded();
        auditPage.SelectAuditOptionAndVerifyAttribute("Null");
    }

}

