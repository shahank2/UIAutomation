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

public class VerifyBondAliasAuditLogSteps //Verify user edit under Attribute Tab are being captured in Audit logs

{

    @Given("^User is able to search for a Bond to edit Alias$")
    public void searchForBond() throws IOException, InterruptedException
    {
        HomePage homePage = new HomePage();
        EntitySelectPage entitySelectPage = homePage.ClickSearchPage();
        BondSearchPage bondSearchPage = entitySelectPage.Bond();
        bondSearchPage.searchForBondToEditAlias();
        BondDataDetailsPage dataDetailsPage = new BondDataDetailsPage();
        dataDetailsPage.ClickResultRecordToLoadDetails();

    }

    @When("^User adds Alias data$")
    public void enterAttributeDetails() throws InterruptedException

    {
        BondTabSelectionPage tabSelectionPage = new BondTabSelectionPage();
        tabSelectionPage.ClickAliasesTab();
        SaveBondAddedData saveBondAddedData = new SaveBondAddedData();
        saveBondAddedData.testAdditionOfBondAlias();
        saveBondAddedData.EnterBusinessJustification("Testing");
    }

    @Then("^User edits for Alias must be displayed in Audit logs$")

    public void verifyAuditLog() throws InterruptedException
    {
        BondAuditPage auditPage = new BondAuditPage();
        auditPage.SelectAuditOptionAndVerifyAlias("XYZ");
        RevertChangesForAddedBondData revertAddedAlias = new RevertChangesForAddedBondData();
        revertAddedAlias.RevertAliasAdded();
        SaveBondAddedData saveBondAddedData = new SaveBondAddedData();
        saveBondAddedData.EnterBusinessJustification("Reverting");
        auditPage.SelectAuditOptionAndVerifyAlias("Null");
    }


}

