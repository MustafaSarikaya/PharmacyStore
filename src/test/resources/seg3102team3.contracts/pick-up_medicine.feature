Feature: Pick Up Prepared Prescription Fill
    Scenario: Pick up a prescription fill
        Given the prescription fill exists and is verified
        When application command pickUpPrescriptionFill is invoked
        Then the System sets the Prescription Fill's pick-up summary to the provided value
        And the System sets the Prescription Fill's status to Retrieved
        And the System sets the Prescription Fill's operating agent ID for retrieval to the Pharmacist's
