Feature: Pick Up Prepared Prescription Fill
    Scenario: Pick up a prescription fill
        Given the Prescription Fill specified by the given ID is registered
        And the status of the Prescription Fill specified by the given ID is verified
        And a pharmacist exists with the given ID
        When application command pickUpPrescriptionFill is invoked
        Then the Prescription Fill's pick-up summary is set to the provided value
        And the Prescription Fill's status is set to Retrieved
        And the Prescription Fill's retrieval pharmacist ID is set to the given ID
