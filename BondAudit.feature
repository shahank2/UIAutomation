Feature: BondAuditTest
  So that Audit can be validated
  As a Takara User
  User can edit Attributes or Alias and verify it in Audit Log

Scenario: Attribute Audit Logs
    Given User is able to search for a Bond to edit Attribute
    When User adds Attribute data
    Then User edits for Attributes must be displayed in Audit logs

Scenario: Alias Audit Logs
    Given User is able to search for a Bond to edit Alias
    When User adds Alias data
    Then User edits for Alias must be displayed in Audit logs
