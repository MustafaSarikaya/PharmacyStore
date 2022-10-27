Feature: Assessing and Verifying a Prescription Fill 
    Scenario: Pharmacist is signed in and Prescription Fill awaiting verification exists and the assessment is positive
        Given the Pharmacist is signed in 
        And a Prescription Fill is awaiting verification
        Then the System notifies the Pharmacist of the Prescription Fill's existence
        When the Pharmacist prompts to assess the Prescription Fill
        Then the System provides a form asking for the assessment and verification result
        When the Pharmacist submits the form
        Given the assessment is positive
        Then the System invokes the verifyPrescriptionFill application command
        And the System sets the Prescription Fill's status to Verified
        And the System sets the Prescription Fill's clinical check findings to the provided justification
        And the System sets the Prescription Fill's operating agent ID for clinical assessment to the Pharmacist's

    Scenario:  Pharmacist is signed in and Prescription Fill awaiting verification exists and the assessment is negative
        Given the Pharmacist is signed in 
        And a Prescription Fill is awaiting verification
        Then the System notifies the Pharmacist of the Prescription Fill's existence
        When the Pharmacist prompts to assess the Prescription Fill
        Then the System provides a form asking for the assessment and verification result
        When the Pharmacist submits the form
        Given the assessment is negative
        Then the System invokes the verifyPrescriptionFill application command
        And the System sets the Prescription Fill's status to Cancelled
        And the System sets the Prescription Fill's clinical check findings to the provided justification
        And the System sets the Prescription Fill's operating agent ID for clinical assessment to the Pharmacist's
