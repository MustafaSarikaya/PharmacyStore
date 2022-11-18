Feature: Verifying a Patient Identifier
  Scenario: Given identifier matches a registered Patient's name
    Given the given identifier matches a registered Patient's name
    When application command verifyPatientInfo is invoked
    Then the System returns the ID of the registered Patient

  Scenario: Given identifier matches a registered Patient's email
    Given the given identifier matches a registered Patient's email
    When application command verifyPatientInfo is invoked
    Then the System returns the ID of the registered Patient

  Scenario: Given identifier matches a registered Patient's PHIN
    Given the given identifier matches a registered Patient's PHIN
    When application command verifyPatientInfo is invoked
    Then the system returns the same PHIN that was given

  Scenario: Given identifier does not match a registered Patient's name, email or PHIN
    Given the given identifier does not match a registered Patient's name, email or PHIN
    When application command verifyPatientInfo is invoked
    Then the System returns null