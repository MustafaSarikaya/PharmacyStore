Feature: Assessing and Verifying a Prescription Fill
    Scenario: Prescription Fill awaiting verification exists and the assessment is positive
        Given the Prescription Fill specified by the given ID is registered
        And the status of the Prescription Fill specified by the given ID is "prepared"
        And the Pharmacist specified by the given ID is registered
        And the Pharmacist intends to verify the fill
        When application command verifyPrescriptionFill is invoked
        Then the Prescription Fill's status is set to "verified"
        And the Prescription Fill's recorded clinical check is set to the one provided by the Pharmacist
        And the Prescription Fill's clinical check pharmacist ID is set to the given ID
