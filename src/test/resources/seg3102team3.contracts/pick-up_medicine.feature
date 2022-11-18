Feature: Pick Up Prepared Prescription Fill
    Scenario: Pick up a prescription fill
        Given the prescription fill exists and is verified
        When application command pickUpPrescriptionFill is invoked
        Then the Prescription Fill's pick-up summary is set to the provided value
        And the Prescription Fill's status is set to Retrieved
        And the Prescription Fill's retrieval pharmacist ID is set to the given ID
