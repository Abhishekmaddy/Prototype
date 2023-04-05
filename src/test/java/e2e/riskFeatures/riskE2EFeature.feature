Feature: Testing a Unified cl flow

  Scenario: Unified cl flow user completed R1 validation
    Given Unified cl flow user completed R1
    Then validating risk db after R1 execution for e2e customer
    Then validating risk db after Requirement execution for no skip IV customer

  Scenario: Unified cl flow user completed R2 validation
    Given Unified cl flow user completed R1
    Then validating risk db after R1 execution for e2e customer
    Then validating risk db after Requirement execution for no skip IV customer
    Given Unified cl flow user completed R2
    Then risk db validation after R2 execution for e2e customer

  Scenario: Unified cl flow user bolt CL validation
    Given Unified cl flow user completed bolt
    Then validating risk db after bolt execution for e2e customer


  Scenario: Unified cl flow user completed R3 validation
    Given Unified cl flow user completed R1
    Then validating risk db after R1 execution for e2e customer
    Then validating risk db after Requirement execution for no skip IV customer
    Given Unified cl flow user completed R2
    Then risk db validation after R2 execution for e2e customer
    Given Unified cl flow user completed R3
    Then risk db validation after R3 execution

  Scenario: Unified cl flow user completed checkout validation
    Given Unified cl flow user completed R1
    Given Unified cl flow user completed R2
    Given Unified cl flow user completed R3
    Then  RiskValidation after mandate requirement call
    Given Unified cl flow user completed CheckoutV2
    Then  RiskValidation after checkoutV2